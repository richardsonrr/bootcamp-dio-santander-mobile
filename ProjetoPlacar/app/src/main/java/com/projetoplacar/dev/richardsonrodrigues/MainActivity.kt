 package com.projetoplacar.dev.richardsonrodrigues

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.projetoplacar.dev.richardsonrodrigues.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabAddGames.setOnClickListener {
            val detailScream = Intent(this, DetailActivity::class.java)
            startActivity(detailScream)
        }




    }
}