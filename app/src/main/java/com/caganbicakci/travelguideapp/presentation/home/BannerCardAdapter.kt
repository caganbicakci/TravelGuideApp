package com.caganbicakci.travelguideapp.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.caganbicakci.travelguideapp.BR
import com.caganbicakci.travelguideapp.R
import com.caganbicakci.travelguideapp.domain.model.BannerItem
import com.caganbicakci.travelguideapp.domain.model.BannerItemList
import com.caganbicakci.travelguideapp.databinding.ItemBannerBinding

class BannerCardAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val bannerItemsBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.item_banner, parent, false
        )

        return BannerViewHolder(bannerItemsBinding)
    }

    override fun getItemCount(): Int {
        return BannerItemList.bannerItems.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as BannerViewHolder).onBind(BannerItemList.bannerItems[position])
    }

    inner class BannerViewHolder(
        private val bannerItemBinding: ViewDataBinding
    ): RecyclerView.ViewHolder(bannerItemBinding.root){

        fun onBind(bannerItem: BannerItem){
            val binding = bannerItemBinding as ItemBannerBinding
            binding.setVariable(BR.bannerItem, bannerItem)
        }

    }

}