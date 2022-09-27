package com.caganbicakci.travelguideapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.caganbicakci.travelguideapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeFragmentBinding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeFragmentBinding = FragmentHomeBinding.inflate(inflater)
        return homeFragmentBinding.root
    }
}