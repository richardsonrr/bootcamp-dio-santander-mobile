package com.projetoplacar.dev.richardsonrodrigues.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.projetoplacar.dev.richardsonrodrigues.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar

        setSupportActionBar(toolbar)
         supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.toolbar.
        setOnClickListener{
            val mainActivity = Intent(this, MainActivity::class.java)
            startActivity(mainActivity)
            binding.toolbar.title = "Richardson"


        }







    }
}
