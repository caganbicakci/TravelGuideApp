package com.caganbicakci.travelguideapp.data

import com.caganbicakci.travelguideapp.domain.model.TravelModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("AllTravelList")
    fun getAllTravels() : Call<List<TravelModel>>
}