package com.example.kotlinStructure.data.api

import com.example.kotlinStructure.data.model.CovidData
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiInterface {
    @GET("us/daily.json")
    fun getNationalData(): Observable<List<CovidData>>


}