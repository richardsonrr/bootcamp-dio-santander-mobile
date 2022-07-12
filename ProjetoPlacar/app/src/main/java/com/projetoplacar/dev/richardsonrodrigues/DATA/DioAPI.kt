package com.projetoplacar.dev.richardsonrodrigues.DATA
import com.projetoplacar.dev.richardsonrodrigues.domain.Match
import retrofit2.Call
import retrofit2.http.GET

interface DioAPI {
    @GET("matches.json")
   fun  getMatch():Call<List<Match>>
}