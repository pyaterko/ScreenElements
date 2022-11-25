package com.owl_laugh_at_wasted_time.screenelements

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.owl_laugh_at_wasted_time.screenelements.databinding.FragmentTwoBinding

class TwoFragment:Fragment(R.layout.fragment_two) {
    private lateinit var binding: FragmentTwoBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentTwoBinding.bind(view)
        binding.root.setOnClickListener {

        }
    }
}

