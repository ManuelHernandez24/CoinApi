package com.aplicada2.apiretrofit.network

import com.aplicada2.apiretrofit.model.Coin
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface ApiService {
    @GET(".json")
    suspend fun getCoins(): List <Coin>

    companion object {

        var apiService: ApiService? = null
        fun getInstance() : ApiService {

            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://coins-edb8e-default-rtdb.firebaseio.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }

}