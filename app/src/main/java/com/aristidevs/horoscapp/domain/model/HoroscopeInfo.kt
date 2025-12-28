package com.aristidevs.horoscapp.domain.model

import com.aristidevs.horoscapp.R


// La sealed class es basicamente un enum de objetos

sealed class HoroscopeInfo(val img:Int, val name:Int){
    // El tipo de los atributos es Int por que va a recibir referencias
    // es decir el nombre sera(R.string.name) por ejemplo y esto para kotlin es Int
    // se hace asi por que la clase no sabe lo hay fuera solo sabe que recibe Int solo sabe Kotlin

     object Aries:HoroscopeInfo(R.drawable.aries, R.string.aries)
     object Taurus: HoroscopeInfo(R.drawable.tauro, R.string.taurus)
     object Gemini: HoroscopeInfo(R.drawable.geminis, R.string.gemini)
     object Cancer: HoroscopeInfo(R.drawable.cancer, R.string.cancer)
     object Leo: HoroscopeInfo(R.drawable.leo, R.string.leo)
     object Virgo: HoroscopeInfo(R.drawable.virgo, R.string.virgo)
     object Libra: HoroscopeInfo(R.drawable.libra, R.string.libra)
     object Scorpio: HoroscopeInfo(R.drawable.escorpio, R.string.scorpio)
     object Sagittarius: HoroscopeInfo(R.drawable.sagitario, R.string.sagittarius)
     object Capricorn: HoroscopeInfo(R.drawable.capricornio, R.string.capricorn)
     object Aquarius: HoroscopeInfo(R.drawable.aquario, R.string.aquarius)
     object Pisces: HoroscopeInfo(R.drawable.piscis, R.string.pisces)
}