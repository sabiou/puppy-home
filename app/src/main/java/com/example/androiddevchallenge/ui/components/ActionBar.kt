package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Created by Farouk on 28/02/2021.
 */

@Composable
fun ActionBar(modifier: Modifier = Modifier) {
    Row {
        Text(
            text = "Puppy Home",
            style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
            modifier = modifier.padding(16.dp),
            color = MaterialTheme.colors.primary
        )
    }
}

@Preview
@Composable
fun ActionBarPreview() {
    Surface{
        ActionBar(Modifier.fillMaxWidth())
    }
}