package com.caganbicakci.travelguideapp.presentation.alltravels

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.caganbicakci.travelguideapp.BR
import com.caganbicakci.travelguideapp.R
import com.caganbicakci.travelguideapp.databinding.ItemAllTravelsBinding
import com.caganbicakci.travelguideapp.databinding.ItemTopPickArticlesBinding
import com.caganbicakci.travelguideapp.domain.model.TravelModel
import com.caganbicakci.travelguideapp.handler.TravelClickHandler

class AllTravelsAdapter(
    private val travelList: List<TravelModel>,
    private val clickHandler: TravelClickHandler
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val topArticlesAdapter = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.item_all_travels, parent, false
        )

        return AllTravelsItemViewHolder(topArticlesAdapter)
    }

    override fun getItemCount(): Int {
        return travelList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as AllTravelsItemViewHolder).onBind(travelList[position])
    }

    inner class AllTravelsItemViewHolder(
        private val allTravelsItemBinding: ViewDataBinding
    ) : RecyclerView.ViewHolder(allTravelsItemBinding.root), OnClickListener {

        fun onBind(travelModel: TravelModel) {
            val binding = allTravelsItemBinding as ItemAllTravelsBinding
            binding.setVariable(BR.travelModel, travelModel)
        }

        init {
            allTravelsItemBinding.root.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            clickHandler.travelItemClicked(travelList[position])
        }

    }

}