package com.aplicada2.apiretrofit.network

import com.aplicada2.apiretrofit.model.Exchange
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface ApiService {
    @GET("exchanges")
    suspend fun getExchanges(): List <Exchange>

    companion object {

        var apiService: ApiService? = null
        fun getInstance() : ApiService {

            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://api.coinpaprika.com/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }

}