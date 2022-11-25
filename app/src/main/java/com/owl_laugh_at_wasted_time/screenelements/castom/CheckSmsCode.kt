package com.owl_laugh_at_wasted_time.screenelements.castom

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.textfield.TextInputEditText
import com.owl_laugh_at_wasted_time.screenelements.R
import com.owl_laugh_at_wasted_time.screenelements.databinding.CheckSmsCodeBinding

class CheckSmsCode(
    context: Context,
    attrs: AttributeSet?,
    defStuleAttr: Int,
    defStyleRes: Int
) : ConstraintLayout(context, attrs, defStuleAttr, defStyleRes) {

    private val binding: CheckSmsCodeBinding

    constructor(context: Context, attrs: AttributeSet?, defStuleAttr: Int) : this(
        context,
        attrs,
        defStuleAttr,
        0
    )

    constructor(
        context: Context,
        attrs: AttributeSet?
    ) : this(context, attrs, 0)

    constructor(
        context: Context
    ) : this(context, null)

    init {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.check_sms_code, this, true)
        binding = CheckSmsCodeBinding.bind(this)
        initAttrs(attrs, defStuleAttr, defStyleRes)
    }

    private fun initAttrs(attrs: AttributeSet?, defStuleAttr: Int, defStyleRes: Int) {
        if (attrs == null) return
        val array = arrayListOf<TextInputEditText>()
        with(binding) {
            array.add(editNumberPhone)
            array.add(editNumberPhone1)
            array.add(editNumberPhone2)
            array.add(editNumberPhone3)
        }
        for (index in 0 until array.size) {
            array[index].setOnClickListener {

                (it as TextInputEditText).clearFocus()
                (it as TextInputEditText).setHint(context.getString(R.string.code))
            }
            array[index].movementMethod = null
            array[index].addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {
                    if (index == array.size - 1) {
                        array[index].clearFocus()
                        array[index].text?.clear()
                        array[index].setHint(context.getString(R.string.code))
                    } else {
                        array[index].clearFocus()
                        array[index].text?.clear()
                        array[index].setHint(context.getString(R.string.code))
                        array[index + 1].requestFocus()
                    }
                }
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            })
        }

    }


}