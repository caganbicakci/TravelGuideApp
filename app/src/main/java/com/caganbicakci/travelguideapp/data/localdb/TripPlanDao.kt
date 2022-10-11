package com.caganbicakci.travelguideapp.data.localdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.caganbicakci.travelguideapp.domain.model.TripPlanModel
import com.caganbicakci.travelguideapp.utils.Constants.Companion.TRIP_PLAN_TABLE

@Dao
interface TripPlanDao {
    @Query("SELECT * FROM $TRIP_PLAN_TABLE ORDER BY tid DESC")
    fun getAllTripPlans(): MutableList<TripPlanModel>

    @Insert
    fun insertTripPlan(tripPlanModel: TripPlanModel)

    @Delete
    fun deleteTripPlan(tripPlanModel: TripPlanModel)
}