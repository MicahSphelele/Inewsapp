package sphe.inews.network

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query
import sphe.inews.models.covid.CovidResponse

interface Covid19Api {

    @GET("latest_stat_by_country.php")//latest_stat_by_country_name.php
    fun getCovidStatsByCountry(@Query("country") country: String): Flowable<CovidResponse>?

    @GET("latest_stat_by_country.php")
    suspend fun getCountryCovidStats(@Query("country") country: String): CovidResponse
}