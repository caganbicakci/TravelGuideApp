package com.caganbicakci.travelguideapp.domain.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.caganbicakci.travelguideapp.data.localdb.TripPlanRepository
import com.caganbicakci.travelguideapp.domain.model.TravelModel
import com.caganbicakci.travelguideapp.domain.model.TripPlanModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TripPlanViewModel @Inject constructor(private val tripPlanRepository: TripPlanRepository) :
    ViewModel() {

    private var _allTripPlans = MutableLiveData<MutableList<TripPlanModel>>()
    val allTripPlans : LiveData<MutableList<TripPlanModel>> = _allTripPlans

    init {
        fetchTripPlanData()
    }

    private fun getAllTripPlansFromRepository(): MutableList<TripPlanModel> {
        return tripPlanRepository.getTripPlans()
    }

    fun addTripPlan(tripPlan: TripPlanModel) = viewModelScope.launch {
        tripPlanRepository.apply {
            addTripPlan(tripPlan)
            fetchTripPlanData()
        }
    }

    fun removeTripPlan(tripPlan: TripPlanModel) = viewModelScope.launch {
        tripPlanRepository.apply {
            removeTripPlan(tripPlan)
            fetchTripPlanData()
        }
    }

    private fun fetchTripPlanData() = viewModelScope.launch {
        _allTripPlans.value = getAllTripPlansFromRepository()
    }
}
