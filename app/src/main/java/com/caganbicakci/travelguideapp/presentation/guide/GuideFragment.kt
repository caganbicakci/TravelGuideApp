package com.caganbicakci.travelguideapp.presentation.guide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.caganbicakci.travelguideapp.BR
import com.caganbicakci.travelguideapp.databinding.FragmentGuideBinding
import com.caganbicakci.travelguideapp.domain.viewmodel.TravelViewModel
import com.caganbicakci.travelguideapp.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GuideFragment : Fragment() {

    private lateinit var guideFragmentBinding: FragmentGuideBinding
    private val travelViewModel: TravelViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        guideFragmentBinding = FragmentGuideBinding.inflate(inflater)
        return guideFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        guideFragmentBinding.apply {

            travelViewModel.getAllTravels().observe(viewLifecycleOwner) { travelList ->
                val mightNeedTheseAdapter =
                    MightNeedTheseAdapter(travelList.filter { it.category == Constants.MIGHT_NEED_THESE })
                setVariable(BR.mightNeedTheseAdapter, mightNeedTheseAdapter)

                val topPickArticlesAdapter =
                    TopPickArticlesAdapter(travelList.filter { it.category == Constants.TOP_PICK_ARTICLES })
                setVariable(BR.topPickArticlesAdapter, topPickArticlesAdapter)

            }

            travelViewModel.getAllCategories().observe(viewLifecycleOwner) { categoryList ->
                val travelCategoryAdapter = TravelCategoryListAdapter(categoryList)
                setVariable(BR.categoryAdapter, travelCategoryAdapter)
            }

        }

    }
}