package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Female
import androidx.compose.material.icons.rounded.Male
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.ui.theme.puppyHomeTypography
import com.example.androiddevchallenge.ui.theme.typography
import com.google.android.material.chip.Chip
import dev.chrisbanes.accompanist.coil.CoilImage

/**
 * Created by Farouk on 27/02/2021.
 */
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp,
                        bottom = 8.dp,
                        start = 8.dp,
                        end = 8.dp)
            ) {

                Text(
                    text = puppy.name,
                    style = puppyHomeTypography.h6,
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 8.dp),
                )
                Icon(
                    imageVector = when (puppy.gender) {
                        Puppy.Gender.MALE -> Icons.Rounded.Male
                        Puppy.Gender.FEMALE -> Icons.Rounded.Female
                    },
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.End)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewPuppyCard() {
    PuppyCard(puppy = Puppy(), onClick = { /*TODO*/ })
}