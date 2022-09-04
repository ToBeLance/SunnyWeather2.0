package com.kun.sunnyweather20.logic.network

import com.kun.sunnyweather20.SunnyWeatherApplication
import com.kun.sunnyweather20.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {
    @GET("v2/place?token=${SunnyWeatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>
}