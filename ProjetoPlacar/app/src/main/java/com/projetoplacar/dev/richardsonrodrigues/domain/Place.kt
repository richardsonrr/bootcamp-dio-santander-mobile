package com.projetoplacar.dev.richardsonrodrigues.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Place(
    @SerializedName("nome")
    val name: String,
    @SerializedName("imagem")
    val img: String
):Parcelable
