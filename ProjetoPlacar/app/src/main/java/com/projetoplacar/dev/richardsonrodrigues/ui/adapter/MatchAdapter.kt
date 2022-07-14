package com.projetoplacar.dev.richardsonrodrigues.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.projetoplacar.dev.richardsonrodrigues.databinding.ActivityDetailBinding
import com.projetoplacar.dev.richardsonrodrigues.domain.Match

class MatchAdapter(
    private val matchList: List<Match>,


    ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var binding: ActivityDetailBinding


    class ViewHolder(binding: ActivityDetailBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutDetailInflate = LayoutInflater.from(parent.context)
        binding = ActivityDetailBinding.inflate(layoutDetailInflate, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val match = matchList[position]
        binding.tvDescription.text = match.description
        binding.tvTeamOne.text = match.teamOne.name
        binding.tvTeamTwo.text = match.teamTwo.name
    }

    override fun getItemCount(): Int {
        return matchList.size
    }

}
