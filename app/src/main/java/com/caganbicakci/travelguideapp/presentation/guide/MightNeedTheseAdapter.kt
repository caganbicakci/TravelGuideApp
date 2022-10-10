package com.caganbicakci.travelguideapp.presentation.guide

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.caganbicakci.travelguideapp.BR
import com.caganbicakci.travelguideapp.R
import com.caganbicakci.travelguideapp.databinding.ItemMightNeedBinding
import com.caganbicakci.travelguideapp.domain.model.TravelModel
import com.caganbicakci.travelguideapp.handler.TravelClickHandler

class MightNeedTheseAdapter(private val travelList: List<TravelModel>, private val clickHandler: TravelClickHandler) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val mightNeedAdapter = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.item_might_need, parent, false
        )

        return MightNeedItemViewHolder(mightNeedAdapter)
    }

    override fun getItemCount(): Int {
        return travelList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MightNeedItemViewHolder).onBind(travelList[position])
    }

    inner class MightNeedItemViewHolder(
        private val mightNeedItemBinding: ViewDataBinding
    ): RecyclerView.ViewHolder(mightNeedItemBinding.root), OnClickListener {

        fun onBind(travelModel: TravelModel){
            val binding = mightNeedItemBinding as ItemMightNeedBinding
            binding.setVariable(BR.travelModel, travelModel)
        }

        init {
            mightNeedItemBinding.root.setOnClickListener(this)
        }
        override fun onClick(v: View?){
            val position = adapterPosition
            clickHandler.travelItemClicked(travelList[position])
        }

    }

}