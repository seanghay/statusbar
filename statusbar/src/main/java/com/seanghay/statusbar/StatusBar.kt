package com.seanghay.statusbar

import androidx.fragment.app.Fragment

val Fragment.statusBar: StatusBar get() = StatusBar.with(this)

class StatusBar private constructor(fragment: Fragment) {

    private val fragmentStatusBar = FragmentStatusBar(fragment)

    init {
        fragment.lifecycle.addObserver(fragmentStatusBar)
    }

    fun color(color: Int): StatusBar {
        fragmentStatusBar.setColor(color)
        return this
    }

    fun light(isLight: Boolean): StatusBar {
        fragmentStatusBar.setLight(isLight)
        return this
    }

    companion object {
        @JvmStatic
        fun with(fragment: Fragment): StatusBar {
            return StatusBar(fragment)
        }
    }
}