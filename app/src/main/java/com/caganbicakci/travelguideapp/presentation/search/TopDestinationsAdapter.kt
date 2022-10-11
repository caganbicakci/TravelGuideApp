package com.caganbicakci.travelguideapp.presentation.search

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.caganbicakci.travelguideapp.BR
import com.caganbicakci.travelguideapp.R
import com.caganbicakci.travelguideapp.databinding.ItemTopDestinationsCardBinding
import com.caganbicakci.travelguideapp.domain.model.TravelModel
import com.caganbicakci.travelguideapp.handler.TravelClickHandler

class TopDestinationsAdapter(private val travelList: List<TravelModel>, private val clickHandler: TravelClickHandler) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val topDestinationItemsBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.item_top_destinations_card, parent, false
        )
        return TopDestinationsViewHolder(topDestinationItemsBinding)
    }

    override fun getItemCount(): Int {
        return travelList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TopDestinationsViewHolder).onBind(travelList[position])
    }

    inner class TopDestinationsViewHolder(
        private val topDestinationsItemBinding: ViewDataBinding
    ): RecyclerView.ViewHolder(topDestinationsItemBinding.root), OnClickListener{

        fun onBind(travelItem: TravelModel){
            val binding = topDestinationsItemBinding as ItemTopDestinationsCardBinding
            binding.setVariable(BR.travelModel, travelItem)
        }
        init {
            topDestinationsItemBinding.root.setOnClickListener(this)
        }
        override fun onClick(v: View?){
            val position = adapterPosition
            clickHandler.travelItemClicked(travelList[position])
        }

    }
}