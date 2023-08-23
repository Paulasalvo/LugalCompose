package com.cuanto.lugalcompose

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cuanto.lugal.ui.ActionButton
import com.cuanto.lugal.ui.AddButton
import com.cuanto.lugal.ui.DialogMessage
import com.cuanto.lugal.ui.OutlineBox
import com.cuanto.lugal.ui.Spinner
import com.cuanto.lugal.ui.SupportImageDocumentDialog
import com.cuanto.lugal.ui.TemplateScreen

@Composable
fun LugalScreen() {
    TemplateScreen(
        textHeader = stringResource(id = R.string.app_name)
    ) {
        LugalScreen(modifier = Modifier)
    }
}

@Composable
private fun LugalScreen(
    modifier: Modifier = Modifier,
) {
    var showDialog by remember { mutableStateOf(false) }
    var showImageDocumentDialog by remember { mutableStateOf(false) }
    var isExpanded by remember { mutableStateOf(false) }

    val context = LocalContext.current

        Surface(
            modifier = modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            Column(
                modifier = Modifier.padding(top = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = { showDialog = true }) {
                    Text(text = stringResource(id = R.string.show_dialog))
                }

                OutlineBox(modifier = Modifier.padding(16.dp)) {
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = stringResource(id = R.string.app_name)
                    )
                }
                ActionButton(
                    modifier = Modifier.padding(16.dp),
                    text = stringResource(id = R.string.app_name),
                    iconRight = painterResource(id = com.cuanto.lugal.R.drawable.ic_arrow_right),
                    description = stringResource(com.cuanto.lugal.R.string.arrow_right),
                    onClick = {}
                )
                ActionButton(
                    modifier = Modifier.padding(16.dp),
                    text = stringResource(id = R.string.app_name),
                    iconRight = painterResource(id = com.cuanto.lugal.R.drawable.ic_arrow_right),
                    description = stringResource(com.cuanto.lugal.R.string.arrow_right),
                    isInProcess = true,
                    onClick = {}
                )

                ActionButton(
                    modifier = Modifier.padding(16.dp),
                    text = stringResource(id = R.string.app_name),
                    iconRight = painterResource(id = com.cuanto.lugal.R.drawable.ic_arrow_right),
                    description = stringResource(com.cuanto.lugal.R.string.arrow_right),
                    isDisabled = true,
                    onClick = {}
                )

                AddButton(
                    text = stringResource(id = R.string.app_name),
                    colorIcon = MaterialTheme.colorScheme.primary,
                    onClick = { showImageDocumentDialog = true }
                )

                Spinner(
                    modifier = Modifier.padding(8.dp),
                    text = stringResource(id = R.string.t_new),
                    items = getDummyList(),
                    expanded = isExpanded,
                    onExpanded = { isExpanded = !isExpanded },
                    onClick = { value ->
                        Toast.makeText(context, "Click on: $value", Toast.LENGTH_SHORT).show()
                              },
                    content = { value ->
                        Text(
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp),
                            text = value.toString()
                        )
                    }
                )
            }
            if (showDialog) {
                DialogMessage(
                    title = stringResource(id = R.string.hello),
                    body = stringResource(id = R.string.welcome),
                    textButton = stringResource(id = R.string.accept),
                    onDismiss = { showDialog = false },
                )
            }

            if (showImageDocumentDialog) {
                SupportImageDocumentDialog(
                    title = stringResource(id = R.string.choose_option),
                    firstButtonText = stringResource(id = R.string.take_photo),
                    secondButtonText = stringResource(id = R.string.choose_from_gallery),
                    textCancelButton = stringResource(id = R.string.cancel),
                    onDismissRequest = { showImageDocumentDialog = false },
                    onRequestDocument = {},
                    onRequestGallery = {}
                )
            }
    }
}

private fun getDummyList() = listOf(1, 2, 3, 4)

@Preview()
@Composable
fun LugalScreenPreview() {
    LugalScreen(modifier = Modifier)
}
