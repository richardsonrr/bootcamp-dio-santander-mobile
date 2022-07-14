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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setHTTPClient()
        setMatchList()
        // setMatchRefresh()
        //      setFAB()


    }

    private fun setHTTPClient() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://digitalinnovationone.github.io/matches-simulator-api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        dioApi = retrofit.create(DioAPI::class.java)
    }

    private fun setFAB() {
        TODO("Click simular as partidas")
    }

    private fun setMatchRefresh() {
        TODO("Implementar atualização sas partidas com o refresh")
    }

    private fun setMatchList() {
        binding.rvGames.setHasFixedSize(true)

        dioApi.getMatch().enqueue(object : Callback<List<Match>> {
            override fun onResponse(call: Call<List<Match>>, response: Response<List<Match>>) {
                if (response.isSuccessful) {
                    var data = response.body()
                    binding.rvGames.adapter = MatchAdapter(data!!)

                } else {
                    showErrorMsg()
                }
            }
            override fun onFailure(call: Call<List<Match>>, t: Throwable) {
                showErrorMsg()
            }
        })

    }

    private fun showErrorMsg() {
        Log.i("dados", "Nao foi possivel concectar a APi")
        Snackbar.make(binding.fabAddGames, "Error conecting API", Snackbar.LENGTH_LONG).show()
    }


}