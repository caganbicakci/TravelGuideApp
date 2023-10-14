package com.caganbicakci.travelguideapp.presentation.dialog.bottomsheet

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.caganbicakci.travelguideapp.BR
import com.caganbicakci.travelguideapp.R
import com.caganbicakci.travelguideapp.domain.model.TripPlanModel
import com.caganbicakci.travelguideapp.domain.viewmodel.TripPlanViewModel
import com.caganbicakci.travelguideapp.presentation.tripplan.TripPlansAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CustomBottomSheetDialog () : BottomSheetDialogFragment() {
    private val tripPlanViewModel: TripPlanViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val bottomSheet: View = inflater.inflate(R.layout.dialog_trip_plan, container, false)
        val tripPlanFragment: View = inflater.inflate(R.layout.fragment_trip, container, false)
        val btnSaveTripPlan: Button = bottomSheet.findViewById(R.id.saveTripPlan) as Button
        val etLocation: EditText = bottomSheet.findViewById(R.id.locationEditText) as EditText
        val etTitle: EditText = bottomSheet.findViewById(R.id.titleEditText) as EditText

        btnSaveTripPlan.setOnClickListener {
            val tripPlan = TripPlanModel(
                tid = 0,
                title = etLocation.text.toString(),
                description = etTitle.text.toString()
            )
            tripPlanViewModel.addTripPlan(tripPlan)
            dismiss()
        }

        dialog?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        return bottomSheet
    }
}