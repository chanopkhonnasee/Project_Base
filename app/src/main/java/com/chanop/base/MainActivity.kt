package com.chanop.base

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.transaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.chanop.base.ui.base.BaseFragment
import com.chanop.base.ui.testML.MachineLearningFragment
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.collections.ArrayList

@SuppressLint("CheckResult")
class MainActivity : AppCompatActivity() {

    companion object {
        const val INVALID_TOKEN = "INVALID_TOKEN"
    }

    var loadingQueue = ArrayList<Int>()

    private val homeFragment = BaseFragment.newInstance()
    private val machineLearningFragment = MachineLearningFragment.newInstance()

    private var active: Fragment = homeFragment

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                setActiveFragment(machineLearningFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                setActiveFragment(homeFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.initFont()
        this.initApp()
        initFragment()
    }

    private fun initFont() {
        ViewPump.init(
            ViewPump.builder()
                .addInterceptor(
                    CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                            .setDefaultFontPath("fonts/kanit_light.ttf")
                            .setFontAttrId(R.attr.fontPath)
                            .build()
                    )
                )
                .build()
        )
    }

    private fun initFragment() {
        supportFragmentManager.transaction {
            replace(R.id.main_container, homeFragment, "HOME")
        }
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun setActiveFragment(currentFragment: Fragment) {
        supportFragmentManager.transaction {
            //            hide(active)
            replace(R.id.main_container, currentFragment)
        }
        active = currentFragment
    }

    private fun initApp() {
    }

    fun hideSoftKeyboard() {
        val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        val view = currentFocus
        imm.hideSoftInputFromWindow(view?.windowToken, 0)
    }

}
