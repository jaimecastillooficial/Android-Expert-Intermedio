package com.aristidevs.horoscapp.ui.horoscope.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aristidevs.horoscapp.R
import com.aristidevs.horoscapp.domain.model.HoroscopeInfo

class HoroscopeAdapter(private var horoscopeList: List<HoroscopeInfo> = emptyList()) :
    RecyclerView.Adapter<HoroscopeViewHolder>() {


    //Metodo para insertar datos a la lista que recibe el recylcler view en decir llenar horoscopeList
    fun updateList(list: List<HoroscopeInfo>) {
        horoscopeList = list
        notifyDataSetChanged()
    }

    //Es siempre igual
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        return HoroscopeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope, parent, false)
        )
    }

    //Se encarga de decirle al viewholder que tiene que pintar
    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        holder.render(horoscopeList[position])
    }

    override fun getItemCount(): Int = horoscopeList.size


}