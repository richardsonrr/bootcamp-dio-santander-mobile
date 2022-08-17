package com.richardson.dev.projetocartaodevisita.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.richardson.dev.projetocartaodevisita.App
import com.richardson.dev.projetocartaodevisita.data.BusinessCard
import com.richardson.dev.projetocartaodevisita.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val mainViewModel:MainViewModel by viewModels{
        MainViewModelFactory((application as App).repository)
    }
    private val adapter by lazy { BusinessCardAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.rvCards.adapter = adapter
        setContentView(binding.root)
        getAllBusinessCard()
        insertListener()

    }

    private fun insertListener(){
        binding.fabAdd.setOnClickListener {
            val intent = Intent(this,AddBusinessCardActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getAllBusinessCard(){
        mainViewModel.getAll().observe(this) { businessCard ->
            adapter.submitList(businessCard)
        }
    }
}