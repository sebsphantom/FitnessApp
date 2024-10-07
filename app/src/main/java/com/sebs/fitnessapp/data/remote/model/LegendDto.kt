package com.sebs.fitnessapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class LegendDto(

    @SerializedName("id")
    var id: String? = null,

    @SerializedName("thumbnail")
    var thumnail: String? = null,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("PR_bench_press")
     var prBenchPress: String? = null



)





