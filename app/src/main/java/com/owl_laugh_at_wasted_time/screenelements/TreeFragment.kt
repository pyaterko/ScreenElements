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
        binding.root.setOnClickListener {
            findNavController().navigate(R.id.action_treeFragment_to_fourFragment)
        }
        binding.editNumberPhone.requestFocus()
        binding.editNumberPhone.movementMethod = null
    }

    override fun onStart() {
        super.onStart()

        binding.editNumberPhone.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.editNumberPhone1.requestFocus()
                binding.editNumberPhone1.movementMethod = null
                binding.editNumberPhone.clearFocus()
            }
        })

        binding.editNumberPhone1.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.editNumberPhone2.requestFocus()
                binding.editNumberPhone2.movementMethod = null
                binding.editNumberPhone1.clearFocus()
            }
        })
        binding.editNumberPhone2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.editNumberPhone3.requestFocus()
                binding.editNumberPhone3.movementMethod = null
                binding.editNumberPhone2.clearFocus()
            }
        })
        binding.editNumberPhone3.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.editNumberPhone3.clearFocus()
            }
        })
    }
}