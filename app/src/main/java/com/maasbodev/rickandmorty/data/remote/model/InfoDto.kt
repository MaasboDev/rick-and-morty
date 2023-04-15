package com.maasbodev.rickandmorty.data.remote.model

data class InfoDto(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?,
)
