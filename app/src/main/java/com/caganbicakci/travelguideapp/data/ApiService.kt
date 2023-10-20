package com.caganbicakci.travelguideapp.data

import com.caganbicakci.travelguideapp.domain.model.CategoryModel
import com.caganbicakci.travelguideapp.domain.model.TravelModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("Travels")
    fun getAllTravels(): Call<List<TravelModel>>

    @GET("Categories")
    fun getAllCategories(): Call<List<CategoryModel>>

    @FormUrlEncoded
    @PUT("Travels/{id}")
    fun addOrRemoveTravelToBookmark(
        @Path("id") string: String,
        @Field("bookmark") bookmark: Boolean
    ): Call<TravelModel>

    @GET("Travels")
    fun getBookmarkedTravels(@Query("isBookmark") isBookmark: Boolean) : Call<List<TravelModel>>

}