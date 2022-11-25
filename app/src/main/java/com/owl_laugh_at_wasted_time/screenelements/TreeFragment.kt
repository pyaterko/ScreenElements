package com.owl_laugh_at_wasted_time.screenelements

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.owl_laugh_at_wasted_time.screenelements.databinding.FragmentTreeBinding

class TreeFragment : Fragment(R.layout.fragment_tree) {

    private lateinit var binding: FragmentTreeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTreeBinding.bind(view)
        binding.include2.textView12.setText(R.string.app_name)
        binding.root.setOnClickListener {

        }

    }


}