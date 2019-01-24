package com.example.yongxiangzheng.myslidingtablayoutdemo.base

/**
 *
 *@des
 *@author zhengyx
 *@date 2019/1/24
 **/
object  TabViewPagerModel{

    fun installTabAndViewPager(iFragmentViewPager: IFragmentViewPager){
        iFragmentViewPager.getFragments(iFragmentViewPager.getTitles())
        iFragmentViewPager.setAdapter(iFragmentViewPager.getAdapter())
        iFragmentViewPager.setViewPager()
    }

}