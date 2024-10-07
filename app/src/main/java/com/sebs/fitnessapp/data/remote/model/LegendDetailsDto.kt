package com.sebs.fitnessapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class LegendDetailsDto(

    @SerializedName("id")
    var id: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("alias")
    var alias: String? = null,

    @SerializedName("birthdate")
    var birthdate: String? = null,

    @SerializedName("occupation")
    var occupation: String? = null,

    @SerializedName("achievements")
    var achievements: List<String>? = null,

    @SerializedName("image")
    var image: String? = null,

    @SerializedName("PR_bench_press")
    var prBenchPress: String? = null,

    @SerializedName("PR_squat")
    var prSquat: String? = null,

    @SerializedName("PR_deadlift")
    var prDeadlift: String? = null,

    @SerializedName("height")
    var height: String? = null,

    @SerializedName("weight")
    var weight: String? = null,

    @SerializedName("current_age")
    var currentAge: String? = null,

    @SerializedName("description")
    var description: String? = null






)



