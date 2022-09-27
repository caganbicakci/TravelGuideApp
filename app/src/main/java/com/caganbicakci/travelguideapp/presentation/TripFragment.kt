package com.caganbicakci.travelguideapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.caganbicakci.travelguideapp.databinding.FragmentHomeBinding

class TripFragment : Fragment() {

    private lateinit var tripFragmentBinding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tripFragmentBinding = FragmentHomeBinding.inflate(inflater)
        return tripFragmentBinding.root
    }

}