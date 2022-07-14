package com.projetoplacar.dev.richardsonrodrigues.domain

import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("nome")
    val name: String,
    @SerializedName("imagem")
    val img: String,
    @SerializedName("forca")
    val stars: Int,

    var score:Int
)
