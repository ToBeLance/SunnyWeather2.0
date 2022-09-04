package com.kun.sunnyweather20.logic

import android.util.Log
import androidx.lifecycle.liveData
import com.kun.sunnyweather20.logic.model.Place
import com.kun.sunnyweather20.logic.network.SunnyWeatherNetWork
import kotlinx.coroutines.Dispatchers

object Repository {
    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = SunnyWeatherNetWork.searchPlace(query)
            if (placeResponse.status == "ok") {
                val place = placeResponse.places
                Log.d("lance", "searchPlaces: " + placeResponse)
                Result.success(place)
            } else {
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        } catch (e: Exception) {
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}