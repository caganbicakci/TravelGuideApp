package com.caganbicakci.travelguideapp.presentation.tripplan

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.caganbicakci.travelguideapp.BR
import com.caganbicakci.travelguideapp.R
import com.caganbicakci.travelguideapp.databinding.ItemTripPlanCardBinding
import com.caganbicakci.travelguideapp.domain.model.TripPlanModel
import com.caganbicakci.travelguideapp.handler.TripPlanClickHandler

class TripPlansAdapter (private val tripPlanList: List<TripPlanModel>, private val clickHandler: TripPlanClickHandler) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val tripPlanItemsBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.item_trip_plan_card, parent, false
        )
        return TripPlanItemViewHolder(tripPlanItemsBinding)
    }

    override fun getItemCount(): Int {
        return tripPlanList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TripPlanItemViewHolder).onBind(tripPlanList[position])
    }

    inner class TripPlanItemViewHolder(
        private val tripPlanItemItemBinding: ViewDataBinding
    ): RecyclerView.ViewHolder(tripPlanItemItemBinding.root), OnLongClickListener{

        init {
            tripPlanItemItemBinding.root.setOnLongClickListener(this)
        }

        fun onBind(tripPlan: TripPlanModel){
            val binding = tripPlanItemItemBinding as ItemTripPlanCardBinding
            binding.setVariable(BR.tripPlanModel, tripPlan)
        }

        override fun onLongClick(p0: View?): Boolean {

            val position = adapterPosition
            clickHandler.tripPlanItemLongClicked(tripPlanList[position], position)
            return true
        }

    }
}