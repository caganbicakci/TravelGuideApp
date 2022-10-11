package com.caganbicakci.travelguideapp.presentation.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.navArgs
import com.caganbicakci.travelguideapp.BR
import com.caganbicakci.travelguideapp.databinding.ActivityDetailBinding
import com.caganbicakci.travelguideapp.domain.model.Image
import com.caganbicakci.travelguideapp.handler.ImageClickHandler
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity(), ImageClickHandler {
    private lateinit var detailActivityBinding: ActivityDetailBinding
    private val clickHandler = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailActivityBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailActivityBinding.root)

        val args: DetailActivityArgs by navArgs()
        val travelImages = args.travelModel.images
        val imageListAdapter =
            TravelCardImagesAdapter(imageList = travelImages, clickHandler = clickHandler)

        detailActivityBinding.apply {
            setVariable(BR.travelModel, args.travelModel)
            setVariable(BR.imageListAdapter, imageListAdapter)

            btnClose.setOnClickListener {
                finish()
            }
        }
    }

    override fun imageItemClicked(imageModel: Image) {
        detailActivityBinding.apply {
            Picasso.get().load(imageModel.url).into(ivDetailImage)
        }
    }

}