package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.ui.components.ActionBar
import com.example.androiddevchallenge.ui.components.PuppyCard
import com.example.androiddevchallenge.ui.theme.PuppyHomeTheme

/**
 * Created by Farouk on 27/02/2021.
 */
@ExperimentalFoundationApi
@Composable
fun Home(onClicked: (Puppy) -> Unit) {
    Scaffold (
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.background
    ) {
        Column {
            TopAppBar(
                title = {
                    Text(
                        "Puppy Home",
                        color = MaterialTheme.colors.onPrimary,
                    )
                },
            )
            val puppies = remember {
                List(10) {
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
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun PreviewHomeScreen() {
    PuppyHomeTheme() {
        Home(onClicked = { TODO()})
    }
}