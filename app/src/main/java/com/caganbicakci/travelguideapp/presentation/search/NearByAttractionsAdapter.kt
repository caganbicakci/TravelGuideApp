package com.caganbicakci.travelguideapp.presentation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.caganbicakci.travelguideapp.BR
import com.caganbicakci.travelguideapp.R
import com.caganbicakci.travelguideapp.databinding.ItemNearbyCardBinding
import com.caganbicakci.travelguideapp.domain.model.TravelModel

class NearByAttractionsAdapter(private val travelList: List<TravelModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val nearbyAttractionsItemsBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.item_nearby_card, parent, false
        )
        return NearByAttractionsViewHolder(nearbyAttractionsItemsBinding)
    }

    override fun getItemCount(): Int {
        return travelList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as NearByAttractionsViewHolder).onBind(travelList[position])
    }

    inner class NearByAttractionsViewHolder(
        private val nearByAttractionsItemBinding: ViewDataBinding
    ): RecyclerView.ViewHolder(nearByAttractionsItemBinding.root){

        fun onBind(travelItem: TravelModel){
            val binding = nearByAttractionsItemBinding as ItemNearbyCardBinding
            binding.setVariable(BR.travelModel, travelItem)
        }

    }
}