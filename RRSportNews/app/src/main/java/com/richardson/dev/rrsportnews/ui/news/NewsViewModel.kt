package com.richardson.dev.rrsportnews.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.richardson.dev.rrsportnews.data.remote.SoccerNewsAPI
import com.richardson.dev.rrsportnews.domain.News
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class NewsViewModel : ViewModel() {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://digitalinnovationone.github.io/soccer-news-api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val dioAPI: SoccerNewsAPI = retrofit.create(SoccerNewsAPI::class.java)




    private val _news = MutableLiveData<List<News>>().apply {
        val value = this
        findNews(value)

         value.value
    }

    private fun findNews(value: MutableLiveData<List<News>>) {
        dioAPI.getNews().enqueue(object : Callback<List<News>> {
            override fun onResponse(call: Call<List<News>>, response: Response<List<News>>) {
                if (response.isSuccessful) {
                    value.value = response.body()
                } else {
                    // TODO: Tratar erros
                }

            }

            override fun onFailure(call: Call<List<News>>, t: Throwable) {
                TODO("Mesmo tratamento de erros")
            }

        })
    }

    val news: LiveData<List<News>> = _news
}