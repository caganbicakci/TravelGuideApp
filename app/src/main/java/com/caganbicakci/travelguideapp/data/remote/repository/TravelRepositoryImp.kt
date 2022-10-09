package com.caganbicakci.travelguideapp.data.remote.repository

import com.caganbicakci.travelguideapp.data.ApiService
import com.caganbicakci.travelguideapp.domain.model.CategoryModel
import com.caganbicakci.travelguideapp.domain.model.TravelModel
import com.caganbicakci.travelguideapp.domain.repository.TravelRepository
import retrofit2.Call

class TravelRepositoryImp(private val apiService: ApiService) : TravelRepository{
    override fun getAllTravels(): Call<List<TravelModel>> {
        return apiService.getAllTravels()
    }

    override fun getAllCategories(): Call<List<CategoryModel>> {
        return apiService.getAllCategories()
    }

}