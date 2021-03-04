package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.ui.components.MaterialChip
import com.example.androiddevchallenge.ui.theme.PuppyHomeTheme
import com.example.androiddevchallenge.ui.theme.puppyHomeTypography
import com.example.androiddevchallenge.ui.theme.shapes
import com.example.androiddevchallenge.ui.theme.typography
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.insets.navigationBarsPadding

/**
 * Created by Farouk on 27/02/2021.
 */

@ExperimentalStdlibApi
@Composable
fun PuppyDetails(
    puppy: Puppy?) {
    Scaffold(
        topBar = {
            TopAppBar(navigationIcon = {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back")
            }) {

            }
        },
        bottomBar = {
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)) {
                Text(
                    text = "Adopt Me",
                    modifier = Modifier.padding(10.dp)
                )
            }
        },
        content = {
            if (puppy != null) {
                PuppyDetailsContent(puppy = puppy)
            }
        }
    )
}

@ExperimentalStdlibApi
@Composable
fun PuppyDetailsContent(puppy: Puppy) {
    LazyColumn(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            CoilImage(
                data = puppy.imageUrl,
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth(),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = puppy.name,
                style = puppyHomeTypography.h1,
                modifier = Modifier.padding(start = 10.dp)
            )
            MaterialChip(
                label = puppy.gender.toString().lowercase(),
                onClick = {
                    // do nothing
                },
                modifier = Modifier.padding(start = 10.dp, top = 5.dp),
            )

            Text(
                text = puppy.age,
                style = typography.subtitle1,
                modifier = Modifier
                    .padding(start = 8.dp, top = 10.dp),
            )

            Text(
                text = puppy.bio,
                style = typography.subtitle1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 16.dp),
            )
        }
    }
}

@ExperimentalStdlibApi
@Preview
@Composable
fun PreviewPuppyDetails() {
    PuppyHomeTheme {
        PuppyDetails( puppy = Puppy())
    }
}