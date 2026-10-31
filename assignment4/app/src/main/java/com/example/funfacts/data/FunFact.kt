package com.example.funfacts.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
@Entity(tableName = "fun_facts")
data class FunFact(
    @Transient
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val text: String
)

