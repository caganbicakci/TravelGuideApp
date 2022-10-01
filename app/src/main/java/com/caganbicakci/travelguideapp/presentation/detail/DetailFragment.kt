package com.caganbicakci.travelguideapp.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.caganbicakci.travelguideapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var detailFragmentBinding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        detailFragmentBinding = FragmentDetailBinding.inflate(inflater)
        return detailFragmentBinding.root
    }
}