package com.example.calendar_android_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.calendar_android_app.databinding.FragmentMainBinding

class MainFragment: Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bottomNavigation.setOnItemSelectedListener { item ->

            val targetFragment: Fragment = when (item.itemId) {
                R.id.navigation_today -> TodayFragment()
                R.id.navigation_week -> WeekFragment()
                else -> return@setOnItemSelectedListener false
            }

            childFragmentManager.beginTransaction()
                .replace(binding.mainContainer.id, targetFragment)
                .commit()

            true
        }

        if (savedInstanceState == null) {
            binding.bottomNavigation.selectedItemId = R.id.navigation_week
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}