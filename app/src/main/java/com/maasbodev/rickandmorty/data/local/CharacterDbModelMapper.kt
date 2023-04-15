package com.maasbodev.rickandmorty.data.local

import com.maasbodev.rickandmorty.data.remote.model.CharacterDto
import com.maasbodev.rickandmorty.domain.model.Character

fun CharacterDto.toCharacterDbModel(): CharacterDbModel = CharacterDbModel(
    id = id,
    name = name,
    status = status,
    species = species,
    type = type,
    gender = gender,
    origin = origin,
    location = location,
    image = image,
    episode = episode,
    url = url,
    created = created,
)

fun CharacterDbModel.toCharacter(): Character = Character(
    id = id,
    name = name,
    status = status,
    species = species,
    type = type,
    gender = gender,
    origin = origin,
    location = location,
    image = image,
    episode = episode,
    url = url,
    created = created,
)
