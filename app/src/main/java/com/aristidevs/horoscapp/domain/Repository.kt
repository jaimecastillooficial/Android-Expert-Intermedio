package com.aristidevs.horoscapp.domain

import com.aristidevs.horoscapp.data.network.response.PredictionResponse
import com.aristidevs.horoscapp.domain.model.PredictionModel

interface Repository {

    suspend fun getPrediction(sign:String): PredictionModel?
}