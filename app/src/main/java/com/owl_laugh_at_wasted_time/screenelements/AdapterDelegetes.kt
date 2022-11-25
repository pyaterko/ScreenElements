package com.owl_laugh_at_wasted_time.screenelements

import com.elveum.elementadapter.simpleAdapter
import com.owl_laugh_at_wasted_time.screenelements.databinding.ItemLayoutBinding

fun createCodeAdapter(lictener: OnClickCode) =
    simpleAdapter<String, ItemLayoutBinding> {
        bind { item ->
        }
        listeners {
            root.onClick {
                lictener.onClickCode(it)
            }
        }
    }interface OnClickCode {
    fun onClickCode(item: String)
}