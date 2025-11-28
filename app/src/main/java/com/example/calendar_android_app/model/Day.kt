package com.example.calendar_android_app.model

import java.time.DayOfWeek

data class Day(
    val dayOfWeek: DayOfWeek,
    val lessons: List<Lesson>
)