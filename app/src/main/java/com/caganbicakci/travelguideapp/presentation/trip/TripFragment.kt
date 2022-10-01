package com.caganbicakci.travelguideapp.presentation.trip

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.caganbicakci.travelguideapp.databinding.FragmentHomeBinding
import com.caganbicakci.travelguideapp.databinding.FragmentTripBinding

class TripFragment : Fragment() {

    private lateinit var tripFragmentBinding : FragmentTripBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tripFragmentBinding = FragmentTripBinding.inflate(inflater)
        return tripFragmentBinding.root
    }

}