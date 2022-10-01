package com.caganbicakci.travelguideapp.presentation.guide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.caganbicakci.travelguideapp.databinding.FragmentGuideBinding

class GuideFragment : Fragment() {

    private lateinit var guideFragmentBinding: FragmentGuideBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        guideFragmentBinding = FragmentGuideBinding.inflate(inflater)
        return guideFragmentBinding.root
    }
}