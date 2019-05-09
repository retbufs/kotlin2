package com.example.kotlinmvp.base

interface IBasePresenter<T> : Lifecycle {
    /**
     * 绑定视图
     */
    fun onBind(): Unit

    /**
     * 解绑视图
     */
    fun onUnBind(): Unit
    /**
     * 获取model
     */
    fun getModel(): IModel


}
