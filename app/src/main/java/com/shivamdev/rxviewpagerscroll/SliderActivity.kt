package com.shivamdev.rxviewpagerscroll

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

class SliderActivity : AppCompatActivity() {

    val INTERVAL_DURATION = 2000L
    val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider)

        val vpSlider = findViewById(R.id.vp_slider) as ViewPager
        val adapter = SliderAdapter(supportFragmentManager)
        vpSlider.adapter = adapter

        /*val autoHandler = Handler()
        val runnable = object : Runnable {
            override fun run() {
                if (vpSlider.currentItem < adapter.count - 1) {
                    vpSlider.currentItem = vpSlider.currentItem + 1
                    autoHandler.postDelayed(this, INTERVAL_DURATION)
                } else {
                    vpSlider.currentItem = 0
                    autoHandler.postDelayed(this, INTERVAL_DURATION)
                }
            }
        }
        autoHandler.postDelayed(runnable, INTERVAL_DURATION)*/

        val subscribe = Observable.interval(INTERVAL_DURATION, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (vpSlider.currentItem < adapter.count - 1) {
                        vpSlider.currentItem = vpSlider.currentItem + 1
                    } else {
                        vpSlider.currentItem = 0
                    }
                })
        compositeDisposable.add(subscribe)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}
