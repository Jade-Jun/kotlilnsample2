package com.sy.sample.kotlin_example2

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by SuYa on 2017. 9. 6..
 */
class ListviewFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_listview, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {

    }

    companion object {

        @JvmStatic
        fun newInstance() : ListviewFragment {
            val fragment = ListviewFragment()
            val arg = Bundle()
            fragment.arguments = arg
            return fragment
        }

    }

}