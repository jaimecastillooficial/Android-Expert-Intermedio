package com.aristidevs.horoscapp.ui.horoscope

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.CreationExtras
import com.aristidevs.horoscapp.domain.model.HoroscopeInfo
import com.aristidevs.horoscapp.domain.model.HoroscopeInfo.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor() : ViewModel() {

    //Buena practica para evitar que modifiquen la lista(_horoscope) pero que puedan acceder y leer con la otra lista (horoscope)
    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())

    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope

    //Como el oncrete de las activity normales
    init {
        _horoscope.value = listOf<HoroscopeInfo>(
            Aries, Taurus, Gemini
        )
    }


}