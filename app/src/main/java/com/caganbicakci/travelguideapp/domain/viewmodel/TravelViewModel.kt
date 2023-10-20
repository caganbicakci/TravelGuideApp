package com.caganbicakci.travelguideapp.domain.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.caganbicakci.travelguideapp.domain.model.CategoryModel
import com.caganbicakci.travelguideapp.domain.model.TravelModel
import com.caganbicakci.travelguideapp.domain.model.TripPlanModel
import com.caganbicakci.travelguideapp.domain.repository.TravelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class TravelViewModel @Inject constructor(
    private val travelRepository: TravelRepository,
) : ViewModel() {

    private var _allTravels = MutableLiveData<List<TravelModel>>()
    private var _allCategories = MutableLiveData<List<CategoryModel>>()

    val allTravels: LiveData<List<TravelModel>> = _allTravels
    val allCategories: LiveData<List<CategoryModel>> = _allCategories

    private var _allBookmarks = MutableLiveData<List<TravelModel>>()
    val allBookmarks : MutableLiveData<List<TravelModel>> = _allBookmarks

    init {
        getAllTravels()
        getAllCategories()
        getBookmarkedTripPlans()
    }

    private fun getAllTravels() {
        travelRepository.getAllTravels().enqueue(object : Callback<List<TravelModel>> {
            override fun onResponse(
                call: Call<List<TravelModel>>,
                response: Response<List<TravelModel>>
            ) {
                _allTravels.value = response.body()
            }

            override fun onFailure(call: Call<List<TravelModel>>, t: Throwable) {
                t.localizedMessage?.let { Log.e("TRAVELS ERROR", it) }
            }
        })
    }

    private fun getAllCategories() {
        travelRepository.apply {
            getAllCategories().enqueue(object : Callback<List<CategoryModel>> {
                override fun onResponse(
                    call: Call<List<CategoryModel>>,
                    response: Response<List<CategoryModel>>
                ) {
                    _allCategories.value = response.body()
                }

                override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable) {
                    t.localizedMessage?.let { Log.e("CATEGORIES ERROR", it) }
                }

            })
        }
    }

    fun changeBookmarkStatus(id: String, isBookmark: Boolean){
        travelRepository.apply {
            changeBookmark(id,isBookmark)
        }
    }

    private fun getBookmarkedTripPlans(){
        travelRepository.apply {
            getBookmarkedTripPlans().enqueue(object : Callback<List<TravelModel>>{
                override fun onResponse(
                    call: Call<List<TravelModel>>,
                    response: Response<List<TravelModel>>
                ) {
                    _allBookmarks.value = response.body()
                }

                override fun onFailure(call: Call<List<TravelModel>>, t: Throwable) {
                    t.localizedMessage?.let { Log.e("BOOKMARK ERROR", it) }
                }
            })
        }
    }

}