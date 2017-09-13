package com.sy.sample.kotlin_example2.presenter

/**
 * Created by SuYa on 2017. 9. 12..
 */
interface BasePresenter {
    fun attachView(view : RecyclerContract.View)
    fun detachView()
    fun start()
}