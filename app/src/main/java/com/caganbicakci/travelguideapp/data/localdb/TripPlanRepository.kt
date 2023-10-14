package com.caganbicakci.travelguideapp.data.localdb

import com.caganbicakci.travelguideapp.domain.model.TripPlanModel
import javax.inject.Inject

class TripPlanRepository @Inject constructor(private val tripPlanDao: TripPlanDao) {

    fun addTripPlan(tripPlan: TripPlanModel) = tripPlanDao.insertTripPlan(tripPlan)

    fun getTripPlans() : MutableList<TripPlanModel> {
        return tripPlanDao.getAllTripPlans()
    }

    fun removeTripPlan(tripPlan: TripPlanModel) = tripPlanDao.deleteTripPlan(tripPlan)

}