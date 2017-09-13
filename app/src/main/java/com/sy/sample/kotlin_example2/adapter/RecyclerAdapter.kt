package com.sy.sample.kotlin_example2.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.sy.sample.kotlin_example2.R
import com.sy.sample.kotlin_example2.model.DataModel
import kotlinx.android.synthetic.main.card_item.view.*

/**
 * Created by SuYa on 2017. 9. 12..
 */
class RecyclerAdapter(context : Context, items : ArrayList<DataModel.ListItem>) : RecyclerView.Adapter<RecyclerAdapter.CustomViewHoler>(){
    var mItems = items;
    var mContext = context

    private var mclickListener : ItemClickListener? = null

    fun setClickListener(clickListener: ItemClickListener) {
        this.mclickListener = clickListener
    }

    fun getClickListener() : ItemClickListener? {
        return this.mclickListener
    }

    fun addAllItems(items : ArrayList<DataModel.ListItem>) {
        mItems = items
        notifyDataSetChanged()
    }

    fun clear() {
        mItems.clear()
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
        Glide.with(mContext)
                .load(item.imgUrlString)
                .into(holder!!.image_view)
        holder!!.text_view.text = "#$position"

        holder.itemView.setOnClickListener      {
            if (null != mclickListener) {
                mclickListener!!.onItemClickListener(item)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHoler {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.card_item, parent, false)

        return CustomViewHoler(view)
    }

    class CustomViewHoler(view : View) : RecyclerView.ViewHolder(view) {
        val image_view = view.card_img_view
        val text_view = view.card_title
    }

    fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
        itemView.setOnClickListener {
            event.invoke(getAdapterPosition(), getItemViewType())
        }
        return this
    }

    interface ItemClickListener {
        fun onItemClickListener(item : DataModel.ListItem)
    }
}