package com.caganbicakci.travelguideapp.domain.usecase

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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
    val allTravels : LiveData<List<TravelModel>> = _allTravels

    fun getAllTravels(){
        travelRepository.getAllTravels().enqueue(object : Callback<List<TravelModel>> {
            override fun onResponse(
                call: Call<List<TravelModel>>,
                response: Response<List<TravelModel>>
            ) {
                _allTravels.value = response.body()
            }

            override fun onFailure(call: Call<List<TravelModel>>, t: Throwable) {
                Log.v("ERROR",t.message.toString())
            }

        })
    }
}
