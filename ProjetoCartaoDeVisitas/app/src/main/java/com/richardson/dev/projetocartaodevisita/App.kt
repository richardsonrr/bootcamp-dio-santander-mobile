package com.richardson.dev.projetocartaodevisita

import android.app.Application
import com.richardson.dev.projetocartaodevisita.data.AppDatabase
import com.richardson.dev.projetocartaodevisita.data.BusinessCardRepository

class App:Application() {
        val database by lazy { AppDatabase.getDataBase(this)}
        val repository by lazy { BusinessCardRepository(database.businessDao()) }
}