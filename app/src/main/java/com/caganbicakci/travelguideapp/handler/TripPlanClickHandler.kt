package com.caganbicakci.travelguideapp.handler

import com.caganbicakci.travelguideapp.domain.model.TripPlanModel

interface TripPlanClickHandler {
    fun tripPlanItemLongClicked(tripPlan: TripPlanModel, position: Int)
}