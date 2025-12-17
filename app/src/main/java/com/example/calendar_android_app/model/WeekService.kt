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


    private fun getOddWeekSchedule(): Week {
        return Week(
            type = WeekParity.ODD,
            days = listOf(
                Day(DayOfWeek.MONDAY, listOf(
                    Lesson(LocalTime.of(17, 10), LocalTime.of(18, 40), "Озд. физ. культура (Лек.)"),
                    Lesson(LocalTime.of(18, 50), LocalTime.of(20, 20), "Базы и хранилища данных (Лек.)")
                )),
                Day(DayOfWeek.TUESDAY, listOf(
                    Lesson(LocalTime.of(18, 50), LocalTime.of(20, 20), "Упр. IT-проектами (Лек.)"),
                    Lesson(LocalTime.of(20, 30), LocalTime.of(22, 0), "Упр. IT-проектами (Пр.)")
                )),
                Day(DayOfWeek.THURSDAY, listOf(
                    Lesson(LocalTime.of(13, 50), LocalTime.of(15, 20), "Интернет-маркетинг (Лек.)"),
                    Lesson(LocalTime.of(15, 30), LocalTime.of(17, 0), "Интернет-маркетинг (Пр.)"),
                    Lesson(LocalTime.of(17, 10), LocalTime.of(18, 40), "Интернет-маркетинг (Пр.)")
                )),
                Day(DayOfWeek.FRIDAY, listOf(
                    Lesson(LocalTime.of(15, 30), LocalTime.of(17, 0), "Архитектура предприятия (Лек.)"),
                    Lesson(LocalTime.of(17, 10), LocalTime.of(18, 40), "Архитектура предприятия (Пр.)")
                )),
                Day(DayOfWeek.SATURDAY, listOf(
                    Lesson(LocalTime.of(8, 30), LocalTime.of(10, 0), "Анализ данных (Лек.)"),
                    Lesson(LocalTime.of(15, 30), LocalTime.of(17, 0), "Техн. приклад. прогр-ия (Лек.)"),
                    Lesson(LocalTime.of(15, 30), LocalTime.of(17, 0), "Создание бизнес-прилож. (Лек.)")
                ))
            )
        )
    }

    private fun getEvenWeekSchedule(): Week {
        return Week(
            type = WeekParity.EVEN,
            days = listOf(
                Day(DayOfWeek.MONDAY, listOf(
                    Lesson(LocalTime.of(17, 10), LocalTime.of(18, 40), "Озд. физ. культура (Лек.)"),
                    Lesson(LocalTime.of(18, 50), LocalTime.of(20, 20), "Базы и хранилища данных (Пр.)"),
                    Lesson(LocalTime.of(20, 30), LocalTime.of(22, 0), "Базы и хранилища данных (Пр.)")
                )),
                Day(DayOfWeek.TUESDAY, listOf(
                    Lesson(LocalTime.of(18, 50), LocalTime.of(20, 20), "Упр. IT-проектами (Лек.)"),
                    Lesson(LocalTime.of(20, 30), LocalTime.of(22, 0), "Упр. IT-проектами (Пр.)")
                )),
                Day(DayOfWeek.WEDNESDAY, listOf(
                    Lesson(LocalTime.of(17, 10), LocalTime.of(18, 40), "Интернет-технологии (Лек.)"),
                    Lesson(LocalTime.of(18, 50), LocalTime.of(20, 20), "Интернет-технологии (Пр.)"),
                    Lesson(LocalTime.of(20, 30), LocalTime.of(22, 0), "Интернет-технологии (Пр.)")
                )),
                Day(DayOfWeek.FRIDAY, listOf(
                    Lesson(LocalTime.of(15, 30), LocalTime.of(17, 0), "Архитектура предприятия (Лек.)"),
                    Lesson(LocalTime.of(17, 10), LocalTime.of(18, 40), "Архитектура предприятия (Пр.)"),
                    Lesson(LocalTime.of(18, 50), LocalTime.of(20, 20), "Базы и хранилища данных (Пр.)")
                )),
                Day(DayOfWeek.SATURDAY, listOf(
                    Lesson(LocalTime.of(12, 10), LocalTime.of(13, 40), "Анализ данных (Пр.)"),
                    Lesson(LocalTime.of(13, 50), LocalTime.of(15, 20), "Анализ данных (Пр.)"),
                    Lesson(LocalTime.of(15, 30), LocalTime.of(17, 0), "Техн. приклад. прогр-ия (Пр.)"),
                    Lesson(LocalTime.of(15, 30), LocalTime.of(17, 0), "Создание бизнес-прилож. (Пр.)"),
                    Lesson(LocalTime.of(17, 10), LocalTime.of(18, 40), "Техн. приклад. прогр-ия (Пр.)"),
                    Lesson(LocalTime.of(17, 10), LocalTime.of(18, 40), "Создание бизнес-прилож. (Пр.)")
                ))
            )
        )
    }
}


