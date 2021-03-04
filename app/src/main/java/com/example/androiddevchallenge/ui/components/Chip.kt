package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Created by Farouk on 01/03/2021.
 */
@Composable
fun MaterialChip(
    label: String,
    selected: Boolean = true,
    onClick: () -> Unit,
    modifier: Modifier
) {
    val foregroundColor = if (selected) Color.White else Color.DarkGray
    val backgroundColor = if (selected) MaterialTheme.colors.secondary else Color.LightGray
    Box(
        modifier = Modifier
            .padding(8.dp)
            .clickable(onClick = onClick)
    ) {
        Surface(
            elevation = 1.dp,
            shape = MaterialTheme.shapes.medium,
            color = backgroundColor
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    label,
                    modifier = Modifier.padding(8.dp),
                    style = MaterialTheme.typography.caption
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewChip() {
    MaterialChip(
        label = "Female",
        onClick = { /*TODO*/ },
        modifier  = Modifier
    )
}