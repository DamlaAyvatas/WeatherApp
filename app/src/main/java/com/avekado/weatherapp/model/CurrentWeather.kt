package com.avekado.weatherapp.model
import kotlinx.serialization.Serializable


@Serializable
data class CurrentWeather(
    val temp_c: Float,
    val condition: Condition
)