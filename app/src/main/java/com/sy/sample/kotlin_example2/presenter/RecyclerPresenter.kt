package com.sy.sample.kotlin_example2.presenter

import android.content.Context
import com.sy.sample.kotlin_example2.model.DataModel

/**
 * Created by SuYa on 2017. 9. 12..
 */
class RecyclerPresenter(private val view : RecyclerContract.View) : RecyclerContract.Presenter {

    init {
        this.view.setPresenter(this)
    }

    override fun attachView(view: RecyclerContract.View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun detachView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadItems() {
        view.updateView(DataModel.getDefalutItems())
    }

    override fun start() {
        loadItems()
    }
}