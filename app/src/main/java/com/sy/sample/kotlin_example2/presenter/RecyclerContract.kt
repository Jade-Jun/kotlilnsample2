package com.sy.sample.kotlin_example2.presenter

import android.content.Context
import com.sy.sample.kotlin_example2.model.DataModel

/**
 * Created by SuYa on 2017. 9. 12..
 */
interface RecyclerContract {

    interface View : BaseView<Presenter> {
        fun updateView(data : ArrayList<DataModel.ListItem>)
        fun refresh()
    }

    interface Presenter : BasePresenter{
        fun loadItems()
    }

}