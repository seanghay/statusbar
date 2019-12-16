package com.seanghay.statusbardemo

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialogFragment
import com.seanghay.statusbar.statusBar


class OneDialog : AppCompatDialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        statusBar()
            .color(Color.RED)
            .light(false)
    }
}
