package com.projetoplacar.dev.richardsonrodrigues.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.projetoplacar.dev.richardsonrodrigues.databinding.LayoutCardViewBinding
import com.projetoplacar.dev.richardsonrodrigues.domain.Match

class MatchAdapter(private val matchList: List<Match>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

fun  getMatchList(): List<Match>{
    return matchList
}


    private lateinit var binding: LayoutCardViewBinding



    class ViewHolder(binding: LayoutCardViewBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutDetailInflate = LayoutInflater.from(parent.context)
        binding = LayoutCardViewBinding.inflate(layoutDetailInflate, parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val match = matchList[position]


        //context para passar ao Glide
        val context = holder.itemView.context
        binding.tvDescription.text = match.description
        binding.tvNameTeamOne.text = match.teamOne.name
        binding.tvNameTeamTwo.text = match.teamTwo.name

        Glide.with(context).load(match.teamOne.img).circleCrop().into(binding.imTeamOne)
        Glide.with(context).load(match.teamTwo.img).circleCrop().into(binding.imTeamTwo)

        binding.tvScoreTeamOne.text = match.teamOne.score.toString()
        binding.tvScoreTeamTwo.text = match.teamTwo.score.toString()
    }
    override fun getItemCount(): Int {
        return matchList.size
    }

}
