package com.sebs.fitnessapp.data.remote

import com.sebs.fitnessapp.data.remote.model.LegendDetailsDto
import com.sebs.fitnessapp.data.remote.model.LegendDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface LegendAPI {

    // Endpoints

    // Obtiene la lista de leyendas desde una URL específica
   /* @GET
    fun getLegend(
        @Url url: String?
    ): Call<MutableList<LegendDto>>

    // Obtiene la lista de leyendas
    @GET("legend/legends_list")
    fun getLegends(): Call<MutableList<LegendDto>>

    // Obtiene los detalles de una leyenda en específico
    @GET("legend/legend_detail/{id}")
    fun getLegendDetails(
        @Path("id") id: String?
    ): Call<LegendDetailsDto>

    */


    // Apiary mock endpoints

    @GET("legend/legends_list")
    fun getLegendsApiary(): Call<MutableList<LegendDto>>

    @GET("legend/legend_detail/{id}")
    fun getLegendDetailApiary(
        @Path("id") id: String?
    ): Call<LegendDetailsDto>
}
