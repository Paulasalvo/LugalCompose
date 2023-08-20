package com.cuanto.lugal.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun <T> Spinner(
    modifier: Modifier = Modifier,
    text: String,
    items: List<T> = listOf(),
    isDisabled: Boolean = false,
    showTotal: Boolean = false,
    showIcon: Boolean = true,
    expanded: Boolean = false,
    onExpanded: (Boolean)->Unit,
    content: @Composable (T)->Unit
){
    Column(
        modifier = modifier.animateContentSize()
    ) {
        Prompt(
            text = text,
            items = items,
            expanded = expanded,
            isDisabled = isDisabled,
            showTotal = showTotal,
            showIcon = showIcon,
            onClickExpanded = { onExpanded(!expanded) })

        if ((expanded and items.isNotEmpty())){
            OutlineBox(
                modifier = Modifier.offset(y = (-2).dp)
            ) {
                Column(
                    modifier = Modifier.padding(vertical = 16.dp)
                ) {
                    items.forEach {item ->
                        content(item)
                    }
                }
            }
        }
    }
}

/*
@Preview(showBackground = true, widthDp = 420)
@Composable
fun SpinnerPreview(){
    MaterialTheme() {
        Spinner(
            modifier = Modifier.padding(8.dp),
            text = "New",
            items = listOf("Test 1", "Test 2", "Test 3"),
            showTotal = true,
            expanded = false,
            onExpanded = {},
            content = {}
        )
    }
}
*/
