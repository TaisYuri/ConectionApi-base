package com.example.conectionapi

import com.google.gson.annotations.SerializedName

class PostEntity {

    @SerializedName("userId")  //mapear exatamente os nomes das props retornadas da API
    var userId: Int = 0

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("title")
    var title: String = ""

    @SerializedName("body")
    var body: String = ""
}
