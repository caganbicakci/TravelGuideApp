package com.caganbicakci.travelguideapp.presentation.tripplan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.databinding.library.baseAdapters.BR
import com.caganbicakci.travelguideapp.data.localdb.TripPlanRepository
import com.caganbicakci.travelguideapp.databinding.FragmentTripBinding
import com.caganbicakci.travelguideapp.domain.model.TripPlanModel
import com.caganbicakci.travelguideapp.domain.viewmodel.TripPlanViewModel
import com.caganbicakci.travelguideapp.presentation.dialog.bottomsheet.CustomBottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class TripFragment : Fragment() {

    @Inject
    lateinit var repository: TripPlanRepository

    @Inject
    lateinit var tripPlanEntity: TripPlanModel

    private lateinit var tripFragmentBinding: FragmentTripBinding
    private val tripPlanViewModel: TripPlanViewModel by viewModels()

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
    }


    private fun setupRecyclerView() {
        tripFragmentBinding.apply {
            val tripPlanAdapter = TripPlansAdapter(repository.getTripPlans())
            setVariable(BR.tripPlanAdapter, tripPlanAdapter)
        }

    }

    private fun showTripPlanDialog() {
        childFragmentManager.let {
            CustomBottomSheetDialog().show(it, "BottomSheetFragment")
        }
    }
}