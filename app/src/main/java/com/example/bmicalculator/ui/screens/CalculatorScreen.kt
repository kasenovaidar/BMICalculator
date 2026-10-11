package com.example.bmicalculator.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.example.bmicalculator.components.MainButton
import com.example.bmicalculator.components.MainCard
import com.example.bmicalculator.components.TextInput
import com.example.bmicalculator.ui.theme.BMIGrayLight
import com.example.bmicalculator.ui.theme.BMITypography

@Composable
@Preview
fun CalculatorScreen() {
    val heightState = rememberTextFieldState()
    val weightState = rememberTextFieldState()

    val inputTransformation = InputTransformation {
        if (!asCharSequence().isDigitsOnly()) {
            revertAllChanges()
        }
    }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BMIGrayLight)
                .padding(innerPadding)
                .offset(y = 160.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Индекс массы тела", style = BMITypography.Title.copy(fontSize = 24.sp))
            MainCard(
                Modifier.fillMaxHeight(0.35f).padding(vertical = 24.dp)
            ) {
                Text(
                    text = "Персональные данные",
                    style = BMITypography.Title.copy(fontSize = 16.sp),
                    modifier = Modifier.padding(top = 8.dp)
                )
                TextInput(
                    label = "Рост (см)",
                    placeholder = "185",
                    textState = heightState,
                    inputTransformation = inputTransformation
                )
                TextInput(
                    label = "Вес (кг)",
                    placeholder = "80",
                    textState = weightState,
                    modifier = Modifier.padding(top = 8.dp),
                    inputTransformation = inputTransformation
                )
            }
            MainButton(text = "РАССЧИТАТЬ") {

            }
        }
    }
}