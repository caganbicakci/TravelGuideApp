package com.caganbicakci.travelguideapp.domain.adapter

import android.icu.text.SimpleDateFormat
import android.os.Build
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.databinding.BindingAdapter
import com.caganbicakci.travelguideapp.R
import com.caganbicakci.travelguideapp.utils.Constants
import com.squareup.picasso.Picasso
import java.util.*

class DataBindingAdapter {

    companion object {
        @JvmStatic
        @BindingAdapter("imageResource")
        fun setImageResource(imageView: ImageView, resource: String) {
            Picasso.get().load(resource).into(imageView)
        }

        @RequiresApi(Build.VERSION_CODES.N)
        @BindingAdapter("formatDate")
        fun TextView.formatDate(date: String) {
            val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            formatter.parse(date)?.also {
                val finalFormatter = SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault())
                text = finalFormatter.format(it)
            }
        }

        @JvmStatic
        @BindingAdapter("categoryIcon")
        fun setCategoryIcon(imageView: ImageView, resource: String) {

            val imageResource = when (resource) {
                Constants.SIGHTSEEING -> R.drawable.ic_shrine_filled
                Constants.RESORT -> R.drawable.ic_wine
                Constants.RESTAURANT -> R.drawable.ic_restaurant
                Constants.MUSEUM -> R.drawable.ic_map
                Constants.MALL -> R.drawable.ic_hotel
                Constants.TAXI -> R.drawable.ic_taxi
                Constants.RENTCAR -> R.drawable.ic_car
                else -> null
            }
            if (imageResource != null) {
                imageView.setImageResource(imageResource)
            }

        }
    }
}