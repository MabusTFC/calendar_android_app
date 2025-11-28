package com.example.calendar_android_app.model

data class Week(
    val type: WeekParity,
    val days: List<Day>
)