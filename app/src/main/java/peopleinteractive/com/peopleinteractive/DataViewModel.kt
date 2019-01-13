package com.aztechz.projectbinaryveda.ViewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.aztechz.projectbinaryveda.Network.Api
import peopleinteractive.com.peopleinteractive.Models.Data

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataViewModel : ViewModel() {


    //this is the data that we will fetch asynchronously
    var liveData: MutableLiveData<Data>? = null

    //we will call this method to get the data
    fun getData(): LiveData<Data> {
        //if the list is null
        if (liveData == null) {
            liveData = MutableLiveData()
            //we will load it asynchronously from server in this method
            loadData()
        }

        //finally we will return the list
        return liveData as MutableLiveData<Data>
    }


    //This method is using Retrofit to get the JSON data from URL
    private fun loadData() {

        val retrofit = Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val count = 20

        val api = retrofit.create<Api>(Api::class.java!!)
        val call = api.getData(count)


        call.enqueue(object : Callback<Data> {
            override fun onResponse(call: Call<Data>, response: Response<Data>) {

                Log.d("Success","onSuccess")
                //finally we are setting the list to our MutableLiveData

                Log.d("Succ", response.body().toString())

                liveData!!.value = response.body()


            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
                Log.d("Failure","onFailure "+t.message)
            }
        })
    }
}
