package com.chanop.base.ui.testML

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

interface MachineLearningContract {
    interface View: MvpView
    interface Presenter: MvpPresenter<View>
}