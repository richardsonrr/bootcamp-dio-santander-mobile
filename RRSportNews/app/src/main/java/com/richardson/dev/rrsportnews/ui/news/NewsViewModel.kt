package com.richardson.dev.rrsportnews.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.richardson.dev.rrsportnews.domain.News

class NewsViewModel : ViewModel() {

    //Todo remover mock de news
    private val lista = listOf(News("Sampaio correia contra Gremio","Gremio vence a primeira partida com folga"),
    News("Flamengo vence novamente", "decima vitoria consecultiva do flamengo o leva a primeira colocação da tabela"),
    News("Decpação Paulista","São paulo perde o quinto confroto seguido."))

    private val _news = MutableLiveData<List<News>>().apply {
        this.value = lista

    }
    val news: LiveData<List<News>> = _news
}