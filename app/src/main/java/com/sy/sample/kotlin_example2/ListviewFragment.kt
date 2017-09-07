package com.sy.sample.kotlin_example2

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.sy.sample.kotlin_example2.model.DataModel
import kotlinx.android.synthetic.main.fragment_listview.*
import kotlinx.android.synthetic.main.list_item.*

/**
 * Created by SuYa on 2017. 9. 6..
 */
class ListviewFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_listview, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        val adapter = CustomAdapter(context, R.layout.list_item, DataModel.getDefalutItems())
        list_view.adapter = adapter
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

    inner class CustomAdapter(context: Context, res_id : Int, items : ArrayList<DataModel.ListItem>) : ArrayAdapter<DataModel.ListItem>(context, res_id, items) {

        var mItems : ArrayList<DataModel.ListItem> = items

        fun addAllItems(list : ArrayList<DataModel.ListItem>) {
            this.mItems.clear()
            this.mItems.addAll(list)
            notifyDataSetChanged()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

            val row_view : View?
            val vh : ListRowHolder

            if (null == convertView) {

                val inflater = activity.layoutInflater
                row_view = inflater.inflate(R.layout.list_item, parent, false)
                vh = ListRowHolder(row_view)
                row_view.tag = vh

            } else {
                row_view = convertView
                vh = row_view.tag as ListRowHolder
            }

            val item = mItems.get(position)

            Glide.with(activity)
                    .load(item.imgUrlString)
                    .into(vh.imgview)

            return row_view
        }

        override fun getCount(): Int {
            return this.mItems.size
        }

        override fun getItem(position: Int): DataModel.ListItem {
            return this.mItems.get(position)
        }

        override fun getItemId(position: Int): Long {
            return super.getItemId(position)
        }
    }

    private class ListRowHolder(row: View?) {
        val imgview: ImageView

        init {
            this.imgview = row!!.findViewById<ImageView>(R.id.img_view)
        }
    }

}