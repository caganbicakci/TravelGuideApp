package com.caganbicakci.travelguideapp.domain.usecase

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.caganbicakci.travelguideapp.domain.model.CategoryModel
import com.caganbicakci.travelguideapp.domain.model.TravelModel
import com.caganbicakci.travelguideapp.domain.repository.TravelRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AllTravelsUseCase @Inject constructor(
    private val travelRepository: TravelRepository
) {
    private var _allTravels = MutableLiveData<List<TravelModel>>()
    private var _allCategories = MutableLiveData<List<CategoryModel>>()

    val allTravels : LiveData<List<TravelModel>> = _allTravels
    val allCategories : LiveData<List<CategoryModel>> = _allCategories

    private var _travelList = listOf<TravelModel>()
    val travelList: List<TravelModel>
        get() = _travelList

    fun getAllTravels(){
        travelRepository.getAllTravels().enqueue(object : Callback<List<TravelModel>> {
            override fun onResponse(
                call: Call<List<TravelModel>>,
                response: Response<List<TravelModel>>
            ) {
                _allTravels.value = response.body()
                if(response.body() != null){
                    _travelList = response.body()!!
                }

            }

            override fun onFailure(call: Call<List<TravelModel>>, t: Throwable) {
                Log.v("TRAVELS ERROR",t.message.toString())
            }

        })
    }

    fun getAllCategories(){
        travelRepository.getAllCategories().enqueue(object : Callback<List<CategoryModel>> {
            override fun onResponse(
                call: Call<List<CategoryModel>>,
                response: Response<List<CategoryModel>>
            ) {
                _allCategories.value = response.body()
            }

            override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable) {
                Log.v("CATEGORIES ERROR",t.message.toString())
            }

        })
    }
}
