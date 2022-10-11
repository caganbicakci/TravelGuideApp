package com.caganbicakci.travelguideapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class TravelModel (
    val title: String,
    val description: String,
    val category: String,
    val country: String,
    val city: String,
    val images: List<Image>,
    val isBookmark: Boolean,
    val id: String
) : Parcelable

@Parcelize
data class Image (
    val url: String
) : Parcelable

