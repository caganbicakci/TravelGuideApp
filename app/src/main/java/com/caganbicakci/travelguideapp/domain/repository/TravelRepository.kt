package com.caganbicakci.travelguideapp.domain.repository

import com.caganbicakci.travelguideapp.domain.model.TravelModel
import retrofit2.Call

interface TravelRepository {
    fun getAllTravels(): Call<List<TravelModel>>
}