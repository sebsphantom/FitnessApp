package com.sebs.fitnessapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.sebs.fitnessapp.R
import com.sebs.fitnessapp.application.LegendRFApp
import com.sebs.fitnessapp.data.LegendRepository
import com.sebs.fitnessapp.data.remote.model.LegendDetailsDto
import com.sebs.fitnessapp.databinding.FragmentLegendDatailBinding
import com.sebs.fitnessapp.databinding.FragmentLegendListBinding
import com.sebs.fitnessapp.utilis.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


private const val LEGEND_ID = "legend_id"


class LegendDatailFragment : Fragment() {

    private var legendId: String? = null

    private var _binding: FragmentLegendDatailBinding? = null
    private val  binding get() = _binding!!

    private lateinit var repository: LegendRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { args ->
            legendId = args.getString(LEGEND_ID)

            Log.d(Constants.LOGTAG, "ID recibido $legendId")
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      _binding = FragmentLegendDatailBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //instancia del repo
        repository = (requireActivity().application as LegendRFApp).repository
        legendId?.let { id ->
        val call: Call<LegendDetailsDto> = repository.getLegendDatailApiary(id)
            call.enqueue(object: Callback<LegendDetailsDto>{
                override fun onResponse(p0: Call<LegendDetailsDto>, response: Response<LegendDetailsDto>) {

                //EXITOSA

                    binding.apply {
                        pbLoading.visibility = View.GONE
                        tvName.text = response.body()?.name


                    Glide.with(requireActivity())
                        .load(response.body()?.image)
                        .into(ivImage)


                        tvLongDesc.text = response.body()?.description

                        //tvLongDesc.text = response.body()?.longDesc
                }

            }

                override fun onFailure(p0: Call<LegendDetailsDto>, p1: Throwable) {

                }
            })
        }
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {

        @JvmStatic
        fun newInstance(legendId: String,) =
            LegendDatailFragment().apply {
                arguments = Bundle().apply {
                    putString(LEGEND_ID, legendId)

                }
            }
    }
}