package com.sy.sample.kotlin_example2

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_webview.*

/**
 * Created by SuYa on 2017. 9. 6..
 */
class WebViewFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_webview, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        webview.loadUrl("https://github.com/SuSkaJun")
    }

    companion object {

        @JvmStatic
        fun newInstance() : WebViewFragment {
            val fragment = WebViewFragment()
            val arg = Bundle()
            fragment.arguments = arg
            return fragment
        }

    }

}