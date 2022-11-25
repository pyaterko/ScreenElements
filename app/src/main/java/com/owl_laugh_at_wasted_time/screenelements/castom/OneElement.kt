package com.owl_laugh_at_wasted_time.screenelements.castom

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.owl_laugh_at_wasted_time.screenelements.R
import com.owl_laugh_at_wasted_time.screenelements.databinding.ElementOneBinding

class OneElement(
    context: Context,
    attrs: AttributeSet?,
    defStuleAttr: Int,
    defStyleRes: Int
) : ConstraintLayout(context, attrs, defStuleAttr, defStyleRes) {

    private val binding: ElementOneBinding

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
        inflater.inflate(R.layout.element_one, this, true)
        binding = ElementOneBinding.bind(this)
        initAttrs(attrs, defStuleAttr, defStyleRes)
    }

    private fun initAttrs(attrs: AttributeSet?, defStuleAttr: Int, defStyleRes: Int) {
        if (attrs == null) return
        val typedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.OneElement,
            defStuleAttr,
            defStyleRes
        )
        val arrayButton= arrayListOf<Button>()
        with(binding) {
            val backgroundClick =
                typedArray.getColor(R.styleable.OneElement_backgroundClick, Color.GRAY)
            val backgroundUnClick =
                typedArray.getColor(R.styleable.OneElement_backgroundUnClick, Color.BLUE)
            val isClick=typedArray.getBoolean(R.styleable.OneElement_isClick,true)
            arrayButton.add(button1)
            arrayButton.add(button2)
            arrayButton.add(button3)
            arrayButton.add(button4)
            arrayButton.add(button5)
            button1.backgroundTintList = ColorStateList.valueOf(backgroundClick)
            button2.backgroundTintList = ColorStateList.valueOf(backgroundUnClick)
            button3.backgroundTintList = ColorStateList.valueOf(backgroundUnClick)
            button4.backgroundTintList = ColorStateList.valueOf(backgroundUnClick)
            button5.backgroundTintList = ColorStateList.valueOf(backgroundUnClick)
            for (index in 0 until arrayButton.size){
                arrayButton[index].setOnClickListener {
                    for (but in arrayButton){
                        but.backgroundTintList = ColorStateList.valueOf(backgroundUnClick)
                        but.setTextColor(Color.BLACK)
                    }
                    it.backgroundTintList = ColorStateList.valueOf(backgroundClick)
                    (it as Button).setTextColor(Color.WHITE)
                }
            }


        }



        typedArray.recycle()
    }
}