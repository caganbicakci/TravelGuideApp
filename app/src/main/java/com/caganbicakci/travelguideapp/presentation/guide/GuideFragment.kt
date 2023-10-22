package com.caganbicakci.travelguideapp.presentation.guide

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.caganbicakci.travelguideapp.BR
import com.caganbicakci.travelguideapp.databinding.FragmentGuideBinding
import com.caganbicakci.travelguideapp.domain.model.TravelModel
import com.caganbicakci.travelguideapp.domain.viewmodel.TravelViewModel
import com.caganbicakci.travelguideapp.handler.BookmarkClickHandler
import com.caganbicakci.travelguideapp.handler.CategoryClickHandler
import com.caganbicakci.travelguideapp.handler.TravelClickHandler
import com.caganbicakci.travelguideapp.presentation.dialog.search.SearchTravelDialog
import com.caganbicakci.travelguideapp.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GuideFragment : Fragment(), TravelClickHandler, CategoryClickHandler, BookmarkClickHandler {

    private lateinit var guideFragmentBinding: FragmentGuideBinding
    private val travelViewModel: TravelViewModel by activityViewModels()
    private val clickHandler = this

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

            travelViewModel.allTravels.observe(viewLifecycleOwner) { travelList ->
                val mightNeedTheseAdapter =
                    MightNeedTheseAdapter(
                        travelList.filter { it.category == Constants.MIGHT_NEED_THESE },
                        clickHandler
                    )
                setVariable(BR.mightNeedTheseAdapter, mightNeedTheseAdapter)

                val topPickArticlesAdapter =
                    TopPickArticlesAdapter(
                        travelList.filter { it.category == Constants.TOP_PICK_ARTICLES },
                        clickHandler
                    )
                setVariable(BR.topPickArticlesAdapter, topPickArticlesAdapter)

                searchBar.setEndIconOnClickListener {
                    val searchText = searchBar.editText?.text.toString().lowercase()
                    val searchResult = travelList.filter {
                        it.country.lowercase().contains(searchText) ||
                                it.city.lowercase().contains(searchText) ||
                                it.description.lowercase().contains(searchText)
                    }
                    showSearchDialog(searchResult)
                }

                tvSeeAll.setOnClickListener {
                    findNavController().apply {
                        navigate(GuideFragmentDirections.actionGuideFragmentToAllTravelsFragment())
                    }
                }
            }

            travelViewModel.allCategories.observe(viewLifecycleOwner) { categoryList ->
                val travelCategoryAdapter = TravelCategoryListAdapter(categoryList, clickHandler)
                setVariable(BR.categoryAdapter, travelCategoryAdapter)
            }

        }

    }

    override fun travelItemClicked(travelModel: TravelModel) {
        findNavController().apply {
            val action = GuideFragmentDirections.actionGuideFragmentToDetailFragment(travelModel)
            navigate(action)
        }
    }

    override fun searchCategoryOnMap(category: String) {
        val gmmIntentUri = Uri.parse("geo:0,0?q=$category")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }

    override fun setBookmarkStatus(id: String, isBookmark: Boolean) {
        //TODO("Not yet implemented")
    }

    private fun showSearchDialog(searchResult: List<TravelModel>) {
        childFragmentManager.let {
            SearchTravelDialog(searchResult).show(it, "SearchTravelDialog")
        }
    }

}