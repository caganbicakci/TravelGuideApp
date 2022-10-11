package com.caganbicakci.travelguideapp.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.caganbicakci.travelguideapp.utils.Constants.Companion.TRIP_PLAN_TABLE


@Entity(tableName = TRIP_PLAN_TABLE)
data class TripPlanModel(
    @PrimaryKey(autoGenerate = true)
    val tid: Int = 0,

    @ColumnInfo(name = "title")
    val title: String = "",

    @ColumnInfo(name = "description")
    val description: String = "",
)