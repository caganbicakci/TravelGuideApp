package com.caganbicakci.travelguideapp.domain.dialog

import android.content.Context
import android.view.LayoutInflater
import com.caganbicakci.travelguideapp.BR
import com.caganbicakci.travelguideapp.R
import com.caganbicakci.travelguideapp.databinding.DialogSearchResultBinding
import com.caganbicakci.travelguideapp.domain.model.TravelModel
import com.caganbicakci.travelguideapp.handler.TravelClickHandler
import com.caganbicakci.travelguideapp.presentation.search.NearByAttractionsAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog

class SearchDialog {

    companion object {
        fun showSearchResultDialog(
            context: Context,
            clickHandler: TravelClickHandler,
            searchResult: List<TravelModel>
        ) {
            val dialog = BottomSheetDialog(context)
            val view =
                LayoutInflater.from(context).inflate(R.layout.dialog_search_result, null, false)
            val binding = DialogSearchResultBinding.bind(view)
            dialog.setContentView(binding.root)

            val searchAdapter = NearByAttractionsAdapter(searchResult, clickHandler)
            binding.setVariable(BR.searchAdapter, searchAdapter)

            dialog.show()
        }
    }
}