package com.example.calendar_android_app.model

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime
import java.time.temporal.WeekFields
import java.util.Locale

object WeekService {

    fun getCurrentWeekParity(): WeekParity{
        val date = LocalDate.now()

        val weekFields = WeekFields.of(Locale.getDefault())
        val weekNumber = date.get(weekFields.weekOfYear())

        return if (weekNumber % 2 == 0) WeekParity.EVEN else WeekParity.ODD
    }

    fun getSchedule(parity: WeekParity): Week {
        when(parity) {
            WeekParity.ODD -> return getOddWeekSchedule()
            WeekParity.EVEN -> return getEvenWeekSchedule()
        }
    }

    fun getScheduleCurrentWeek(): Week {
        val parity = getCurrentWeekParity()
        return getSchedule(parity)
    }

    fun getShudleCurrentDay(): Day? {
        val currentWeek = getScheduleCurrentWeek()
        val currentDayOfWeek = LocalDate.now().dayOfWeek


        return currentWeek.days.find { it.dayOfWeek == currentDayOfWeek }
    }


    fun getOddWeekSchedule(): Week {
        return Week(
            type = WeekParity.ODD,
            days = listOf(
                Day(
                    dayOfWeek = DayOfWeek.MONDAY,
                    lessons = listOf(
                        Lesson(
                            startTime = LocalTime.of(8, 30),
                            endTime = LocalTime.of(10, 5),
                            subject = "Математический анализ"
                        ),
                        Lesson(
                            startTime = LocalTime.of(10, 20),
                            endTime = LocalTime.of(11, 55),
                            subject = "Программирование"
                        )
                    )
                ),
            )
        )
    }

    fun getEvenWeekSchedule(): Week {
        return Week(
            type = WeekParity.EVEN,
            days = listOf(
                Day(
                    dayOfWeek = DayOfWeek.MONDAY,
                    lessons = listOf(
                        Lesson(
                            startTime = LocalTime.of(8, 30),
                            endTime = LocalTime.of(10, 5),
                            subject = "Математический анализ"
                        ),
                        Lesson(
                            startTime = LocalTime.of(10, 20),
                            endTime = LocalTime.of(11, 55),
                            subject = "Программирование"
                        )
                    )
                ),
            )
        )
    }
}


