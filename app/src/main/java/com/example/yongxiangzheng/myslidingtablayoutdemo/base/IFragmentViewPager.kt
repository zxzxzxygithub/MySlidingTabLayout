package com.example.yongxiangzheng.myslidingtablayoutdemo.base

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter

/**
 *
 *@des viewpager相关接口
 *@author zhengyx
 *@date 2019/1/23
 **/
interface IFragmentViewPager{
    fun getTitles() : Array<String>
    fun getFragments(titles: Array<String>) : ArrayList<Fragment>
    fun getAdapter(): FragmentPagerAdapter
    fun setAdapter(adapter: FragmentPagerAdapter)
    fun setViewPager()
}