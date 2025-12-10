package com.example.calendar_android_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.calendar_android_app.databinding.ActivityMainBinding
import com.example.calendar_android_app.model.Day
import com.example.calendar_android_app.model.Lesson
import com.example.calendar_android_app.model.Week
import com.example.calendar_android_app.model.WeekParity
import java.time.DayOfWeek
import java.time.LocalTime

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, MainFragment())
            .commit()
        }
    }


    //Тестовые данные
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




