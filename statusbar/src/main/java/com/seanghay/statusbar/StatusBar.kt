package com.seanghay.statusbar

import androidx.fragment.app.Fragment

fun Fragment.statusBar(): StatusBar {
    return StatusBar(this)
}

class StatusBar(fragment: Fragment) {

    private val fragmentStatusBar = FragmentStatusBar(fragment)

    init { fragment.lifecycle.addObserver(fragmentStatusBar) }

    fun color(color: Int): StatusBar {
        fragmentStatusBar.setColor(color)
        return this
    }

    fun light(isLight: Boolean): StatusBar {
        fragmentStatusBar.setLight(isLight)
        return this
    }

}