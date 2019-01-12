package com.aztechz.projectbinaryveda.ViewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.aztechz.projectbinaryveda.Network.Api
import com.aztechz.projectbinaryveda.Models.Seeker

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataViewModel : ViewModel() {


    //this is the data that we will fetch asynchronously
    var seeker: MutableLiveData<Seeker>? = null

    //we will call this method to get the data
    fun getSeeker(): LiveData<Seeker> {
        //if the list is null
        if (seeker == null) {
            seeker = MutableLiveData()
            //we will load it asynchronously from server in this method
            loadSeeker()
        }

        //finally we will return the list
        return seeker as MutableLiveData<Seeker>
    }


    //This method is using Retrofit to get the JSON data from URL
    private fun loadSeeker() {

        val retrofit = Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val api = retrofit.create<Api>(Api::class.java!!)
        val call = api.getData


        call.enqueue(object : Callback<Seeker> {
            override fun onResponse(call: Call<Seeker>, response: Response<Seeker>) {

                //finally we are setting the list to our MutableLiveData
                seeker!!.value = response.body()
            }

            override fun onFailure(call: Call<Seeker>, t: Throwable) {

            }
        })
    }
}
