package com.seanghay.statusbar

import androidx.annotation.ColorInt
import androidx.annotation.RestrictTo

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
data class StatusBarConfig(@ColorInt var color: Int, var isLight: Boolean)
