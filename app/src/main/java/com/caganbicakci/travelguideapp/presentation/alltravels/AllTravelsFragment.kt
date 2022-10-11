package com.caganbicakci.travelguideapp.presentation.alltravels

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.caganbicakci.travelguideapp.BR
import com.caganbicakci.travelguideapp.databinding.FragmentAllTravelsBinding
import com.caganbicakci.travelguideapp.domain.model.TravelModel
import com.caganbicakci.travelguideapp.domain.viewmodel.TravelViewModel
import com.caganbicakci.travelguideapp.handler.TravelClickHandler
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllTravelsFragment : Fragment(), TravelClickHandler {

    private lateinit var allTravelsFragmentBinding: FragmentAllTravelsBinding
    private val travelViewModel: TravelViewModel by viewModels()
    private val clickHandler = this

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        allTravelsFragmentBinding = FragmentAllTravelsBinding.inflate(inflater)
        return allTravelsFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        travelViewModel.getAllTravels().observe(viewLifecycleOwner) { travelList ->
            Log.e("TRAVEL LIST", travelList.toString())
            allTravelsFragmentBinding.apply {
                val allTravelsAdapter = AllTravelsAdapter(travelList, clickHandler)
                setVariable(BR.allTravelsAdapter, allTravelsAdapter)
            }
        }
    }

    override fun travelItemClicked(travelModel: TravelModel) {
        findNavController().apply {
            val action = AllTravelsFragmentDirections.actionAllTravelsFragmentToDetailActivity(travelModel)
            navigate(action)
        }
    }

}