package com.example.funfacts.data

import kotlinx.coroutines.flow.Flow

class FunFactRepository private constructor(
    private val dao: FunFactDao,
    private val api: FunFactApi
)
{
    val allFacts: Flow<List<FunFact>> = dao.getAllFacts()

    fun searchFacts(keyword: String): Flow<List<FunFact>> = dao.searchFacts(keyword)

    suspend fun fetchAndSaveNewFact()
    {
        val fact = api.getRandomFact()
        dao.insertFact(fact)
    }

    companion object
    {
        @Volatile
        private var INSTANCE: FunFactRepository? = null

        fun getInstance(dao: FunFactDao, api: FunFactApi): FunFactRepository
        {
            return INSTANCE ?: synchronized(this)
            {
                INSTANCE ?: FunFactRepository(dao, api).also { INSTANCE = it }
            }
        }
    }
}