package com.caganbicakci.travelguideapp.domain.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

class DataBindingAdapter {
    /**
     * binding adapter for handle to set network image resource with picasso.
     */

    companion object {
        @JvmStatic
        @BindingAdapter("imageResource")
        fun setImageResource(imageView: ImageView, resource: String) {
            Picasso.get().load(resource).into(imageView)
        }
    }
}