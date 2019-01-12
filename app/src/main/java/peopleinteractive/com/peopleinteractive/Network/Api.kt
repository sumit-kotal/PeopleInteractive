package com.aztechz.projectbinaryveda.Network

import peopleinteractive.com.peopleinteractive.Models.Data
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @get:GET("438")
    val getData: Call<Data>

    companion object {


        const val BASE_URL = "https://apistage.thewift.com/1.0/profiles/"
    }
}
