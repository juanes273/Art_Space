package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.Dp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {
    val artworkList = listOf(
        R.drawable.david,
        R.drawable.asuna,
        R.drawable.levi,
        R.drawable.sasha,
        R.drawable.gojo,
        R.drawable.maki,
        R.drawable.toji,
        R.drawable.malenia,
        R.drawable.yuta,
        R.drawable.suguro
    )

    var currentArtworkIndex by remember { mutableStateOf(0) }
    var title by remember { mutableStateOf(R.string.david) }
    var year by remember { mutableStateOf(R.string.david_year) }
    var description by remember { mutableStateOf(R.string.david_description) }
    var nombre by remember { mutableStateOf(R.string.nombre_cod) }
    var imageResource by remember { mutableStateOf(artworkList[currentArtworkIndex]) }

    // Función para actualizar el título y el año en función del índice actual
    fun updateTitleAndYear() {
        title = when (currentArtworkIndex) {
            0 -> R.string.david
            1 -> R.string.asuna
            2 -> R.string.levi
            3 -> R.string.sasha
            4 -> R.string.gojo
            5 -> R.string.maki
            6 -> R.string.toji
            7 -> R.string.malenia
            8 -> R.string.yuta
            9 -> R.string.suguru
            else -> R.string.toji
        }
        year = when (currentArtworkIndex) {
            0 -> R.string.david_year
            1 -> R.string.asuna_year
            2 -> R.string.levi_year
            3 -> R.string.sasha_year
            4 -> R.string.gojo_year
            5 -> R.string.maki_year
            6 -> R.string.toji_year
            7 -> R.string.malenia_year
            8 -> R.string.yuta_year
            9 -> R.string.suguru_year
            else -> R.string.toji_year
        }
        description = when (currentArtworkIndex) {
            0 -> R.string.david_description
            1 -> R.string.asuna_description
            2 -> R.string.levi_decription
            3 -> R.string.sasha_description
            4 -> R.string.gojo_description
            5 -> R.string.maki_description
            6 -> R.string.toji_description
            7 -> R.string.malenia_description
            8 -> R.string.yuta_description
            9 -> R.string.suguru_description
            else -> R.string.toji_description
        }
        imageResource = artworkList[currentArtworkIndex]
    }

    Text(
        text = stringResource(id = nombre),
        fontWeight = FontWeight.Normal,
        color = colorResource(id = R.color.gray_900),
        fontSize = 14.sp,
        textAlign = TextAlign.Center
    )
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ArtworkImage(
            currentArtwork = imageResource
        )
        Spacer(
            modifier = modifier.size(16.dp)
        )
        ArtworkTitle(
            title = title,
            year = year,
        )
        Text(
            text = stringResource(id = description),
            fontWeight = FontWeight.Normal,
            color = colorResource(id = R.color.gray_900),
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )
        Spacer(
            modifier = modifier.size(25.dp)
        )

        Row(
            modifier = modifier.padding(horizontal = 8.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    if (currentArtworkIndex == 0) {
                        currentArtworkIndex = artworkList.size - 1
                    } else {
                        currentArtworkIndex--
                    }
                    updateTitleAndYear()
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(id = R.color.orange_100)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp,
                )
            ) {
                Text(
                    text = stringResource(id = R.string.previous_button_text),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }
            Button(
                onClick = {
                    if (currentArtworkIndex == artworkList.size - 1) {
                        currentArtworkIndex = 0
                    } else {
                        currentArtworkIndex++
                    }
                    updateTitleAndYear()
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(id = R.color.orange_100)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                ),
            ) {
                Text(
                    text = stringResource(id = R.string.next_button_text),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }

            // Botón de reinicio
            IconButton(
                onClick = {
                    currentArtworkIndex = 0
                    updateTitleAndYear()
                },
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .size(48.dp)
                    .padding(8.dp),
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_reset),
                        contentDescription = "Reset Gallery",
                        tint = Color.White
                    )
                }
            )


        }
    }


}



@Composable
fun ArtworkImage(
    modifier: Modifier = Modifier,
    @DrawableRes currentArtwork: Int,
    padding: Dp = Dp(16f)
) {
    Image(
        painter = painterResource(id = currentArtwork),
        contentDescription = null,
        modifier = modifier
            .fillMaxWidth()
            .padding(padding),
        contentScale = ContentScale.FillWidth
    )
}



@Composable
fun ArtworkTitle(
    @StringRes title: Int,
    @StringRes year: Int,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = title),
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.blue_100),
            fontSize = 32.sp,
        )
        Text(
            text = stringResource(id = year),
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.gray_300),
            fontSize = 16.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}

