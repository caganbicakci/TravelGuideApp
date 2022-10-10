package com.caganbicakci.travelguideapp.handler

import com.caganbicakci.travelguideapp.domain.model.TravelModel

/**
 * click handler interface created for handle click event
 * for each item in recycler view.
 *
 */

interface TravelClickHandler {
    fun travelItemClicked(travelModel: TravelModel)

}