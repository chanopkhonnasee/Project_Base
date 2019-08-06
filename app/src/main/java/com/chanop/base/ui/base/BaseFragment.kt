package com.chanop.base.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.mosby3.mvp.MvpFragment
import com.chanop.base.R

class BaseFragment : MvpFragment<BaseContract.View, BaseContract.Presenter>(), BaseContract.View {
    
    companion object {
        fun newInstance() = BaseFragment()
    }
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    
    override fun onResume() {
        super.onResume()
    }
    
    override fun onStart() {
        super.onStart()
    }
    
    override fun onStop() {
        super.onStop()
    }
    
    override fun onPause() {
        super.onPause()
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
    }
    
    
    override fun createPresenter(): BaseContract.Presenter = BasePresenter()
    
}