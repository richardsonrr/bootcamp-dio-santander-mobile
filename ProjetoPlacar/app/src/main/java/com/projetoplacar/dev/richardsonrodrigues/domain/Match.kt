package com.projetoplacar.dev.richardsonrodrigues.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Match(
    @SerializedName("descricao")
    val description: String,
    @SerializedName("local")
    val place: Place,
    @SerializedName("mandante")
    val teamOne: Team,
    @SerializedName("visitante")
    val teamTwo: Team

):Parcelable