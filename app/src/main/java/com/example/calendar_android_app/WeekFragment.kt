package com.example.calendar_android_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calendar_android_app.adapter.WeekAdapter
import com.example.calendar_android_app.databinding.FragmentWeekBinding
import com.example.calendar_android_app.model.WeekParity
import com.example.calendar_android_app.model.WeekService


class WeekFragment: Fragment() {
    private var _binding: FragmentWeekBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentWeekBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.scheduleRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.weekSelectorGroup.setOnCheckedChangeListener { _, checkedId ->
            val selectedParity = when (checkedId) {
                R.id.radio_odd_week -> WeekParity.ODD
                R.id.radio_even_week -> WeekParity.EVEN
                else -> return@setOnCheckedChangeListener
            }
            updateSchedule(selectedParity)
        }

        if (savedInstanceState == null) {
            val currentParity = WeekService.getCurrentWeekParity()

            val defaultRadioId = if (currentParity == WeekParity.ODD)
                R.id.radio_odd_week
            else
                R.id.radio_even_week

            binding.weekSelectorGroup.check(defaultRadioId)
        }
    }

    private fun updateSchedule(parity: WeekParity) {
        val weekSchedule = WeekService.getSchedule(parity)
        val adapter = WeekAdapter(weekSchedule.days)
        binding.scheduleRecyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}