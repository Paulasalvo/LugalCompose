package com.cuanto.lugalcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.cuanto.lugal.ui.DialogMessage
import com.cuanto.lugalcompose.ui.theme.LugalComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LugalComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    DialogMessage(
                        title = "Hello",
                        body = "Bienvenido",
                        textButton = "Aceptar",
                        onDismiss = {},
                    )
                }
            }
        }
    }
}
