package com.maasbodev.rickandmorty.domain.model

import com.maasbodev.rickandmorty.data.remote.model.OriginLocationObject

data class Character(
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
