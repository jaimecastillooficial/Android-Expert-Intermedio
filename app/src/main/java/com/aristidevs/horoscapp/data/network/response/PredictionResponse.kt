package com.aristidevs.horoscapp.data.network.response

import com.aristidevs.horoscapp.domain.model.PredictionModel
import com.google.gson.annotations.SerializedName

data class PredictionResponse(
    @SerializedName("date") val date: String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("sign") val sign: String
) {
    //funcion de extension que mapea un objeto(Prediction response) a un objeto (Prediction Model) es decir
    //transforma un objeto en otro con los mismos valores
    fun toDomain(): PredictionModel {
        return PredictionModel(
            horoscope = horoscope,
            sign = sign
        )
    }
}