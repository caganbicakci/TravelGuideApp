package com.caganbicakci.travelguideapp.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.caganbicakci.travelguideapp.BR
import com.caganbicakci.travelguideapp.R
import com.caganbicakci.travelguideapp.databinding.ItemDealsCardBinding
import com.caganbicakci.travelguideapp.domain.model.TravelModel

class DealsCardAdapter(private val travelList: List<TravelModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var allTravels : List<TravelModel> = listOf()
    private var categoricalTravelList : List<TravelModel> = listOf()

    fun setData(data: List<TravelModel>) {
        this.allTravels = data
        showListByCatagory("all")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val dealsItemBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.item_deals_card, parent, false
        )

        return DealsViewHolder(dealsItemBinding)
    }

    override fun getItemCount(): Int {
        return travelList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as DealsViewHolder).onBind(travelList[position])
    }

    fun showListByCatagory(category: String){

        when(category){
            "All" -> this.categoricalTravelList = travelList

            "Flights" -> this.categoricalTravelList = travelList.filter { it.category == "Flights" }

            "Hotels" -> this.categoricalTravelList = travelList.filter { it.category == "Hotels" }

            "Transportations" -> this.categoricalTravelList = travelList.filter { it.category == "Transportations" }

            else -> this.categoricalTravelList = travelList
        }

        notifyDataSetChanged()
    }

    inner class DealsViewHolder(
        private val dealsItemBinding: ViewDataBinding
    ): RecyclerView.ViewHolder(dealsItemBinding.root){

        fun onBind(dealsItem: TravelModel){
            val binding = dealsItemBinding as ItemDealsCardBinding
            binding.setVariable(BR.travelModel, dealsItem)
        }

    }

}