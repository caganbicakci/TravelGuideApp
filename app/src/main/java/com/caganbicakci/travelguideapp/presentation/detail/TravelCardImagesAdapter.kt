package com.caganbicakci.travelguideapp.presentation.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.caganbicakci.travelguideapp.BR
import com.caganbicakci.travelguideapp.R
import com.caganbicakci.travelguideapp.databinding.ItemMightNeedBinding
import com.caganbicakci.travelguideapp.databinding.ItemTravelImageCardBinding
import com.caganbicakci.travelguideapp.domain.model.Image

class TravelCardImagesAdapter(private val imageList: List<Image>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val travelImageCardAdapter = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.item_travel_image_card, parent, false
        )

        return TravelCardImageViewHolder(travelImageCardAdapter)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TravelCardImageViewHolder).onBind(imageList[position])
    }

    inner class TravelCardImageViewHolder(
        private val travelImageCardBinding: ViewDataBinding
    ): RecyclerView.ViewHolder(travelImageCardBinding.root){

        fun onBind(image: Image){
            val binding = travelImageCardBinding as ItemTravelImageCardBinding
            binding.setVariable(BR.travelImage, image)
        }

    }
}