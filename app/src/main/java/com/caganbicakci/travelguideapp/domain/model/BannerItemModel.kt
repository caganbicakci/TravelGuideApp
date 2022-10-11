package com.caganbicakci.travelguideapp.domain.model

import com.caganbicakci.travelguideapp.R

data class BannerItem(val name: String, val imageResource: Int)

class BannerItemList {
    companion object {
        val bannerItems: List<BannerItem> = listOf(
            BannerItem("Flights", R.drawable.ic_plane),
            BannerItem("Hotels", R.drawable.ic_hotel_filled),
            BannerItem("Cars", R.drawable.ic_car_filled),
            BannerItem("Taxi", R.drawable.ic_taxi_filled),
        )
    }
}

