package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.ui.theme.puppyHomeTypography
import dev.chrisbanes.accompanist.coil.CoilImage

/**
 * Created by Farouk on 27/02/2021.
 */
@ExperimentalStdlibApi
@Composable
fun PuppyCard(
    puppy: Puppy,
    onClick: (Puppy) -> Unit
) {
    Card(
        elevation = 8.dp, modifier = Modifier
            .padding(8.dp)
            .clickable {
                onClick(puppy)
            }
            .clip(RoundedCornerShape(16.dp))
    ) {
        Column {
            CoilImage(
                data = puppy.imageUrl,
                contentDescription = null,
                fadeIn = true,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(128.dp)
                    .background(MaterialTheme.colors.primary)
            )
            Text(
                text = puppy.name,
                style = puppyHomeTypography.h6,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 8.dp),
            )
            MaterialChip(
                label = puppy.gender.toString().lowercase(),
                onClick = {
                    // do nothing
                },
                modifier = Modifier
                    .padding(start = 10.dp, top = 5.dp)
                    .background(Color.White)
            )
        }
    }
}

@ExperimentalStdlibApi
@Preview
@Composable
fun PreviewPuppyCard() {
    PuppyCard(puppy = Puppy(), onClick = { /*TODO*/ })
}