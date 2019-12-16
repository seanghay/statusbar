package com.seanghay.statusbardemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            attach("one", false)
        }

        one.setOnLongClickListener {
            startActivity(
                Intent(this, DumbActivity::class.java)
            )
            true
        }

        two.setOnLongClickListener {
            OneDialog().show(supportFragmentManager, "one-dialog")
            true
        }

        one.setOnClickListener {
            attach("one")
        }

        two.setOnClickListener {
            attach("two")
        }

        three.setOnClickListener {
            attach("three")
        }
    }

    private fun attach(tag: String, back: Boolean = true) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, getFragment(tag), tag)
            .apply {
                if (back) {
                    addToBackStack(tag)
                }
            }
            .commit()

    }

    private fun getFragment(tag: String): Fragment {
        return supportFragmentManager.findFragmentByTag(tag)
            ?: return when (tag) {
                "one" -> One()
                "two" -> Two()
                "three" -> Three()
                else -> throw RuntimeException()
            }
    }
}
