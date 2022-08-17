package com.richardson.dev.projetocartaodevisita.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.richardson.dev.projetocartaodevisita.App
import com.richardson.dev.projetocartaodevisita.R
import com.richardson.dev.projetocartaodevisita.data.BusinessCard
import com.richardson.dev.projetocartaodevisita.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListener()
    }

    private fun insertListener() {
        binding.btnClose.setOnClickListener {
            finish()
        }

        binding.btnAddNewCard.setOnClickListener {
            val businessCard = BusinessCard(
                name = binding.tilName.editText?.text.toString(),
                contact = binding.tilContact.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                company = binding.tilCompany.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.show_sucess, Toast.LENGTH_LONG).show()
            finish()
        }
    }
}