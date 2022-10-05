package com.caganbicakci.travelguideapp.domain.model

import java.util.Date

data class TripPlanModel(
    val location : String,
    val startDate : Date,
    val endDate : Date,
    val description: String,
    val tripPlanItems: List<String>
)