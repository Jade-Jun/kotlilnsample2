package com.sy.sample.kotlin_example2

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.sy.sample.kotlin_example2.model.DataModel
import kotlinx.android.synthetic.main.fragment_recyclerview.*
import kotlinx.android.synthetic.main.list_item.view.*

/**
 * Created by SuYa on 2017. 9. 6..
 */

class RecyclerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_recyclerview, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        view.let {
            val layoutmanager = GridLayoutManager(activity, 2)
            recycler_view.layoutManager = layoutmanager
            recycler_view.adapter = RecyclerViewAdapter(DataModel.getDefalutItems())
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() : RecyclerFragment {
            val fragment = RecyclerFragment()
            val arg = Bundle()
            fragment.arguments = arg
            return fragment
        }

    }

    inner class RecyclerViewAdapter(items : ArrayList<DataModel.ListItem>) : RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHoler>() {

        var mItems = items;

        override fun getItemCount(): Int {
            return mItems.size
        }

        override fun onBindViewHolder(holder: CustomViewHoler?, position: Int) {
            val item = mItems.get(position)
            Glide.with(activity)
                    .load(item.imgUrlString)
                    .into(holder!!.img_view)
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHoler {
            val view = LayoutInflater.from(parent!!.context).inflate(R.layout.list_item, parent, false)
            return CustomViewHoler(view)
        }

        inner class CustomViewHoler(view : View) : RecyclerView.ViewHolder(view) {
            val img_view = view.img_view
        }

    }

}