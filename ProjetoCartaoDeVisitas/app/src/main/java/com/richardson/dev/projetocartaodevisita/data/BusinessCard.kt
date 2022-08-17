package com.richardson.dev.projetocartaodevisita.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BusinessCard(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    val name: String,
    val contact: String,
    val email: String,
    val company: String,
)