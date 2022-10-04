package com.caganbicakci.travelguideapp.presentation.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.viewModels
import com.caganbicakci.travelguideapp.databinding.FragmentSearchBinding
import com.caganbicakci.travelguideapp.domain.viewmodel.TravelViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var searchFragmentBinding : FragmentSearchBinding
    private val travelViewModel: TravelViewModel by viewModels()

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
                val topDestinationsAdapter = TopDestinationsAdapter(travelList.filter { it.category == "topdestination" })
                setVariable(BR.topDestinationsAdapter, topDestinationsAdapter)

                val nearByAttractionsAdapter = NearByAttractionsAdapter(travelList.filter { it.category == "nearby" })
                setVariable(BR.nearByAttractionsAdapter, nearByAttractionsAdapter)
            }

        }
    }
}