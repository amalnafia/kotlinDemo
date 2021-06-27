package com.example.kotlinStructure.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

class CovidData {

    @SerializedName("dateChecked")
    var dateChecked: Date? = null

    @SerializedName("positiveIncrease")
    var positiveIncrease: Int? = null

    @SerializedName("negativeIncrease")
    var negativeIncrease:  Int? = null

    @SerializedName("deathIncrease")
    var deathIncrease:  Int? = null

    @SerializedName("state")
    var state: String?=null

    constructor(
        dateChecked: Date?,
        positiveIncrease: Int?,
        negativeIncrease: Int?,
        deathIncrease: Int?,
        state: String?
    ) {
        this.dateChecked = dateChecked
        this.positiveIncrease = positiveIncrease
        this.negativeIncrease = negativeIncrease
        this.deathIncrease = deathIncrease
        this.state = state
    }
}