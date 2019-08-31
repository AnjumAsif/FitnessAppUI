package com.wm.fitnesstrackui.ui.utility

import android.app.Activity
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.core.content.ContextCompat
import com.wm.fitnesstrackui.R

class Utils {
    companion object {
        fun showLongToast(
            mActivity: Activity,
            msg: String
        ) {
            Toast.makeText(mActivity, msg, Toast.LENGTH_LONG).show()
        }
        fun showShortToast(
            mActivity: Activity,
            msg: String
        ) {
            Toast.makeText(mActivity, msg, Toast.LENGTH_SHORT).show()
        }
        //set custom title on support toolbar
        fun setDefaultTitleCenter(
            actionBar: ActionBar?,
            pageTitle: String,
            mActivity: Activity,
            b: Boolean
        ) {
            val d = ContextCompat.getDrawable(mActivity, R.drawable.ic_gradient_top_header)
            val viewActionBar = mActivity.layoutInflater.inflate(R.layout.actionbar_title_text_layout, null)
            val params = ActionBar.LayoutParams(//Center the text view in the ActionBar !
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.CENTER)
            actionBar?.setBackgroundDrawable(d)
            val textViewTitle = viewActionBar.findViewById(R.id.actionbar_textView) as TextView
            textViewTitle.text = pageTitle
            actionBar?.setCustomView(viewActionBar, params)
            actionBar?.setDisplayShowCustomEnabled(true)
            actionBar?.setDisplayShowTitleEnabled(false)
            actionBar?.setDisplayHomeAsUpEnabled(b)
            actionBar?.setIcon(android.R.color.transparent)
            actionBar?.setHomeButtonEnabled(false)
        }
    }
}