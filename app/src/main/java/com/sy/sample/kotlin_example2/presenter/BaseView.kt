package com.sy.sample.kotlin_example2.presenter

/**
 * Created by SuYa on 2017. 9. 12..
 */
interface BaseView <T>{
    fun showToast(value : String)
    fun setPresenter(presenter : T)
}