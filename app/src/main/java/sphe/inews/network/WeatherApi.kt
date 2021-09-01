package sphe.inews.network

import retrofit2.http.GET
import retrofit2.http.Query

import sphe.inews.models.weather.current.CurrentWeatherResponse
import sphe.inews.models.weather.forecast.WeatherForecastResponse
import sphe.inews.util.Constants

interface WeatherApi {

    @GET("current.json")
    suspend fun getCurrentWeather(
        @Query("key") key: String = String(Constants.PACKS_WEATHER),
        @Query("q") city: String,
        @Query("aqi") aqi: String? = "no"
    ): CurrentWeatherResponse

    @GET("forecast.json")
    suspend fun getWeatherForecast(
        @Query("key") key: String = String(Constants.PACKS_WEATHER),
        @Query("q") city: String,
        @Query("days") days: Int = 5,
        @Query("aqi") aqi: String = "no",
        @Query("alerts") alerts: String = "no"
    ): WeatherForecastResponse
}