package com.richardson.dev.rrsportnews.data.remote

import com.richardson.dev.rrsportnews.domain.News
import retrofit2.http.GET

interface SoccerNewsAPI {
    @GET("news.json")
    fun getNews(): retrofit2.Call<List<News>>
}