package com.caganbicakci.travelguideapp.presentation.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.caganbicakci.travelguideapp.BR
import com.caganbicakci.travelguideapp.R
import com.caganbicakci.travelguideapp.databinding.DialogSearchResultBinding
import com.caganbicakci.travelguideapp.databinding.FragmentSearchBinding
import com.caganbicakci.travelguideapp.domain.dialog.SearchDialog
import com.caganbicakci.travelguideapp.domain.model.TravelModel
import com.caganbicakci.travelguideapp.domain.viewmodel.TravelViewModel
import com.caganbicakci.travelguideapp.handler.BookmarkClickHandler
import com.caganbicakci.travelguideapp.handler.TravelClickHandler
import com.caganbicakci.travelguideapp.utils.Constants
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

@AndroidEntryPoint
class SearchFragment : Fragment(), TravelClickHandler, BookmarkClickHandler {

    private lateinit var searchFragmentBinding: FragmentSearchBinding
    private val travelViewModel: TravelViewModel by viewModels()
    private val clickHandler = this

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        searchFragmentBinding = FragmentSearchBinding.inflate(inflater)
        return searchFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchFragmentBinding.apply {
            travelViewModel.allTravels.observe(viewLifecycleOwner) { travelList ->
                val topDestinationsAdapter = TopDestinationsAdapter(
                    travelList.filter { it.category == Constants.TOP_DESTINATIONS },
                    clickHandler
                )
                setVariable(BR.topDestinationsAdapter, topDestinationsAdapter)

                val nearByAttractionsAdapter = NearByAttractionsAdapter(
                    travelList.filter { it.category == Constants.NEAR_BY_ATTRACTIONS },
                    travelClickHandler = clickHandler,
                    bookmarkClickHandler = clickHandler
                )
                setVariable(BR.nearByAttractionsAdapter, nearByAttractionsAdapter)

                searchBar.setEndIconOnClickListener {
                    val searchText = searchBar.editText?.text.toString().lowercase()
                    val searchResult = travelList.filter {
                            it.country.lowercase().contains(searchText) ||
                                it.city.lowercase().contains(searchText) ||
                                    it.description.lowercase().contains(searchText)
                        }

                    SearchDialog.showSearchResultDialog(
                        context = requireContext(),
                        travelClickHandler = clickHandler,
                        bookmarkClickHandler =clickHandler,
                        searchResult = searchResult
                    )
                }
            }
        }
    }

    override fun travelItemClicked(travelModel: TravelModel) {
        findNavController().apply {
            val action = SearchFragmentDirections.actionSearchFragmentToDetailFragment(travelModel)
            navigate(action)
        }
    }

    override fun setBookmarkStatus(id: String, isBookmark: Boolean) {
        travelViewModel.changeBookmarkStatus(id,isBookmark)
    }
}