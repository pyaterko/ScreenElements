package com.owl_laugh_at_wasted_time.screenelements

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.owl_laugh_at_wasted_time.screenelements.databinding.FragmentOneBinding

class OneFragment : Fragment(R.layout.fragment_one), OnClickCode {

    private lateinit var binding: FragmentOneBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOneBinding.bind(view)

        val adapter= createCodeAdapter(this)
        binding.rvMain.adapter=adapter
            adapter.submitList(listOf("","","","","","","","","","","","","","","","","","",))
    }


    override fun onClickCode(item: String) {
        findNavController().navigate(R.id.action_oneFragment_to_twoFragment)
    }
}