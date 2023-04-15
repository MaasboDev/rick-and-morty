package com.maasbodev.rickandmorty.data.remote.model

data class CharacterResultDto(
    val info: InfoDto,
    val results: List<CharacterDto>,
)
