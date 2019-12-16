package com.seanghay.statusbar

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.RestrictTo

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
internal class StatusBarController(private val activity: Activity) {

    @get:ColorInt
    var color: Int
        set(value) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                activity.window.statusBarColor = value
            }
        }
        get() {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                activity.window.statusBarColor
            } else Color.BLACK
        }

    var isLight: Boolean
        set(value) {
            if (value) {
                if (containsLightFlag()) return
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    activity.window.decorView.systemUiVisibility =
                        activity.window.decorView.systemUiVisibility or
                                View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                }
            } else {

                if (!containsLightFlag()) {
                    return
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    activity.window.decorView.systemUiVisibility =
                        activity.window.decorView.systemUiVisibility and
                                View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
                }
            }
        }
        get() = containsLightFlag()

    private fun containsLightFlag(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            activity.window.decorView.systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR != 0
        } else {
            false
        }
    }

}
