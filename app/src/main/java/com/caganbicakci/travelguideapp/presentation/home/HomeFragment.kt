package com.caganbicakci.travelguideapp.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView.Orientation
import com.caganbicakci.travelguideapp.BR
import com.caganbicakci.travelguideapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeFragmentBinding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeFragmentBinding = FragmentHomeBinding.inflate(inflater)
        return homeFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeFragmentBinding.apply {
            val layoutManager = GridLayoutManager(activity,1, GridLayoutManager.HORIZONTAL,false)
            bannerRecyclerView.layoutManager = layoutManager
            val adapter = BannerCardAdapter()
            setVariable(BR.bannerAdapter, adapter)
        }
    }
}