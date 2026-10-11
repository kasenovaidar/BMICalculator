package com.example.bmicalculator.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.bmicalculator.ui.theme.BMIGrayLight
import com.example.bmicalculator.ui.theme.BMITypography

@Composable
@Preview
fun CalculatorScreen() {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BMIGrayLight)
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Индекс массы тела", style = BMITypography.Title.copy(fontSize = 24.sp))
            Text("1")
            Text("1")
            Text("1")
        }
    }
}