package com.maasbodev.rickandmorty.data.remote.model

data class CharacterResponseDto(
    val info: InfoDto,
    val results: List<CharacterDto>,
)
