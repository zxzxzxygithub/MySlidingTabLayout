package com.example.yongxiangzheng.myslidingtablayoutdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*;
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private val mTitles = arrayOf("热门", "iOS", "Android", "前端")
    private val mFragments = ArrayList<Fragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for (title in mTitles){
            mFragments.add(SimpleCardFragment.getInstance(title))
        }
        vp_list.adapter = MyPagerAdapter(supportFragmentManager)
        st.setViewPager(vp_list)
    }

    inner class MyPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
        override fun getItem(position:  Int): Fragment {
            return mFragments[position]
        }

        override fun getPageTitle(position: Int): String? {
            return mTitles[position]
        }

        override fun getCount(): Int {
            return mFragments.size
        }

    }
}
