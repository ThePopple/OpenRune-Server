package org.alter.game.pluginnew.event

import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
class EventListener<E : Event>(val type: KClass<E>) {

    private data class Branch<E : Event>(
        val condition: E.() -> Boolean,
        val action: suspend E.() -> Unit
    )

    private val branches = mutableListOf<Branch<E>>()

    private val fallbackListeners = mutableListOf<EventListener<E>>()

    private var pendingCondition: (E.() -> Boolean)? = null
    private var buildingFallback = false

    var singleUse: Boolean = false
    var stack: Array<StackTraceElement> = emptyArray()


    fun where(condition: E.() -> Boolean): EventListener<E> {
        pendingCondition = condition
        return this
    }

    fun then(action: suspend E.() -> Unit): EventListener<E> {
        val condition = pendingCondition ?: { true }

        val branch = Branch(condition, action)

        if (buildingFallback) {
            branches += branch
        } else {
            branches += branch
        }

        pendingCondition = null
        return this
    }

    fun otherwise(config: EventListener<E>.() -> Unit): EventListener<E> {
        val fallback = EventListener(type)
        fallback.buildingFallback = true
        fallback.config()
        fallback.buildingFallback = false
        fallbackListeners += fallback
        return this
    }

    suspend fun execute(event: E) {
        // Check primary branches first
        for (branch in branches) {
            try {
                if (branch.condition(event)) {
                    branch.action(event)
                    return
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
                return
            }
        }

        // Then check fallback listeners in order
        for (listener in fallbackListeners) {
            listener.execute(event)
            // Stop if any branch inside this fallback matched
            if (listener.branches.any { it.condition(event) }) return
        }
    }

    fun submit(): EventListener<E> {
        this.stack = Thread.currentThread().stackTrace
        EventManager.listen(type.java as Class<Event>, this)
        return this
    }

    companion object {

        fun <K : Event> onOnce(
            type: KClass<K>,
            config: EventListener<K>.() -> EventListener<K>
        ): EventListener<K> {
            return config.invoke(EventListener(type).apply { singleUse = true }).submit()
        }

        fun <K : Event> on(
            type: KClass<K>,
            config: EventListener<K>.() -> EventListener<K>
        ): EventListener<K> {
            return config.invoke(EventListener(type)).submit()
        }

        inline fun <reified K : Event> on(
            config: EventListener<K>.() -> EventListener<K>
        ): EventListener<K> {
            return config.invoke(EventListener(K::class)).submit()
        }
    }
}