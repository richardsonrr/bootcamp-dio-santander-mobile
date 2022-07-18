package com.projetoplacar.dev.richardsonrodrigues.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.R
import com.projetoplacar.dev.richardsonrodrigues.databinding.ActivityDetailBinding
import com.projetoplacar.dev.richardsonrodrigues.domain.Match

class DetailActivity : AppCompatActivity() {
    object Extras {
        const val MATCH = "EXTRA_MATCH"

    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)
         supportActionBar?.setDisplayHomeAsUpEnabled(true)


        setDateFromExtras()



    }
    @SuppressLint("SetTextI18n")
    fun setDateFromExtras(){
        intent?.extras?.getParcelable<Match>(Extras.MATCH)?.let {
            Glide.with(this).load(it.place.img).into(binding.ivPlace)
            Glide.with(this).load(it.teamOne.img).into(binding.imTeamOne)
            Glide.with(this).load(it.teamTwo.img).into(binding.imTeamTwo)
            supportActionBar?.title = it.place.name
            binding.tvTeamTwo.text = it.teamTwo.name
            binding.tvTeamOne.text = it.teamOne.name
            binding.tvScoreTeamOne.text = it.teamOne.score.toString()
            binding.tvScoreTeamTwo.text = it.teamTwo.score.toString()
            binding.tvDescription.text = it.description
            binding.rbTeamOne.rating = it.teamOne.stars.toFloat()
            binding.rbTeamTwo.rating = it.teamTwo.stars.toFloat()

            if (it.teamOne.score == it.teamTwo.score){
                binding.winTeam.text = getString(com.projetoplacar.dev.richardsonrodrigues.R.string.empate)
            }else if(it.teamOne.score > it.teamTwo.score){
                binding.winTeam.text = "${it.teamOne.name} ${getString(com.projetoplacar.dev.richardsonrodrigues.R.string.win_team)}"
            }else
            {
                binding.winTeam.text ="${it.teamTwo.name} ${getString(com.projetoplacar.dev.richardsonrodrigues.R.string.win_team)}"
            }

        }
    }

}

