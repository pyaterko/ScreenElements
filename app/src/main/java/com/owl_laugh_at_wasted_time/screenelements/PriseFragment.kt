package com.owl_laugh_at_wasted_time.screenelements

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.owl_laugh_at_wasted_time.screenelements.databinding.FragmentPriseBinding

class PriseFragment:Fragment(R.layout.fragment_prise) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding=FragmentPriseBinding.bind(view)
        binding.oneElement.getPrise {
            Toast.makeText(requireContext(),it,Toast.LENGTH_LONG).show()
        }
    }
}