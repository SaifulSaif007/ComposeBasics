package com.example.codelab2.ui

import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstraintScreen() {
    ConstraintLayout {
        val (button, text) = createRefs()

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 0.dp)
            },
            colors = buttonColors(
                backgroundColor = Color.Red,
                contentColor = Color.White
            )

        ) {
            Text(text = "Click Me")
        }


        Button(onClick = {},
            modifier = Modifier.constrainAs(text) {
                start.linkTo(button.end, margin = (-14).dp)
            }) {
            Text(text = "New Button")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConstraintScreenPreview() {
    ConstraintScreen()
}

