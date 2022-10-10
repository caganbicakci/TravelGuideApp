package com.caganbicakci.travelguideapp.presentation.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.caganbicakci.travelguideapp.databinding.FragmentSearchBinding
import com.caganbicakci.travelguideapp.domain.model.TravelModel
import com.caganbicakci.travelguideapp.domain.viewmodel.TravelViewModel
import com.caganbicakci.travelguideapp.handler.TravelClickHandler
import com.caganbicakci.travelguideapp.presentation.home.HomeFragmentDirections
import com.caganbicakci.travelguideapp.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment(), TravelClickHandler {

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

        travelViewModel.getAllTravels().observe(viewLifecycleOwner) { travelList ->
            searchFragmentBinding.apply {
                val topDestinationsAdapter = TopDestinationsAdapter(
                    travelList.filter { it.category == Constants.TOP_DESTINATIONS },
                    clickHandler
                )
                setVariable(BR.topDestinationsAdapter, topDestinationsAdapter)

                val nearByAttractionsAdapter = NearByAttractionsAdapter(
                    travelList.filter { it.category == Constants.NEAR_BY_ATTRACTIONS },
                    clickHandler
                )
                setVariable(BR.nearByAttractionsAdapter, nearByAttractionsAdapter)
            }

        }
    }

    override fun travelItemClicked(travelModel: TravelModel) {
        findNavController().apply {
            val action = SearchFragmentDirections.actionSearchFragmentToDetailActivity(travelModel)
            navigate(action)
        }
    }
}