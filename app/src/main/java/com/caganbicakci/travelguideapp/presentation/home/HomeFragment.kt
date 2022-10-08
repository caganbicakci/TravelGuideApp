package com.caganbicakci.travelguideapp.presentation.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.caganbicakci.travelguideapp.BR
import com.caganbicakci.travelguideapp.DetailActivity
import com.caganbicakci.travelguideapp.databinding.FragmentHomeBinding
import com.caganbicakci.travelguideapp.domain.model.TravelModel
import com.caganbicakci.travelguideapp.domain.viewmodel.TravelViewModel
import com.caganbicakci.travelguideapp.handler.TravelClickHandler
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), TravelClickHandler {

    private lateinit var homeFragmentBinding: FragmentHomeBinding
    private val travelViewModel: TravelViewModel by viewModels()
    private val clickHandler = this

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        homeFragmentBinding = FragmentHomeBinding.inflate(inflater)
        return homeFragmentBinding.root
    }

    override fun travelItemClicked(travelModel: TravelModel) {

        findNavController().apply {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailActivity(travelModel)
            navigate(action)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        travelViewModel.getAllTravels().observe(viewLifecycleOwner) { travelList ->
            homeFragmentBinding.apply {
                val layoutManager = GridLayoutManager(
                    activity,
                    1,
                    GridLayoutManager.HORIZONTAL,
                    false
                )
                val bannerAdapter = BannerCardAdapter()
                bannerRecyclerView.layoutManager = layoutManager
                setVariable(BR.bannerAdapter, bannerAdapter)

                val dealsCardAdapter = DealsCardAdapter(travelList, clickHandler)
                setVariable(BR.dealsAdapter, dealsCardAdapter)

                //TODO(Category tab view get trip by category functionality)

            }

        }

    }
}