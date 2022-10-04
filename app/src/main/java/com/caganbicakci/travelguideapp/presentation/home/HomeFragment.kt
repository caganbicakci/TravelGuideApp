package com.caganbicakci.travelguideapp.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.caganbicakci.travelguideapp.BR
import com.caganbicakci.travelguideapp.databinding.FragmentHomeBinding
import com.caganbicakci.travelguideapp.domain.viewmodel.TravelViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var homeFragmentBinding: FragmentHomeBinding
    private val travelViewModel: TravelViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        homeFragmentBinding = FragmentHomeBinding.inflate(inflater)
        return homeFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        travelViewModel.getAllTravels().observe(viewLifecycleOwner) { travelList ->
            homeFragmentBinding.apply {
                val layoutManager = GridLayoutManager(
                    activity,
                    1,
                    GridLayoutManager.HORIZONTAL,
                    false
                )
                val bannerAdapter = BannerCardAdapter()
                bannerRecyclerView.layoutManager = layoutManager
                setVariable(BR.bannerAdapter, bannerAdapter)

                val dealsCardAdapter = DealsCardAdapter(travelList)
                setVariable(BR.dealsAdapter, dealsCardAdapter)

            }

        }

    }
}