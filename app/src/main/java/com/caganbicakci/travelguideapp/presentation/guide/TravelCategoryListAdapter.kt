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
import com.caganbicakci.travelguideapp.databinding.ItemCategoryGuideBinding
import com.caganbicakci.travelguideapp.domain.model.CategoryModel
import com.caganbicakci.travelguideapp.handler.CategoryClickHandler

class TravelCategoryListAdapter(private val categoryList: List<CategoryModel>, private val clickHandler: CategoryClickHandler) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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
    ): RecyclerView.ViewHolder(categoryListItemBinding.root), OnClickListener{

        fun onBind(category: CategoryModel){
            val binding = categoryListItemBinding as ItemCategoryGuideBinding
            binding.setVariable(BR.categoryModel, category)
        }

        init{
            categoryListItemBinding.root.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            clickHandler.searchCategoryOnMap(categoryList[position].title)
        }

    }

}