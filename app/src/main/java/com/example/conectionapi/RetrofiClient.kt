package com.example.conectionapi

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofiClient {

    companion object{

        private lateinit var INSTANCE: Retrofit
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"   //URL PRECISA SEMPRE TERMINAR COM /

        private fun getRetroficInstance(): Retrofit{
            val http = OkHttpClient.Builder() //Conecta na internet
            if(!::INSTANCE.isInitialized){  //checa se a instancia já foi inicializada. caso não, inicializa.
                INSTANCE = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(http.build())
                    .addConverterFactory(GsonConverterFactory.create()) //GSON transforma JSON em objeto para o kotlin
                    .build()
            }

            return INSTANCE
        }

        // FUNÇÃO QUE RETORNA UM GENERICO
        fun <S> createPostService(endpoint: Class<S>): S{
            return getRetroficInstance().create(endpoint)
        }

        //FUNÇÃO PARA APENAS UMA CHAMADA TIPADA
       // fun createPostService(): PostService{
       //     return getRetroficInstance().create(PostService::class.java)
       // }
    }
}