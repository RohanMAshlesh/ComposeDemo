package com.ashlesh.composedemo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.ashlesh.composedemo.ui.theme.ComposeDemoTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackCompose()
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun JetpackCompose() {
    Card {
        var expanded by remember {
            mutableStateOf(false)
        }
        Column(Modifier.clickable { expanded = !expanded }) {
            var check = Random.nextBoolean()
            Log.d("Ashtag","$check")
            if(check) {
                Image(painterResource(R.drawable.ic_baseline_android_green),"Android")
            }
            else {
                Image(painterResource(R.drawable.ic_baseline_android_24),"Android")
            }
            AnimatedVisibility(visible = expanded) {
                if(check) {
                    Text(
                        text = "Jetpack Compose",
                        style = MaterialTheme.typography.h2
                    )
                }
                else {
                    Text(
                        text = "Rohan Ashlesh",
                        color = colorResource(id = R.color.purple_200),
                        style = MaterialTheme.typography.h2

                    )
                }


            }

        }
    }
}