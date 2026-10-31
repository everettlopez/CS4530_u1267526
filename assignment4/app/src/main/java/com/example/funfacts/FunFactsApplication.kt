package com.example.funfacts

import android.app.Application
import androidx.room.Room
import com.example.funfacts.data.FunFactApi
import com.example.funfacts.data.FunFactRepository
import com.example.funfacts.data.FunFactsDatabase
import io.ktor.client.HttpClient

class FunFactsApplication : Application()
{
    val database: FunFactsDatabase by lazy {
        Room.databaseBuilder(
            applicationContext,
            FunFactsDatabase::class.java,
            "fun_facts.db"
        ).build()
    }

    val httpClient: HttpClient
        get() = HttpClient()

    val repsository: FunFactRepository by lazy {
        FunFactRepository.getInstance(database.funFactDao(), FunFactApi)
    }
}