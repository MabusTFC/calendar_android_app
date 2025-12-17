package com.example.calendar_android_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.calendar_android_app.databinding.FragmentTodayBinding
import com.example.calendar_android_app.model.WeekParity
import com.example.calendar_android_app.model.WeekService
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

class TodayFragment: Fragment() {
    private var _binding: FragmentTodayBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTodayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val todaySchedule = WeekService.getShudleCurrentDay()
        val currentParity = WeekService.getCurrentWeekParity()
        val currentDayName = LocalDate.now().dayOfWeek.getDisplayName(TextStyle.FULL, Locale("ru")).uppercase(Locale("ru"))

        binding.todayDayName.text = "Сегодня: $currentDayName"
        val parityText = if (currentParity == WeekParity.ODD) "1" else "2"
        binding.weekParityIndicator.text = "Текущая неделя: $parityText"

        if (todaySchedule != null && todaySchedule.lessons.isNotEmpty()) {
            val lessonsText = todaySchedule.lessons.joinToString("\n") { lesson ->
                "${lesson.startTime} - ${lesson.subject}"
            }
            binding.todayLessons.text = lessonsText
        } else {
            binding.todayLessons.text = "Пар сегодня нет! 🎉"
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}