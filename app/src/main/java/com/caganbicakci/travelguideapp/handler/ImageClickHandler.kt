package com.caganbicakci.travelguideapp.handler

import com.caganbicakci.travelguideapp.domain.model.Image

interface ImageClickHandler {
    fun imageItemClicked(imageModel: Image)
}