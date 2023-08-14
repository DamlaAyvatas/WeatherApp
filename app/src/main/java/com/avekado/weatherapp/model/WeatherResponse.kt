package com.avekado.weatherapp.model
import kotlinx.serialization.Serializable


@Serializable
data class WeatherResponse(
    val current: CurrentWeather,
    val location: Location
)


