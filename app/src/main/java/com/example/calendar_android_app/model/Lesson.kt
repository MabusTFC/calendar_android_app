package com.example.calendar_android_app.model

import java.time.LocalTime

data class Lesson(
    val startTime: LocalTime,
    val endTime: LocalTime,
    val subject: String
)