package com.owl_laugh_at_wasted_time.screenelements.castom

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Parcel
import android.os.Parcelable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.owl_laugh_at_wasted_time.screenelements.R
import com.owl_laugh_at_wasted_time.screenelements.databinding.ElementOneBinding

typealias OnPriseListener = (String) -> Unit

class OneElement(
    context: Context,
    attrs: AttributeSet?,
    defStuleAttr: Int,
    defStyleRes: Int
) : ConstraintLayout(context, attrs, defStuleAttr, defStyleRes) {

    private val binding: ElementOneBinding
    private var listener: OnPriseListener? = null

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
        val arrayButton = arrayListOf<Button>()
        with(binding) {
            val backgroundClick =
                typedArray.getColor(R.styleable.OneElement_backgroundClick, Color.GRAY)
            val backgroundUnClick =
                typedArray.getColor(R.styleable.OneElement_backgroundUnClick, Color.BLUE)
            val isClick = typedArray.getBoolean(R.styleable.OneElement_isClick, true)
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
            for (index in 0 until arrayButton.size) {
                arrayButton[index].setOnClickListener {
                    for (but in arrayButton) {
                        but.backgroundTintList = ColorStateList.valueOf(backgroundUnClick)
                        but.setTextColor(Color.BLACK)
                    }
                    it.backgroundTintList = ColorStateList.valueOf(backgroundClick)
                    (it as Button).setTextColor(Color.WHITE)
                    listener?.invoke(getPrise(index))
                }
            }


        }

        typedArray.recycle()
    }

    override fun onSaveInstanceState(): Parcelable? {
        val superState = super.onSaveInstanceState()!!
        val savedState = SavedStat(superState)
        savedState.background0 = binding.button1.backgroundTintList!!.defaultColor
        savedState.background1 = binding.button2.backgroundTintList!!.defaultColor
        return savedState
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val savedState=state as SavedStat
        super.onRestoreInstanceState(savedState.superState)
        binding.button1.setBackgroundColor(savedState.background0)
        binding.button2.setBackgroundColor(savedState.background1)
    }

    fun getPrise(listener: OnPriseListener) {
        this.listener = listener
    }

    private fun getPrise(number: Int): String {
        return when (number) {
            0 -> "4000"
            1 -> "6000"
            2 -> "9000"
            3 -> "15000"
            else -> "Свой номинал"
        }
    }

    class SavedStat : BaseSavedState {
        var background0 = 0
        var background1 = 0

        constructor(superState: Parcelable) : super(superState)
        constructor(parcel: Parcel) : super(parcel) {
            background0 = parcel.readInt()
            background1 = parcel.readInt()
        }

        override fun writeToParcel(out: Parcel, flags: Int) {
            super.writeToParcel(out, flags)
            out.writeInt(background0)
            out.writeInt(background1)
        }

        companion object {
            @JvmField
            val CREATOR: Parcelable.Creator<SavedStat> = object : Parcelable.Creator<SavedStat> {
                override fun createFromParcel(p0: Parcel): SavedStat {
                    return SavedStat(p0)
                }

                override fun newArray(p0: Int): Array<SavedStat?> {
                    return Array(p0) { null }
                }

            }
        }
    }
}