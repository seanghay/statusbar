package com.seanghay.statusbar

import android.graphics.Color
import androidx.annotation.RestrictTo
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import java.util.*


@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
class FragmentStatusBar(
    private val fragment: Fragment
) : LifecycleObserver {

    private val controller = StatusBarController(fragment.activity!!)
    private var color: Int? = null
    private var isLight: Boolean? = null

    init {
        configStack.push(getPreviousConfig())
    }

    fun setColor(color: Int) {
        this.color = color
        controller.color = color
    }

    fun setLight(isLight: Boolean) {
        this.isLight = isLight
        controller.isLight = isLight
    }

    private fun getPreviousConfig(): StatusBarConfig? {
        return StatusBarConfig(controller.color, controller.isLight)
    }

    private fun pop() {
        if (configStack.empty()) return
        val config = configStack.pop()
        controller.color = config.color
        controller.isLight = config.isLight
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        push()
        pop()
    }


    private fun push() {
        configStack.push(StatusBarConfig(color ?: Color.BLACK, isLight ?: false))
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        pop()
    }


    companion object {
        @JvmStatic
        private val configStack: Stack<StatusBarConfig> = Stack()
    }
}
