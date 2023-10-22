package com.caganbicakci.travelguideapp.presentation.dialog.addtripplan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import com.caganbicakci.travelguideapp.R
import com.caganbicakci.travelguideapp.databinding.DialogTripPlanBinding
import com.caganbicakci.travelguideapp.domain.model.TripPlanModel
import com.caganbicakci.travelguideapp.domain.viewmodel.TripPlanViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddTripPlanDialog () : BottomSheetDialogFragment() {
    private val tripPlanViewModel: TripPlanViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val dialogTripPlanBinding : DialogTripPlanBinding = DialogTripPlanBinding.inflate(layoutInflater)
        dialogTripPlanBinding.apply {
            saveTripPlan.setOnClickListener {
                val tripPlan = TripPlanModel(
                    tid = 0,
                    title = locationEditText.text.toString(),
                    description = titleEditText.text.toString()
                )
                tripPlanViewModel.addTripPlan(tripPlan)
                dismiss()
            }
        }
        dialog?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        return dialogTripPlanBinding.root
    }
}