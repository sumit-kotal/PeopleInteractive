package com.aztechz.projectbinaryveda.Network

import peopleinteractive.com.peopleinteractive.Models.Data
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {


    @GET("api")
    fun getData(@Query("results") count: Int): Call<Data>


    companion object {
        const val BASE_URL = "https://randomuser.me/"
    }
}
