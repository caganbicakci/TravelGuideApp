package com.caganbicakci.travelguideapp.data

import com.caganbicakci.travelguideapp.domain.model.CategoryModel
import com.caganbicakci.travelguideapp.domain.model.TravelModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PUT

interface ApiService {

    @GET("Travels")
    fun getAllTravels() : Call<List<TravelModel>>

    @GET("Categories")
    fun getAllCategories() : Call<List<CategoryModel>>

}