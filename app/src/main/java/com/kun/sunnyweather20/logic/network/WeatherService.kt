package com.kun.sunnyweather20.logic.network

import com.kun.sunnyweather20.SunnyWeatherApplication
import com.kun.sunnyweather20.logic.model.DailyResponse
import com.kun.sunnyweather20.logic.model.RealtimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {
    @GET("v2.6/${SunnyWeatherApplication.TOKEN}/{lng},{lat}/realtime.json")
    fun getRealTimeWeather(@Path("lng") lng: String,@Path("lat") lat: String):
            Call<RealtimeResponse>

    @GET("v2.6/${SunnyWeatherApplication.TOKEN}/{lng},{lat}/daily.json")
    fun getDailyWeather(@Path("lng") lng: String,@Path("lat") lat: String):
            Call<DailyResponse>
}