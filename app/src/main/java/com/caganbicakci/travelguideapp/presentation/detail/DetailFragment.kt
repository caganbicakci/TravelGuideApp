package com.caganbicakci.travelguideapp.presentation.detail

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.caganbicakci.travelguideapp.BR
import com.caganbicakci.travelguideapp.databinding.FragmentDetailBinding
import com.caganbicakci.travelguideapp.domain.model.Image
import com.caganbicakci.travelguideapp.domain.model.TripPlanModel
import com.caganbicakci.travelguideapp.domain.viewmodel.TripPlanViewModel
import com.caganbicakci.travelguideapp.handler.ImageClickHandler
import com.squareup.picasso.Picasso


class DetailFragment : Fragment(), ImageClickHandler {

    private lateinit var detailFragmentBinding : FragmentDetailBinding
    private val clickHandler = this
    private val tripPlanViewModel : TripPlanViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        detailFragmentBinding = FragmentDetailBinding.inflate(inflater)

        val args: DetailActivityArgs by navArgs()
        val travelImages = args.travelModel.images
        val imageListAdapter =
            TravelCardImagesAdapter(imageList = travelImages, clickHandler = clickHandler)

        detailFragmentBinding.apply {
            setVariable(BR.travelModel, args.travelModel)
            setVariable(BR.imageListAdapter, imageListAdapter)

            btnClose.setOnClickListener {
                activity?.onBackPressedDispatcher?.onBackPressed()
            }

            bookmarkBtn.setOnClickListener {
                val travelItem = args.travelModel
                tripPlanViewModel.addTripPlan(TripPlanModel(0,travelItem.title, travelItem.city))
                Log.i("VIEWMODEL",tripPlanViewModel.toString())
            }
        }

        return detailFragmentBinding.root
    }

    override fun imageItemClicked(imageModel: Image) {
        detailFragmentBinding.apply {
            Picasso.get().load(imageModel.url).into(ivDetailImage)
        }
    }

}