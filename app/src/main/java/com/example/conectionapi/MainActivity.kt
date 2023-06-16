package com.example.conectionapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/* CONFIGURAÇÃO NECESSÁRIA
* -- DEPENCIAS:
*     implementation 'com.squareup.retrofit2:retrofit:2.5.0'
      implementation 'com.squareup.retrofit2:converter-gson:2.3.0'
*
* -- MANIFEST:
*     <uses-permission android:name="android.permission.INTERNET" />
* */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val service = RetrofiClient.createPostService(PostService::class.java)
        val call: Call<List<PostEntity>> = service.list()
        call.enqueue(object: Callback<List<PostEntity>>{
            override fun onResponse(call: Call<List<PostEntity>>,r: Response<List<PostEntity>>) {
                val list = r.body()
            }

            override fun onFailure(call: Call<List<PostEntity>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}