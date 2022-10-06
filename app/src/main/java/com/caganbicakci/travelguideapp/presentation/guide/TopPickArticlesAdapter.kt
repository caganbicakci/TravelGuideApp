package com.caganbicakci.travelguideapp.presentation.guide

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.caganbicakci.travelguideapp.BR
import com.caganbicakci.travelguideapp.R
import com.caganbicakci.travelguideapp.databinding.ItemTopPickArticlesBinding
import com.caganbicakci.travelguideapp.domain.model.TravelModel

class TopPickArticlesAdapter(private val travelList: List<TravelModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val topArticlesAdapter = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.item_top_pick_articles, parent, false
        )

        return TopPickArticlesViewHolder(topArticlesAdapter)
    }

    override fun getItemCount(): Int {
        return travelList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TopPickArticlesViewHolder).onBind(travelList[position])
    }

    inner class TopPickArticlesViewHolder(
        private val topArticlesItemBinding: ViewDataBinding
    ): RecyclerView.ViewHolder(topArticlesItemBinding.root){

        fun onBind(travelModel: TravelModel){
            val binding = topArticlesItemBinding as ItemTopPickArticlesBinding
            binding.setVariable(BR.travelModel, travelModel)
        }

    }

}