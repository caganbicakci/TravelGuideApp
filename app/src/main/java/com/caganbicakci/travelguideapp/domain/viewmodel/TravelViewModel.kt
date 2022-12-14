package com.caganbicakci.travelguideapp.domain.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.caganbicakci.travelguideapp.domain.model.CategoryModel
import com.caganbicakci.travelguideapp.domain.model.TravelModel
import com.caganbicakci.travelguideapp.domain.usecase.AllTravelsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TravelViewModel @Inject constructor(
    private val allTravelsUseCase: AllTravelsUseCase,
) : ViewModel() {

    init {
        getAllTravels()
        getAllTravels()
    }

    fun getAllTravels(): LiveData<List<TravelModel>> {
        allTravelsUseCase.apply {
            getAllTravels()
            return allTravels
        }
    }

    fun getAllCategories(): LiveData<List<CategoryModel>> {
        allTravelsUseCase.apply {
            getAllCategories()
            return allCategories
        }
    }

    fun changeBookmarkStatus(id: String, isBookmark: Boolean){
        allTravelsUseCase.apply {
            changeBookmarkUseCase(id,isBookmark)
        }
    }

}