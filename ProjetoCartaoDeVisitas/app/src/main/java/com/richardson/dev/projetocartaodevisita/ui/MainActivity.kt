package com.richardson.dev.projetocartaodevisita.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.richardson.dev.projetocartaodevisita.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insetListener()

    }

    private fun insetListener(){
        binding.fabAdd.setOnClickListener {
            val intent = Intent(this,AddBusinessCardActivity::class.java)
            startActivity(intent)
        }
    }
}