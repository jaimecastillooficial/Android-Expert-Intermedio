package com.aristidevs.horoscapp.domain.model
//Buena practica
//Modelo de datos de la respuesta de la api sin el serizalized name para que sea consumible por otro sistema
//ya que el otro (con serialized name) tiene librerias exclusivas de android
data class PredictionModel(
    val horoscope: String,
    val sign: String
)
