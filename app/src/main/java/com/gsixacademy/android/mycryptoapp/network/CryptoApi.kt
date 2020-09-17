package com.gsixacademy.android.mycryptoapp.network

import com.gsixacademy.android.mycryptoapp.models.CryptoListResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoApi {

    @GET("public/coins")
    fun getCryptoList(@Query("base") base: String?,@Query("timePeriod") timePeriod: String?): Call<CryptoListResponseModel>
}