package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.ui.components.PuppyList
import com.example.androiddevchallenge.ui.theme.PuppyHomeTheme

/**
 * Created by Farouk on 27/02/2021.
 */
@ExperimentalStdlibApi
@ExperimentalFoundationApi
@Composable
fun Home(onClicked: (Puppy) -> Unit) {
    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.background,
        topBar = {
            TopAppBar(
                title = {
                Text(text = "Puppy Home")
            },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Home,
                            contentDescription = null
                        )
                    }
                },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White,
            )
        },
        content = {
            PuppyList(onClicked = onClicked)
        }
    )
}

@ExperimentalStdlibApi
@ExperimentalFoundationApi
@Preview
@Composable
fun PreviewHomeScreen() {
    PuppyHomeTheme {
        Home(onClicked = { TODO() })
    }
}