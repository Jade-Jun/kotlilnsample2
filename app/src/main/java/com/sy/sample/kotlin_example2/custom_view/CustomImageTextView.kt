package com.sy.sample.kotlin_example2.custom_view

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide.init
import com.sy.sample.kotlin_example2.R
import kotlinx.android.synthetic.main.card_item.view.*
import java.util.jar.Attributes

/**
 * Created by SuYa on 2017. 9. 7..
 */
class CustomImageTextView : RelativeLayout {

//    private val bg : RelativeLayout? = null
//    val imageview : ImageView? = null
//    private val title : TextView? = null


    constructor(context: Context) : super(context, null) {
        initView()
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet, 0) {
        initView()
        getAttrs(attributeSet)
    }

    constructor(context: Context, attributeSet: AttributeSet, defStyle: Int) : super(context, attributeSet, defStyle) {
        initView()
        getAttrs(attributeSet, defStyle)
    }

    private fun initView() {
        val infService = Context.LAYOUT_INFLATER_SERVICE as String
        val layoutInflater = context.getSystemService(infService) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.card_item, this, false)
        addView(view)
    }

    private fun getAttrs(attributeSet: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.custom_image_text_view)
        setTypeArray(typedArray)
    }

    private fun getAttrs(attributeSet: AttributeSet, defStyle: Int) {
        val typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.custom_image_text_view, defStyle, 0)
        setTypeArray(typedArray)
    }

    private fun setTypeArray(typeArray: TypedArray) {

        val bg_res_id = typeArray.getResourceId(R.styleable.custom_image_text_view_bg, R.color.white)
        bg_layout!!.setBackgroundResource(bg_res_id)

        val img_src = typeArray.getResourceId(R.styleable.custom_image_text_view_img_src, R.drawable.ic_home)
        card_img_view!!.setImageResource(img_src)

        val text_color = typeArray.getColor(R.styleable.custom_image_text_view_textColor, 0)
        card_title!!.setTextColor(text_color)

        val text_string = typeArray.getString(R.styleable.custom_image_text_view_text)
        card_title!!.text = text_string

        typeArray.recycle()
    }

    internal fun setBg(bg_res_id: Int) {
        bg_layout!!.setBackgroundResource(bg_res_id)
    }

    internal fun setImageView(img_src: Int) {
        card_img_view!!.setImageResource(img_src)
    }

    internal fun setTextView(color: Int) {
        card_title!!.setTextColor(color)
    }

    internal fun setTextView(text: String) {
        card_title!!.setText(text)
    }

}