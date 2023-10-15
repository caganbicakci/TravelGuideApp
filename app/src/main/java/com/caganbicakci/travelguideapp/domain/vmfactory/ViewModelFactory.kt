package com.caganbicakci.travelguideapp.domain.vmfactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.caganbicakci.travelguideapp.data.localdb.TripPlanRepository
import com.caganbicakci.travelguideapp.domain.viewmodel.TripPlanViewModel

class ViewModelFactory (private val tripPlanRepository: TripPlanRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TripPlanViewModel(tripPlanRepository) as T
    }
}
