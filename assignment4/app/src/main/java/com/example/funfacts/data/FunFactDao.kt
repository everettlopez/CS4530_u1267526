package com.example.funfacts.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FunFactDao {
    @Query("SELECT * FROM fun_facts ORDER BY id DESC")
    fun getAllFacts(): Flow<List<FunFact>>

    @Query("SELECT * FROM fun_facts WHERE text LIKE '%' || :keyword || '%' ORDER BY id DESC")
    fun searchFacts(keyword: String): Flow<List<FunFact>>

    @Insert
    suspend fun insertFact(fact: FunFact)

}