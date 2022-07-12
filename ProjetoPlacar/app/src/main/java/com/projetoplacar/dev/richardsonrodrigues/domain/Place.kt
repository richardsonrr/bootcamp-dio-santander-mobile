package com.projetoplacar.dev.richardsonrodrigues.domain

import com.google.gson.annotations.SerializedName

data class Place(
    @SerializedName("nome")
    val name: String,
    @SerializedName("imagem")
    val img: String
)
