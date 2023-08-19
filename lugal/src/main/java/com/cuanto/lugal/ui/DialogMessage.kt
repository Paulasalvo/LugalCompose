package com.cuanto.lugal.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cuanto.lugal.common.body
import com.cuanto.lugal.common.textButton
import com.cuanto.lugal.common.title

@Composable
fun DialogMessage(
    modifier: Modifier = Modifier,
    title: String,
    body: String,
    textButton: String,
    onDismiss: () -> Unit,
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = { onDismiss() },
        title = {
            Text(
                text = title,
                style = titleTextStyle,
            )
        },
        text = { Text(text = body, style = bodyTextStyle) },
        confirmButton = {
            TextButton(
                onClick = onDismiss,
                modifier = Modifier.padding(8.dp),
            ) {
                Text(
                    text = textButton,
                    style = buttonTextStyle,
                )
            }
        },
    )
}

private val titleTextStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
private val bodyTextStyle = TextStyle(fontSize = 14.sp)
private val buttonTextStyle = TextStyle(fontSize = 16.sp)

@Preview
@Composable
fun DialogMessagePreview() {
    MaterialTheme {
        DialogMessage(
            title = title,
            body = body,
            textButton = textButton,
            onDismiss = {}
        )
    }
}
