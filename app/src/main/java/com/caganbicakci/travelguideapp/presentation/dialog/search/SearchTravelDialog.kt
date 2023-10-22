package com.caganbicakci.travelguideapp.presentation.dialog.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.caganbicakci.travelguideapp.BR
import com.caganbicakci.travelguideapp.databinding.DialogSearchResultBinding
import com.caganbicakci.travelguideapp.domain.model.TravelModel
import com.caganbicakci.travelguideapp.handler.BookmarkClickHandler
import com.caganbicakci.travelguideapp.handler.TravelClickHandler
import com.caganbicakci.travelguideapp.presentation.search.NearByAttractionsAdapter
import com.caganbicakci.travelguideapp.presentation.search.SearchFragmentDirections
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SearchTravelDialog(travelSearchResult: List<TravelModel>) : BottomSheetDialogFragment(), TravelClickHandler, BookmarkClickHandler {

    private lateinit var _travelSearchResult: List<TravelModel>
    init {
        _travelSearchResult = travelSearchResult
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val searchResultBinding : DialogSearchResultBinding = DialogSearchResultBinding.inflate(layoutInflater)
        if(_travelSearchResult.isNotEmpty()){
            val searchAdapter =
                NearByAttractionsAdapter(_travelSearchResult, this, this)
            searchResultBinding.setVariable(BR.searchAdapter,searchAdapter)
        }
        return searchResultBinding.root
    }

    override fun travelItemClicked(travelModel: TravelModel) {
        findNavController().apply {
            val action = SearchFragmentDirections.actionSearchFragmentToDetailFragment(travelModel)
            navigate(action)
        }
    }

    override fun setBookmarkStatus(id: String, isBookmark: Boolean) { }
}