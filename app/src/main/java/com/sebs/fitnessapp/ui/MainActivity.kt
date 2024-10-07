package com.sebs.fitnessapp.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.sebs.fitnessapp.R
import com.sebs.fitnessapp.data.LegendRepository
import com.sebs.fitnessapp.data.remote.RetrofitHelper
import com.sebs.fitnessapp.data.remote.model.LegendDto
import com.sebs.fitnessapp.databinding.ActivityMainBinding
import com.sebs.fitnessapp.ui.fragments.LegendListFragment
import com.sebs.fitnessapp.utilis.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    /* private lateinit var repository: LegendRepository
    private lateinit var retrofit: Retrofit

    */


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //Mostrar fragment inicial

        if(savedInstanceState == null){

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LegendListFragment())
                .commit()

        }


        /*
        //obteniendo la instancia de retrofit

        retrofit = RetrofitHelper().getRetrofit()

        repository = LegendRepository(retrofit)

        }

    fun click(view: View) {

        val call: Call<MutableList<LegendDto>> = repository.getLegendsApiary( "legend/legends_list")

        call.enqueue(object: Callback<MutableList<LegendDto>>{
            override fun onResponse(
                call: Call<MutableList<LegendDto>>,
                response: Response<MutableList<LegendDto>>
            ) {
                Log.d(Constants.LOGTAG, "Respuesta del servidor: ${response.body()}")

            }

            override fun onFailure(p0: Call<MutableList<LegendDto>>, p1: Throwable) {
              Toast.makeText(
                  this@MainActivity,
                  "Error: No hay conexion",
                  Toast.LENGTH_SHORT
              ).show()

            }

        })

    }


    */

    }
}


