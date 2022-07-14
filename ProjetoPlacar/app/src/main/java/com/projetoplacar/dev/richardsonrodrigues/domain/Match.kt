package com.projetoplacar.dev.richardsonrodrigues.domain

import com.google.gson.annotations.SerializedName

data class Match(
    @SerializedName("descricao")
    val description: String,
    @SerializedName("local")
    val place: Place,
    @SerializedName("mandante")
    val teamOne: Team,
    @SerializedName("visitante")
    val teamTwo: Team

)