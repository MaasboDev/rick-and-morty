package com.maasbodev.rickandmorty.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.maasbodev.rickandmorty.domain.model.Character
import com.maasbodev.rickandmorty.presentation.theme.FontSize.f32
import com.maasbodev.rickandmorty.presentation.theme.Spacing.s16
import com.maasbodev.rickandmorty.presentation.theme.Spacing.s8

@Composable
fun CharacterScreen(
    characters: LazyPagingItems<Character>
) {

    Box(modifier = Modifier.fillMaxSize()) {
        when (characters.loadState.refresh) {
            is LoadState.Error -> Text(
                text = "Error: " + (characters.loadState.refresh as LoadState.Error).error.message,
                modifier = Modifier
                    .padding(s8)
                    .fillMaxSize()
                    .wrapContentHeight(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Black,
                fontStyle = FontStyle.Italic,
                fontSize = f32,
            )

            LoadState.Loading -> CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
            )

            else -> LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(s16),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                items(characters) { character ->
                    if (character != null) {
                        CharacterItem(
                            character = character,
                            modifier = Modifier.fillMaxSize(),
                        )
                    }
                }
                item {
                    if (characters.loadState.append is LoadState.Loading) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}
