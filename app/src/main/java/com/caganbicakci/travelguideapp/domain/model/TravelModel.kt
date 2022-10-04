package com.caganbicakci.travelguideapp.domain.model

data class TravelModel (
    val title: String,
    val description: String,
    val category: String,
    val country: String,
    val city: String,
    val images: List<Image>,
    val isBookmark: Boolean,
    val id: String
)

data class Image (
    val altText: Any? = null,
    val height: Long,
    val width: Long,
    val url: String
)

