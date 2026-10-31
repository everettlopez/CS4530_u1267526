package com.example.funfacts.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object FunFactApi {

    private const val RANDOM_FACT_URL = "https://uselessfacts.jsph.pl/api/v2/facts/random"

    val client = HttpClient(Android) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }

    }

    suspend fun getRandomFact(): FunFact = client.get(RANDOM_FACT_URL){parameter("language", "en")}.body()
}