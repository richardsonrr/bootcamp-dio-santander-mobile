package com.richardson.dev.rrsportnews.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.richardson.dev.rrsportnews.databinding.NewsLayoutBinding
import com.richardson.dev.rrsportnews.domain.News

class NewsAdapter(list:List<News>): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
private lateinit var binding: NewsLayoutBinding

    class ViewHolder(binding: NewsLayoutBinding):RecyclerView.ViewHolder(binding.root) {

    }

    private  val listNews = list




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = NewsLayoutBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = this.listNews[position]
        binding.title.text = news.title
        binding.secondaryText.text = news.description



    }

    override fun getItemCount(): Int {
    return listNews.size
    }
}
