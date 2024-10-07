package com.sebs.fitnessapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class LegendDetailsDto(

    @SerializedName("title")
var name: String? = null,

  @SerializedName("image")
var image: String? = null,

    @SerializedName("PR_bench_press")
var prbenchpress: String? = null

)



