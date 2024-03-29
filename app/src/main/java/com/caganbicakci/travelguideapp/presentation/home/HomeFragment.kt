package com.caganbicakci.travelguideapp.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.caganbicakci.travelguideapp.BR
import com.caganbicakci.travelguideapp.databinding.FragmentHomeBinding
import com.caganbicakci.travelguideapp.domain.model.TravelModel
import com.caganbicakci.travelguideapp.domain.viewmodel.TravelViewModel
import com.caganbicakci.travelguideapp.handler.TravelClickHandler
import com.caganbicakci.travelguideapp.utils.Constants
import com.caganbicakci.travelguideapp.utils.DealsCategoryEnum
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), TravelClickHandler {

    private lateinit var homeFragmentBinding: FragmentHomeBinding
    private val clickHandler = this
    private val travelViewModel: TravelViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        homeFragmentBinding = FragmentHomeBinding.inflate(inflater)
        return homeFragmentBinding.root
    }

    override fun travelItemClicked(travelModel: TravelModel) {
        findNavController().apply {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(travelModel)
            navigate(action)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setBannerView()

        homeFragmentBinding.apply {
            travelViewModel.allTravels.observe(viewLifecycleOwner) { travelList ->

                setDealsListAdapter(travelList)

                categoryTabLayout.addOnTabSelectedListener(object :
                    TabLayout.OnTabSelectedListener {
                    override fun onTabSelected(tab: TabLayout.Tab?) {
                        when (tab?.position) {
                            DealsCategoryEnum.ALL.ordinal -> setDealsListAdapter(travelList)
                            DealsCategoryEnum.FLIGHTS.ordinal -> getFlights(travelList)
                            DealsCategoryEnum.HOTELS.ordinal -> getHotels(travelList)
                            DealsCategoryEnum.TRANSPORTATIONS.ordinal -> getTransportations(travelList)
                        }
                    }

                    override fun onTabUnselected(tab: TabLayout.Tab?) {}

                    override fun onTabReselected(tab: TabLayout.Tab?) {}
                })
            }
        }

    }

    private fun getFlights(dealsList: List<TravelModel>) {
        val dealsListByCategory = dealsList.filter { it.category == Constants.FLIGHTS_QUERY }
        setDealsListAdapter(dealsListByCategory)
    }

    private fun getHotels(dealsList: List<TravelModel>) {
        val dealsListByCategory = dealsList.filter { it.category == Constants.HOTELS_QUERY }
        setDealsListAdapter(dealsListByCategory)
    }

    private fun getTransportations(dealsList: List<TravelModel>) {
        val dealsListByCategory =
            dealsList.filter { it.category == Constants.TRANSPORTATIONS_QUERY }
        setDealsListAdapter(dealsListByCategory)

    }

    private fun setDealsListAdapter(dealsList: List<TravelModel>) {
        homeFragmentBinding.apply {
            val dealsCardAdapter = DealsCardAdapter(dealsList, clickHandler)
            setVariable(BR.dealsAdapter, dealsCardAdapter)
        }
    }

    private fun setBannerView() {
        homeFragmentBinding.apply {
            val bannerAdapter = BannerCardAdapter()
            setVariable(BR.bannerAdapter, bannerAdapter)
        }
    }

}