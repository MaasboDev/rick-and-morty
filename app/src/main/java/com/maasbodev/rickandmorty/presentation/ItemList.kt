package com.maasbodev.rickandmorty.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.maasbodev.rickandmorty.domain.model.Character
import com.maasbodev.rickandmorty.presentation.theme.Spacing
import java.util.Locale

@Composable
fun ItemList(
    state: MutableState<TextFieldValue>,
    characterPagingItems: LazyPagingItems<Character>
) {

    var filteredItems: List<Character>
    val characters = characterPagingItems.itemSnapshotList.items
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(Spacing.s16)
    ) {
        val searchedText = state.value.text
        filteredItems = if (searchedText.isEmpty()) {
            characters
        } else {
            val resultList = ArrayList<Character>()
            for (item in characters) {
                if (charactersToSee(item, searchedText)) {
                    resultList.add(item)
                }
            }
            resultList
        }
        items(filteredItems) { filteredItem ->
            CharacterItem(character = filteredItem)
        }
        item {
            if (characterPagingItems.loadState.append is LoadState.Loading) {
                CircularProgressIndicator()
            }
        }
    }
}

fun charactersToSee(character: Character, searchedText: String): Boolean {
    val lowerCharacterName = character.name.lowercase(Locale.getDefault())
    val lowerSearchedText = searchedText.lowercase(Locale.getDefault())

    return lowerCharacterName.contains(lowerSearchedText)
}
