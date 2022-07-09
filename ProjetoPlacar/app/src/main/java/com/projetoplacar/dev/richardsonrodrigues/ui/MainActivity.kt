package com.projetoplacar.dev.richardsonrodrigues.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.projetoplacar.dev.richardsonrodrigues.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }
}