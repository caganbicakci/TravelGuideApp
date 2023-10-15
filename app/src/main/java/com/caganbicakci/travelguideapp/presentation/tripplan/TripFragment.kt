package com.caganbicakci.travelguideapp.presentation.tripplan

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.caganbicakci.travelguideapp.BR
import com.caganbicakci.travelguideapp.databinding.FragmentTripBinding
import com.caganbicakci.travelguideapp.domain.model.TripPlanModel
import com.caganbicakci.travelguideapp.domain.viewmodel.TripPlanViewModel
import com.caganbicakci.travelguideapp.handler.TripPlanClickHandler
import com.caganbicakci.travelguideapp.presentation.dialog.bottomsheet.CustomBottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TripFragment : Fragment(), TripPlanClickHandler {

    private lateinit var tripFragmentBinding: FragmentTripBinding
    private val tripPlanViewModel: TripPlanViewModel by activityViewModels()
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
        }
        setupRecyclerView()

        Log.i("VIEWMODEL",tripPlanViewModel.toString())
    }

    private fun setupRecyclerView() {
        tripPlanViewModel.allTripPlans.observe(viewLifecycleOwner) {
            tripFragmentBinding.apply {
                tripPlanAdapter = TripPlansAdapter(it,clickHandler)
                setVariable(BR.tripPlanAdapter, tripPlanAdapter)
            }
        }
    }

    private fun showTripPlanDialog() {
        childFragmentManager.let {
            CustomBottomSheetDialog().show(it, "BottomSheetFragment")
        }
    }

    override fun tripPlanItemLongClicked(tripPlan: TripPlanModel, position: Int) {
        tripPlanViewModel.removeTripPlan(tripPlan)
    }
}