package com.example.funfacts.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FunFact::class], version = 1, exportSchema = false)
abstract class FunFactsDatabase : RoomDatabase() {
    abstract fun funFactDao(): FunFactDao
}