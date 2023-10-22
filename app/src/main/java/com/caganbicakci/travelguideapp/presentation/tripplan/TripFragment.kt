package com.caganbicakci.travelguideapp.presentation.tripplan

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.caganbicakci.travelguideapp.BR
import com.caganbicakci.travelguideapp.databinding.FragmentTripBinding
import com.caganbicakci.travelguideapp.utils.TripPlanEnum
import com.caganbicakci.travelguideapp.domain.model.TripPlanModel
import com.caganbicakci.travelguideapp.domain.viewmodel.TravelViewModel
import com.caganbicakci.travelguideapp.domain.viewmodel.TripPlanViewModel
import com.caganbicakci.travelguideapp.handler.TripPlanClickHandler
import com.caganbicakci.travelguideapp.presentation.dialog.addtripplan.AddTripPlanDialog
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TripFragment : Fragment(), TripPlanClickHandler {

    private lateinit var tripFragmentBinding: FragmentTripBinding
    private val tripPlanViewModel: TripPlanViewModel by activityViewModels()
    private val travelViewModel: TravelViewModel by activityViewModels()
    private val clickHandler = this

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        tripFragmentBinding = FragmentTripBinding.inflate(inflater)
        return tripFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tripFragmentBinding.apply {
            addTripPlanBtn.setOnClickListener {
                showTripPlanDialog()
            }
            setupRecyclerViewForTripPlans()
        }

        tripFragmentBinding.tabTripsBookmarks.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    TripPlanEnum.TRIPS.ordinal -> setupRecyclerViewForTripPlans()
                    TripPlanEnum.BOOKMARKS.ordinal -> setupRecyclerViewForBookmarks()
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        Log.i("VIEW MODEL",tripPlanViewModel.toString())
    }

    private fun setupRecyclerViewForTripPlans() {
        tripPlanViewModel.allTripPlans.observe(viewLifecycleOwner) {
            tripFragmentBinding.apply {
                tripPlanAdapter = TripPlansAdapter(it,clickHandler)
                setVariable(BR.tripPlanAdapter, tripPlanAdapter)
            }
        }
    }
    private fun setupRecyclerViewForBookmarks() {
        travelViewModel.allTravels.observe(viewLifecycleOwner) { travelList ->
            tripFragmentBinding.apply {
                val bookmarks = mutableListOf<TripPlanModel>()
                for (item in travelList.filter { it.isBookmark }){
                    bookmarks.add(TripPlanModel(tid = 0, title = item.title, description = item.city))
                }
                tripPlanAdapter = TripPlansAdapter(bookmarks,clickHandler)
                setVariable(BR.tripPlanAdapter, tripPlanAdapter)
            }
        }
    }

    private fun showTripPlanDialog() {
        childFragmentManager.let {
            AddTripPlanDialog().show(it, "AddTripPlanDialog")
        }
    }

    override fun tripPlanItemLongClicked(tripPlan: TripPlanModel, position: Int) {
        tripPlanViewModel.removeTripPlan(tripPlan)
    }
}