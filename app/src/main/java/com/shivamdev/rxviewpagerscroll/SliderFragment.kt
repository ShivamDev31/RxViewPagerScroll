package com.shivamdev.rxviewpagerscroll

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by shivam on 15/6/17.
 */
class SliderFragment : Fragment() {

    companion object {
        val IMAGE_KEY = "image_key"
        fun newInstance(imageDrawable: Int): SliderFragment {
            val sliderFragment = SliderFragment()
            val args = Bundle()
            args.putInt(IMAGE_KEY, imageDrawable)
            sliderFragment.arguments = args
            return sliderFragment
        }
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_slider, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sliderImage = view?.findViewById(R.id.iv_slider_image) as ImageView
        val imageDrawable = arguments.getInt(IMAGE_KEY)
        Glide.with(activity)
                .load(imageDrawable)
                .skipMemoryCache(true)
                .fitCenter()
                .centerCrop()
                .into(sliderImage)

    }
}