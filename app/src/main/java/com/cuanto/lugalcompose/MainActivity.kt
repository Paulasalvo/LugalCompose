package com.cuanto.lugalcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.cuanto.lugalcompose.ui.theme.LugalComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LugalComposeTheme {
                MenuScreen()
            }
        }
    }
}
