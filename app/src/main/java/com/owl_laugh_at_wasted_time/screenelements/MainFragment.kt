package com.owl_laugh_at_wasted_time.screenelements

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.owl_laugh_at_wasted_time.screenelements.databinding.MainScreenBinding

class MainFragment : Fragment(R.layout.main_screen) {
    private lateinit var binding: MainScreenBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MainScreenBinding.bind(view)

        binding.button7.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_codeFragment)
        }
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_oneFragment)
        }
        binding.button6.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_priseFragment)
        }
        binding.button8.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_twoFragment)
        }
        binding.button9.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_treeFragment)
        }
        binding.button10.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_fourFragment)
        }
    }

}