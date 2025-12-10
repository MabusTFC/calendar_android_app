package com.example.calendar_android_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.calendar_android_app.databinding.ItemDayBinding
import com.example.calendar_android_app.model.Day
import java.time.format.TextStyle
import java.util.Locale

class WeekAdapter(private val days: List<Day>): RecyclerView.Adapter<WeekAdapter.DayViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DayViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDayBinding.inflate(inflater, parent, false)
        return DayViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: DayViewHolder,
        position: Int
    ) {
        val day = days[position]
        holder.bind(day)
    }

    override fun getItemCount(): Int {
        return days.size
    }

    class DayViewHolder(private val binding: ItemDayBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(day: Day) = with(binding){
            val dayName = day.dayOfWeek.getDisplayName(TextStyle.FULL, Locale("ru")).uppercase(Locale("ru"))
            cardDayName.text = dayName

            val lessonsText = day.lessons.joinToString("\n") { lesson ->
                "${lesson.startTime.toString()} - ${lesson.subject}"
            }
            cardLessons.text = lessonsText

        }

    }


}