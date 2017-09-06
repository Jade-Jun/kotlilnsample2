package com.sy.sample.kotlin_example2.custom_view

import android.app.Fragment
import android.os.Bundle
import android.view.View

/**
 * Created by SuYa on 2017. 9. 6..
 */
class BaseFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(): BaseFragment {
            val newsFragment = BaseFragment()
            val args = Bundle()
            newsFragment.arguments = args
            return newsFragment
        }
    }

    fun getInitialFragment() : Fragment {
        return BaseFragment.newInstance()
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}