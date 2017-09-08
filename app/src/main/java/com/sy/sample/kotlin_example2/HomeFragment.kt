package com.sy.sample.kotlin_example2

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_item.view.*
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by SuYa on 2017. 9. 6..
 */

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2017/09/03/17/26/woman-2711279__340.jpg")
                .into(custom_view1.card_img_view)

        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2017/08/08/00/05/nature-2609430__340.jpg")
                .into(custom_view2.card_img_view)

        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2017/08/27/15/09/california-2686349__340.jpg")
                .into(custom_view3.card_img_view)

        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2017/08/18/17/26/lighthouse-2655772__340.jpg")
                .into(custom_view4.card_img_view)

        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2017/03/27/09/07/macro-2177768__340.jpg")
                .into(custom_view5.card_img_view)
    }

    companion object {

        @JvmStatic
        fun newInstance() : HomeFragment {
            val fragment = HomeFragment()
            val arg = Bundle()
            fragment.arguments = arg
            return fragment
        }

    }

}