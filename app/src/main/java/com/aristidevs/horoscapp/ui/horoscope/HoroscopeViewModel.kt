package com.aristidevs.horoscapp.ui.horoscope

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.CreationExtras
import com.aristidevs.horoscapp.data.providers.HoroscopeProvider
import com.aristidevs.horoscapp.domain.model.HoroscopeInfo
import com.aristidevs.horoscapp.domain.model.HoroscopeInfo.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel                              //Desde el init o variable no es necesario que horoscope provider sea una variable
class HoroscopeViewModel @Inject constructor(horoscopeProvider: HoroscopeProvider) : ViewModel() {

    //Buena practica para evitar que modifiquen la lista(_horoscope) pero que puedan acceder y leer con la otra lista (horoscope)
    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())

    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope

    //Como el oncrete de las activity normales
    init {
        _horoscope.value = horoscopeProvider.getHoroscopes()
    }


}