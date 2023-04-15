package com.maasbodev.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.maasbodev.rickandmorty.presentation.CharacterScreen
import com.maasbodev.rickandmorty.presentation.CharacterViewModel
import com.maasbodev.rickandmorty.presentation.theme.RickAndMortyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RickAndMortyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    val viewModel = hiltViewModel<CharacterViewModel>()
                    val characters = viewModel.characterPagingFlow.collectAsLazyPagingItems()
                    CharacterScreen(characters = characters)
                }
            }
        }
    }
}
