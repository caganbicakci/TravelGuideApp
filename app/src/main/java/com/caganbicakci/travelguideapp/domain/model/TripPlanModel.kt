package com.caganbicakci.travelguideapp.domain.model

import java.util.Date

data class TripPlanModel(
    val city : String,
    val startDate : Date,
    val endDate : Date,
    val dateToStart : String
)
