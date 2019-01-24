package com.example.yongxiangzheng.myslidingtablayoutdemo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import com.example.yongxiangzheng.myslidingtablayoutdemo.base.BaseTabViewPagerActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseTabViewPagerActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_main)

    }

    override fun getTitles(): Array<String> {

        return  arrayOf("热门", "iOS", "Android", "前端")

    }

    override fun getFragments(titles: Array<String>): ArrayList<Fragment> {
        val fragments = ArrayList<Fragment>()
        for (title in titles){
            fragments.add(SimpleCardFragment.getInstance(title))
        }
        return fragments
    }

    override fun getAdapter(): FragmentPagerAdapter {
        val titles = getTitles()
        val fragments = getFragments(titles)
        return object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position:  Int): Fragment {

                return fragments[position]
            }

            override fun getPageTitle(position: Int): String? {
                return titles[position]
            }

            override fun getCount(): Int {
                return fragments.size
            }
        }
    }

    override fun setAdapter(adapter: FragmentPagerAdapter) {
        vp_list.adapter = adapter
    }

    override fun setViewPager() {
        st.setViewPager(vp_list)
    }


}
