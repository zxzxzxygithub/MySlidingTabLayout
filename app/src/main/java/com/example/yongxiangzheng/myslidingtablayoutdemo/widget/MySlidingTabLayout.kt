package com.example.yongxiangzheng.myslidingtablayoutdemo.widget

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.yongxiangzheng.myslidingtablayoutdemo.R

import com.flyco.tablayout.SlidingTabLayout

import java.util.ArrayList

/**
 * @author zhengyx
 * @des 设置slidinglayout非官方库的一些属性，比如selectTextSize和unSelectTextSize
 * @date 2019/1/23
 */
class MySlidingTabLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : SlidingTabLayout(context, attrs, defStyleAttr) {

    private var mTabsContainer: LinearLayout? = null
    private var mSelectedTextSize: Float = 0.toFloat()
    private var mUnSelectedTextSize: Float = 0.toFloat()
    private var mTextsize: Float = 0.toFloat()

    init {
        if (attrs != null) {
            obtainOtherAttributes(context, attrs)
        }
        getTabContainer(this)
    }

    private fun obtainOtherAttributes(context: Context, attrs: AttributeSet) {
        val ta = context.obtainStyledAttributes(attrs,
            R.styleable.MySlidingTabLayout
        )
        mTextsize = ta.getDimension(com.flyco.tablayout.R.styleable.SlidingTabLayout_tl_textsize, sp2px(14f).toFloat())
        mSelectedTextSize = ta.getFloat(R.styleable.MySlidingTabLayout_selectedTextSize, 16f)
        mUnSelectedTextSize = ta.getFloat(R.styleable.MySlidingTabLayout_unSelectedTextSize, 14f)
        ta.recycle()
    }

    override fun onPageSelected(position: Int) {
        super.onPageSelected(position)
        updateTabSelection(mTabsContainer, position, mSelectedTextSize, mUnSelectedTextSize)
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        var state = state
        if (state is Bundle) {
            val bundle = state as Bundle?
            val mCurrentTab = bundle!!.getInt("mCurrentTab")
            state = bundle.getParcelable("instanceState")
            if (mCurrentTab != 0 && mTabsContainer!!.childCount > 0) {
                updateTabSelection(mTabsContainer, mCurrentTab, mSelectedTextSize, mUnSelectedTextSize)
            }
        }
        super.onRestoreInstanceState(state)
    }

    override fun setViewPager(vp: ViewPager) {
        super.setViewPager(vp)
        updateTabSelection(mTabsContainer, 0, mSelectedTextSize, mUnSelectedTextSize)
    }

    override fun setViewPager(vp: ViewPager, titles: Array<String>) {
        super.setViewPager(vp, titles)
        updateTabSelection(mTabsContainer, 0, mSelectedTextSize, mUnSelectedTextSize)
    }

    override fun setViewPager(
        vp: ViewPager,
        titles: Array<String>,
        fa: FragmentActivity,
        fragments: ArrayList<Fragment>
    ) {
        super.setViewPager(vp, titles, fa, fragments)
        updateTabSelection(mTabsContainer, 0, mSelectedTextSize, mUnSelectedTextSize)
    }

    /**
     * 获取tabcontainer
     *
     * @param st
     * @return
     */
    private fun getTabContainer(st: SlidingTabLayout?): LinearLayout? {
        if (st == null) {
            return null
        }
        try {
            val fieldName = "mTabsContainer"
            val mField = SlidingTabLayout::class.java.getDeclaredField(fieldName)
            mField.isAccessible = true
            mTabsContainer = mField.get(st) as LinearLayout
            return mTabsContainer
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }

        return null
    }

    /**
     * 设置选中和非选中文字大小
     *
     * @param tabsContainer
     * @param position
     * @param selectTextSize
     * @param unSelectTextSize
     */
    private fun updateTabSelection(
        tabsContainer: LinearLayout?,
        position: Int,
        selectTextSize: Float,
        unSelectTextSize: Float
    ) {
        if (tabsContainer == null) {
            return
        }
        for (i in 0 until tabsContainer.childCount) {
            val tabView = tabsContainer.getChildAt(i) ?: continue
            val isSelect = i == position
            val tab_title = tabView.findViewById<TextView>(R.id.tv_tab_title)
            val layoutParams = tab_title.layoutParams as RelativeLayout.LayoutParams
            layoutParams.height = dp2px(44f)
            tab_title.layoutParams = layoutParams
            tab_title.gravity = Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
            if (isSelect) {
                val bottom = dp2px(6.5f)
                tab_title.setPadding(tab_title.paddingLeft, tab_title.paddingTop, tab_title.paddingRight, bottom)
            } else {
                val bottom = dp2px(8f)
                tab_title.setPadding(tab_title.paddingLeft, tab_title.paddingTop, tab_title.paddingRight, bottom)
            }

            tab_title.textSize = if (isSelect) selectTextSize else unSelectTextSize
        }
    }

}
