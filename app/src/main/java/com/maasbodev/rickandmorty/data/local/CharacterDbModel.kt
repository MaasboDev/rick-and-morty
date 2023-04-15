package com.maasbodev.rickandmorty.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.maasbodev.rickandmorty.data.remote.model.OriginLocationObject

@Entity
data class CharacterDbModel(
    @PrimaryKey
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginLocationObject,
    val location: OriginLocationObject,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String,
)
