package com.sy.sample.kotlin_example2

import android.graphics.Rect
import android.os.Bundle
import android.support.transition.Explode
import android.support.transition.Transition
import android.support.transition.TransitionManager
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.sy.sample.kotlin_example2.model.DataModel
import kotlinx.android.synthetic.main.card_item.view.*
import kotlinx.android.synthetic.main.fragment_recyclerview.*

/**
 * Created by SuYa on 2017. 9. 6..
 */

class RecyclerFragment : Fragment() {

    lateinit var adapter : RecyclerViewAdapter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_recyclerview, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        view.let {
            val layoutmanager = GridLayoutManager(activity, 2)
            recycler_view.layoutManager = layoutmanager
            adapter = RecyclerViewAdapter(DataModel.getDefalutItems())
            recycler_view.adapter = adapter
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


    fun refresh() {
        if (null != recycler_view) {
            adapter.addAllItems(DataModel.getDefalutItems())
        }
    }

    override fun onResume() {
        super.onResume()
        if (null != adapter) {
            when (adapter.isEmptyorNull()) {
                true -> {
                    adapter.addAllItems(DataModel.getDefalutItems())
                }
            }
        }
    }

    inner class RecyclerViewAdapter(items : ArrayList<DataModel.ListItem>) : RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHoler>() {

        var mItems = items;

        fun addAllItems(items : ArrayList<DataModel.ListItem>) {
            mItems = items
            notifyDataSetChanged()
        }

        fun isEmptyorNull() : Boolean {
            if (null == mItems || 0 == mItems.size)
                return true
            return false
        }

        override fun getItemCount(): Int {
            return mItems.size
        }

        override fun onBindViewHolder(holder: CustomViewHoler?, position: Int) {
            val item = mItems.get(position)
            Glide.with(activity)
                    .load(item.imgUrlString)
                    .into(holder!!.image_view)
            holder!!.text_view.text = "#$position"
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHoler {
            val view = LayoutInflater.from(parent!!.context).inflate(R.layout.card_item, parent, false)

            return CustomViewHoler(view).listen( { position, type ->
//                Toast.makeText(activity, "#$position", Toast.LENGTH_SHORT).show()
                val viewRect = Rect()
                view.getGlobalVisibleRect(viewRect)

                val explode : Transition = Explode()
                explode.epicenterCallback = object :Transition.EpicenterCallback() {
                    override fun onGetEpicenter(transition: Transition): Rect {
                        return viewRect
                    }
                }

                explode.duration = 2000
                TransitionManager.beginDelayedTransition(recycler_view, explode)
                mItems.clear()
                notifyDataSetChanged()
            })
        }

        inner class CustomViewHoler(view : View) : RecyclerView.ViewHolder(view) {
            val image_view = view.card_img_view
            val text_view = view.card_title
        }

        fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
            itemView.setOnClickListener {
                event.invoke(getAdapterPosition(), getItemViewType())
            }
            return this
        }
    }
}