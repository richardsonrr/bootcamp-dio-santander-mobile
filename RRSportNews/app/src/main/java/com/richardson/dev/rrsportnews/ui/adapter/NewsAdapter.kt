package com.richardson.dev.rrsportnews.ui.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.interaction.DragInteraction
import androidx.recyclerview.widget.RecyclerView
import com.richardson.dev.rrsportnews.databinding.NewsLayoutBinding
import com.richardson.dev.rrsportnews.domain.News
import com.squareup.picasso.Picasso

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

        //imgs
        Picasso.get()
            .load(news.image)
            .into(binding.ivNews);
        //buttons
        binding.materialButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(news.link)
            holder.itemView.context.startActivity(intent)

        }




    }

    override fun getItemCount(): Int {
    return listNews.size
    }
}
