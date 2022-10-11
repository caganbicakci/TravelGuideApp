package com.caganbicakci.travelguideapp.domain.repository

import com.caganbicakci.travelguideapp.domain.model.CategoryModel
import com.caganbicakci.travelguideapp.domain.model.TravelModel
import retrofit2.Call

interface TravelRepository {
    fun getAllTravels(): Call<List<TravelModel>>

    fun getAllCategories(): Call<List<CategoryModel>>
    fun changeBookmark(id: String, bookmark: Boolean)
}