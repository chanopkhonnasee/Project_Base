package com.chanop.base.ui.base

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

interface BaseContract {
    interface View: MvpView
    interface Presenter: MvpPresenter<View>
}