package com.caganbicakci.travelguideapp.domain.adapter

import android.icu.text.SimpleDateFormat
import android.os.Build
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import java.util.*

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

        @RequiresApi(Build.VERSION_CODES.N)
        @BindingAdapter("formatDate")
        fun TextView.formatDate(date: String) {
            val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            formatter.parse(date)?.also {
                val finalFormatter = SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault())
                text = finalFormatter.format(it)
            }
        }
    }
}