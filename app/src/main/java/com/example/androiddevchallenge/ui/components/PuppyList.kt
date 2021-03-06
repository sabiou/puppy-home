package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.ui.theme.PuppyHomeTheme
import kotlinx.coroutines.sync.Mutex

/**
 * Created by Farouk on 27/02/2021.
 */

@ExperimentalFoundationApi
@Composable
fun PuppyList(
    onClicked: (Puppy) -> Unit
) {
    val puppies = remember {
        List(30) {
            Puppy()
        }
    }

    LazyVerticalGrid(
        cells = GridCells.Adaptive(minSize = 128.dp)
    ) {
        items(puppies) { puppy ->
            PuppyCard(puppy) {
                onClicked(puppy)
            }
        }
    }
}