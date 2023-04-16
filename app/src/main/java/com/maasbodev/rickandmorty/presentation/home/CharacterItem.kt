package com.maasbodev.rickandmorty.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.maasbodev.rickandmorty.domain.model.Character
import com.maasbodev.rickandmorty.presentation.detail.DetailViewModel
import com.maasbodev.rickandmorty.presentation.navigation.DETAIL_SCREEN
import com.maasbodev.rickandmorty.presentation.navigation.navToDetail
import com.maasbodev.rickandmorty.presentation.theme.RickAndMortyTheme
import com.maasbodev.rickandmorty.presentation.theme.Spacing.s16
import com.maasbodev.rickandmorty.presentation.theme.Spacing.s4
import com.maasbodev.rickandmorty.presentation.theme.Spacing.s8

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterItem(
    character: Character,
    detailViewModel: DetailViewModel,
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(s4),
        shape = RoundedCornerShape(s4),
        onClick = {
            detailViewModel.findById(character.id)
            navToDetail(navController, DETAIL_SCREEN)
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max),
        ) {
            AsyncImage(
                model = character.image,
                contentDescription = character.name,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)
                    .fillMaxHeight(),
            )
            Spacer(modifier = Modifier.width(s16))
            Column(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxHeight(),
            ) {
                Text(
                    text = character.name,
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(modifier = Modifier.height(s4))
                Text(
                    text = character.status,
                    style = MaterialTheme.typography.labelLarge,
                )
                Spacer(modifier = Modifier.height(s8))
                Text(
                    text = "Last known location:",
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.Gray,
                )
                Spacer(modifier = Modifier.height(s4))
                Text(
                    text = character.locationName,
                    style = MaterialTheme.typography.labelLarge,
                )
            }
        }
    }
}

@Preview
@Composable
fun CharacterItemPreview() {
    RickAndMortyTheme {
        /*CharacterItem(
            character = Character(
                id = 1,
                name = "Character",
                status = "Dead",
                species = "Human Human Human Human Human Human Human \n Human Human Human Human",
                type = "Unknown type",
                gender = "Male",
                originName = "Alien Spa",
                originUrl = "https",
                locationName = "Earth",
                locationUrl = "https",
                image = "https",
                episode = emptyList(),
                url = "https",
                created = "Timestamp",
            ),
            modifier = Modifier.fillMaxWidth()
        )*/
    }
}
