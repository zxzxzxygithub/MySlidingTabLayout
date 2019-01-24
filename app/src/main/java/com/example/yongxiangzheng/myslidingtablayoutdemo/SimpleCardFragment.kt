package com.example.yongxiangzheng.myslidingtablayoutdemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

@SuppressLint("ValidFragment")
class SimpleCardFragment : Fragment() {
    private var mTitle: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fr_simple_card, null)
        val cardTitleTv = v.findViewById<View>(R.id.card_title_tv) as TextView
        cardTitleTv.text = mTitle

        return v
    }

    companion object {

        fun getInstance(title: String): SimpleCardFragment {
            val sf = SimpleCardFragment()
            sf.mTitle = title
            return sf
        }
    }
}