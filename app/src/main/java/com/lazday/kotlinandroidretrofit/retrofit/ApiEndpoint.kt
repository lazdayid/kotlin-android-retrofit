package com.lazday.covid_19.retrofit

import com.lazday.kotlinandroidretrofit.MainModel
import retrofit2.Call
import retrofit2.http.*

interface ApiEndpoint {

    @GET("photos")
    fun getPhotos(): Call<List<MainModel>>
}