package com.caganbicakci.travelguideapp.domain.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.caganbicakci.travelguideapp.domain.model.TripPlanModel
import com.caganbicakci.travelguideapp.domain.usecase.AllTripPlansUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TripPlanViewModel @Inject constructor(private val allTripPlansUseCase: AllTripPlansUseCase) :
    ViewModel() {

    init {
        getAllTripPlans()
    }

    fun getAllTripPlans(): LiveData<List<TripPlanModel>> {
        allTripPlansUseCase.apply {
            getAllTripPlans()
            return allTripPlans
        }
    }

    fun addTripPlan(tripPlan: TripPlanModel) = viewModelScope.launch(){
        allTripPlansUseCase.apply {
            addTripPlan(tripPlan)
        }
    }
}
