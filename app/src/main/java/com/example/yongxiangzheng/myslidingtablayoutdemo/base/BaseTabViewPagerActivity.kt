package com.example.yongxiangzheng.myslidingtablayoutdemo.base

import android.support.v7.app.AppCompatActivity


/**
 *
 *@des
 *@author zhengyx
 *@date 2019/1/23
 **/
abstract  class BaseTabViewPagerActivity : AppCompatActivity(),
    IFragmentViewPager {

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        TabViewPagerModel.installTabAndViewPager(this)
    }
}