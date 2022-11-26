package com.owl_laugh_at_wasted_time.screenelements

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.owl_laugh_at_wasted_time.screenelements.databinding.FragmentCheckCodeBinding

class CodeFragment:Fragment(R.layout.fragment_check_code) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding=FragmentCheckCodeBinding.bind(view)
        binding.fieldCode.getCode {
            Toast.makeText(requireContext(),it,Toast.LENGTH_LONG).show()
        }

    }

}