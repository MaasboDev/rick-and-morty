package com.maasbodev.rickandmorty.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.maasbodev.rickandmorty.data.remote.model.OriginLocationObject
import com.maasbodev.rickandmorty.domain.model.Character
import com.maasbodev.rickandmorty.presentation.theme.RickAndMortyTheme
import com.maasbodev.rickandmorty.presentation.theme.Spacing.s144
import com.maasbodev.rickandmorty.presentation.theme.Spacing.s16
import com.maasbodev.rickandmorty.presentation.theme.Spacing.s4

@Composable
fun CharacterItem(
    character: Character,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(s4),
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .height(IntrinsicSize.Max)
                .padding(s16),
        ) {
            AsyncImage(
                model = character.image,
                contentDescription = character.name,
                modifier = Modifier
                    .weight(1f)
                    .height(s144),
            )
            Spacer(modifier = Modifier.width(s16))
            Text(
                text = character.name,
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview
@Composable
fun CharacterItemPreview() {
    RickAndMortyTheme {
        CharacterItem(
            character = Character(
                id = 1,
                name = "Character",
                status = "Dead",
                species = "Human Human Human Human Human Human Human \n Human Human Human Human",
                type = "Unknown type",
                gender = "Male",
                origin = OriginLocationObject("Alien Spa", "https"),
                location = OriginLocationObject("Earth", "https"),
                image = "https",
                episode = emptyList(),
                url = "https",
                created = "Timestamp",
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}
