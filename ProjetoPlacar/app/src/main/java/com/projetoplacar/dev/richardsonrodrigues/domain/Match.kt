package com.projetoplacar.dev.richardsonrodrigues.domain

data class Match(
    val description: String,
    val place: Place,
    val teamOne: Team,
    val teamTwo: Team
)