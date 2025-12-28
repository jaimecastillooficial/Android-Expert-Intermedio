package com.aristidevs.horoscapp.ui.horoscope

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.aristidevs.horoscapp.databinding.FragmentHoroscopeBinding
import com.aristidevs.horoscapp.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {


    private val horoscopeViewModel by viewModels<HoroscopeViewModel>()

    private lateinit var horoscopeadapter: HoroscopeAdapter


    //Buena practiva
    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initList()
        initUIState()
    }

    //Metodo para inicar el recycler view
    private fun initList() {
       horoscopeadapter = HoroscopeAdapter(onItemSelected = {
           Toast.makeText(context,getString(it.name),Toast.LENGTH_SHORT).show()
       })
        binding.rvHoroscope.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter = horoscopeadapter
        }

        //Es lo mismo
        //binding.rvHoroscope.layoutManager = LinearLayoutManager(context)
        //binding.rvHoroscope.adapter = adapter
    }

    //Metodo para enganchar al viewmodel y ejecutar el viewmodel
    private fun initUIState() {
        //Corrutina vinculada al ciclo de vida del fragment
        //Evitamos errores
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                // Siempre que se modifice "horoscope" en el ViewModel o es decir cada vez que
                // se haga un horoscope.values en el viewmodel se llama a lo que haya aqui dentro
                horoscopeViewModel.horoscope.collect {
                    //CAMBIOS EN HOROSCOPE
                    horoscopeadapter.updateList(it)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}