package com.shivamdev.rxviewpagerscroll

import android.os.Handler

/**
 * Created by shivam on 15/6/17.
 */

object MyClass {
    @JvmStatic fun main(args: Array<String>) {
        val handler = Handler()
        val runnable = object : Runnable {
            override fun run() {
                handler.postDelayed(this, 2000)
            }
        }
    }
}
