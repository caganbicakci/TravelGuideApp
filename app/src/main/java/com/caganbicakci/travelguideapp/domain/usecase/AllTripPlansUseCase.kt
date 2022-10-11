package com.caganbicakci.travelguideapp.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.caganbicakci.travelguideapp.data.localdb.TripPlanRepository
import com.caganbicakci.travelguideapp.domain.model.TripPlanModel
import javax.inject.Inject

class AllTripPlansUseCase @Inject constructor(
    private val tripPlanRepository: TripPlanRepository
) {

    private var _allTripPlans = MutableLiveData<List<TripPlanModel>>()
    val allTripPlans : LiveData<List<TripPlanModel>> = _allTripPlans

    fun getAllTripPlans(){
        _allTripPlans.value = tripPlanRepository.getTripPlans()
    }

    fun addTripPlan(tripPlanModel: TripPlanModel){
        tripPlanRepository.addTripPlan(tripPlanModel)
    }

}