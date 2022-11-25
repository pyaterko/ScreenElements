package com.owl_laugh_at_wasted_time.screenelements

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.owl_laugh_at_wasted_time.screenelements.databinding.FragmentFourBinding

class FourFragment: Fragment(R.layout.fragment_four){

    private lateinit var binding:FragmentFourBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentFourBinding.bind(view)
    }
}