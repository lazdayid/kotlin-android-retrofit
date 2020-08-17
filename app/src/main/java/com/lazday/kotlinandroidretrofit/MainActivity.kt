package com.lazday.kotlinandroidretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.lazday.covid_19.retrofit.ApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        getDataFromApi()
    }

    private fun getDataFromApi(){
        showLoading(true)
        ApiService.endpoint.getPhotos()
            .enqueue(object : Callback<List<MainModel>> {
                override fun onFailure(call: Call<List<MainModel>>, t: Throwable) {
                    printLog( t.toString() )
                    showLoading(false)
                }

                override fun onResponse(
                    call: Call<List<MainModel>>,
                    response: Response<List<MainModel>>
                ) {
                    showLoading(false)
                    if (response.isSuccessful) {
                        val photos = response.body()
                        showPhotos( photos!! )
                    }
                }

            })
    }

    private fun printLog(message: String) {
        Log.d(TAG, message)
    }

    private fun showLoading(loading: Boolean) {
        when(loading) {
            true -> progressBar.visibility = View.VISIBLE
            false -> progressBar.visibility = View.GONE
        }
    }

    private fun showPhotos(photos: List<MainModel>) {
        for (photo in photos) {
            printLog( "title: ${photo.title}" )
        }
    }
}
