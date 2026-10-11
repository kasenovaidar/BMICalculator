package com.example.bmicalculator.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bmicalculator.data.BMIResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CalculatorViewModel : ViewModel() {

    private val _result = MutableStateFlow<BMIResult?>(null)
    val result: StateFlow<BMIResult?> = _result

    private val _errorText = MutableStateFlow<String?>(null)
    val errorText: StateFlow<String?> = _errorText

    fun CalculateResult(height: String, weight: String) {
        viewModelScope.launch {
            if (height.isEmpty() && weight.isEmpty()) {
                _errorText.value = "Введите рост и вес"
            }
            else if (height.isEmpty()) {
                _errorText.value = "Введите рост"
            }
            else if (weight.isEmpty()) {
                _errorText.value = "Введите вес"
            }
            else {
                val height = height.toInt()
                val weight = weight.toInt()
                val heightM: Double = height / 100.0
                val bmi = weight / (heightM * heightM)
                val recommendation = when {
                    bmi <= 16.0 -> "Выраженный дефицит массы тела"
                    bmi > 16.0 && bmi <= 18.5 -> "Недостаточная (дефицит) масса тела"
                    bmi > 18.5 && bmi <= 25.0 -> "Норма"
                    bmi > 25.0 && bmi <= 30.0 -> "Избыточная масса тела (предожирение)"
                    bmi > 30.0 && bmi <= 35.0 -> "Ожирение"
                    bmi > 35.0 && bmi <= 40.0 -> "Резкое ожирение"
                    else -> "Очень резкое ожирение"
                }
                _result.value = BMIResult(bmi, recommendation)
            }
        }
    }
}