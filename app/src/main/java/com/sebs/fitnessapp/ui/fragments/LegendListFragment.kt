package com.sebs.fitnessapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.sebs.fitnessapp.R
import com.sebs.fitnessapp.application.LegendRFApp
import com.sebs.fitnessapp.data.LegendRepository
import com.sebs.fitnessapp.data.remote.model.LegendDto
import com.sebs.fitnessapp.databinding.FragmentLegendListBinding
import com.sebs.fitnessapp.ui.adapters.LegendAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LegendListFragment : Fragment() {

    private var _binding: FragmentLegendListBinding? = null
    private val binding get() = _binding!!

    private lateinit var repository: LegendRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLegendListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        repository = (requireActivity().application as LegendRFApp).repository

        val call: Call<MutableList<LegendDto>> = repository.getLegendsApiary("legend/legends_list")

        call.enqueue(object: Callback<MutableList<LegendDto>>{
            override fun onResponse(
                p0: Call<MutableList<LegendDto>>,
                response: Response<MutableList<LegendDto>>
            ) {
           binding.pbLoading.visibility = View.GONE
                response.body()?.let { legend ->


                    //pasamos las leyendas al recicler view

                    binding.rvGames.apply {

                        layoutManager = LinearLayoutManager(requireContext())
                        adapter = LegendAdapter(legend){ legend ->
                            //accion para detalles del juego

                            legend.id?.let { id ->
                                requireActivity().supportFragmentManager.beginTransaction()
                                    .replace(R.id.fragment_container, LegendDatailFragment.newInstance(id))
                                    .addToBackStack(null)
                                    .commit()
                            }


                        }
                    }
                }
            }

            override fun onFailure(p0: Call<MutableList<LegendDto>>, p1: Throwable) {
            Toast.makeText(
                requireContext(),
                "error: no hay conexion",
                Toast.LENGTH_SHORT
            ).show()
            }

        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}