package com.test.alodokter.common

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.smarteist.autoimageslider.SliderView
import com.test.alodokter.R
import com.test.alodokter.domain.models.ImageList
import com.test.alodokter.ui.main.ui.home.detail.SliderAdapter
import com.test.alodokter.utils.GlideApp

object CommonSetter {

    @kotlin.jvm.JvmStatic
    @BindingAdapter("isVisible")
    fun setIsVisible(view: View, isVisible: Boolean?) {
        if (isVisible == null) {
            return
        }
        view.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    @JvmStatic
    @BindingAdapter("imageSource")
    fun imageSource(view: ImageView, imageSource: Int) {
        view.setImageResource(imageSource)
    }

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun imageSourceUrl(view: ImageView, url: String) {
        if (url.isNullOrEmpty()) {
            GlideApp.with(view.context).load(R.drawable.error_image).into(view)
        } else {
            GlideApp.with(view.context)
                    .load(url)
                    .centerCrop()
                    .placeholder(R.drawable.loading_image)
                    .into(view);
        }
    }

    @JvmStatic
    @BindingAdapter("setAdapterSlider")
    fun setAdapterSlider(sliderView: SliderView, data: ArrayList<ImageList>) {
        sliderView.setSliderAdapter(SliderAdapter(data))
    }

}