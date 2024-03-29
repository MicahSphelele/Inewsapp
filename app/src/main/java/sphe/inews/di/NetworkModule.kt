package sphe.inews.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import sphe.inews.data.network.Covid19Api
import sphe.inews.data.network.INewsApi
import sphe.inews.data.network.WeatherApi
import sphe.inews.util.Constants
import javax.inject.Named

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    fun provideINewsApi(retrofit: Retrofit): INewsApi =
        retrofit.create(INewsApi::class.java)

    @Provides
    fun provideCovid19Api(@Named(Constants.NAMED_COVID_19) retrofit: Retrofit) : Covid19Api =
        retrofit.create(Covid19Api::class.java)

    @Provides
    fun provideWeatherApi(@Named(Constants.NAMED_WEATHER_API) retrofit: Retrofit) : WeatherApi =
        retrofit.create(WeatherApi::class.java)
}