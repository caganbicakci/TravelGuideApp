package com.caganbicakci.travelguideapp.presentation.tripplan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.caganbicakci.travelguideapp.R
import com.caganbicakci.travelguideapp.databinding.FragmentTripBinding
import com.google.android.material.bottomsheet.BottomSheetDialog


class TripFragment : Fragment() {

    private lateinit var tripFragmentBinding : FragmentTripBinding
    private var ctx = context

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
            addTripPlanBtn.setOnClickListener{
                showTripPlanDialog()
            }
        }
    }

    private fun showTripPlanDialog() {
        val dialog = BottomSheetDialog(requireContext())
        dialog.setContentView(R.layout.dialog_trip_plan)
        dialog.show()
    }

}