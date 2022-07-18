package com.projetoplacar.dev.richardsonrodrigues.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.projetoplacar.dev.richardsonrodrigues.DATA.DioAPI
import com.projetoplacar.dev.richardsonrodrigues.databinding.ActivityMainBinding
import com.projetoplacar.dev.richardsonrodrigues.domain.Match
import com.projetoplacar.dev.richardsonrodrigues.ui.adapter.MatchAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var dioApi: DioAPI
    private lateinit var binding: ActivityMainBinding
    private lateinit var matchAdapter: MatchAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setHTTPClient()
        setMatchList()
        setMatchRefresh()
        setFAB()

    }


    private fun setHTTPClient() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://digitalinnovationone.github.io/matches-simulator-api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        dioApi = retrofit.create(DioAPI::class.java)

    }

    private fun setFAB() {

        binding.fabAddGames.setOnClickListener {

            binding.fabAddGames.animate().rotationBy(360F).setDuration(500).start()
            val matchsSize = matchAdapter.itemCount

            for (x in 0 until matchsSize) {
                val score = matchAdapter.getMatchList()[x]
                score.teamOne.score = (0..score.teamOne.stars).random()
                score.teamTwo.score = (0..score.teamTwo.stars).random()

                matchAdapter.notifyItemChanged(x)

            }

        }

    }

    private fun setMatchRefresh() {
        binding.slGames.setOnRefreshListener { findMatchesAPI() }
    }

    private fun setMatchList() {
        binding.rvGames.setHasFixedSize(true)

        findMatchesAPI()

    }

    private fun findMatchesAPI() {
        binding.slGames.isRefreshing = true
        dioApi.getMatch().enqueue(object : Callback<List<Match>> {
            override fun onResponse(call: Call<List<Match>>, response: Response<List<Match>>) {
                if (response.isSuccessful) {
                    val matchList = response.body()
                    matchAdapter = MatchAdapter(matchList!!)
                    binding.rvGames.adapter = matchAdapter

                } else {
                    showErrorMsg()

                }
            }

            override fun onFailure(call: Call<List<Match>>, t: Throwable) {
                showErrorMsg()

            }
        })
        binding.slGames.isRefreshing = false
    }

    private fun showErrorMsg() {
        Log.i("dados", "Nao foi possivel concectar a APi")
        Snackbar.make(binding.fabAddGames, "Error conecting API", Snackbar.LENGTH_LONG).show()
    }


}