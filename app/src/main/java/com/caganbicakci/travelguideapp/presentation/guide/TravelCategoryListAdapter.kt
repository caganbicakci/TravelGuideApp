package com.caganbicakci.travelguideapp.presentation.guide

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.caganbicakci.travelguideapp.BR
import com.caganbicakci.travelguideapp.R
import com.caganbicakci.travelguideapp.databinding.ItemCategoryGuideBinding
import com.caganbicakci.travelguideapp.domain.model.CategoryModel

class TravelCategoryListAdapter(private val categoryList: List<CategoryModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val categoryListAdapter = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.item_category_guide, parent, false
        )

        return CategoryListItemViewHolder(categoryListAdapter)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CategoryListItemViewHolder).onBind(categoryList[position])
    }

    inner class CategoryListItemViewHolder(
        private val categoryListItemBinding: ViewDataBinding
    ): RecyclerView.ViewHolder(categoryListItemBinding.root){

        fun onBind(category: CategoryModel){
            val binding = categoryListItemBinding as ItemCategoryGuideBinding
            binding.setVariable(BR.categoryModel, category)
        }

    }

}