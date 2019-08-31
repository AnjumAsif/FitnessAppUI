package com.wm.fitnesstrackui.ui.ui

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.wm.fitnesstrackui.R
import com.wm.fitnesstrackui.ui.utility.Utils
import kotlinx.android.synthetic.main.activity_select.*

class SelectActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.buttonRun -> {
                buttonRun.setBackgroundResource(R.drawable.button_theme_color_background)
                buttonRun.setTextColor(ContextCompat.getColor(this, R.color.colorWhite))
                buttonWalk.setBackgroundResource(R.drawable.button_theme_outline)
                buttonWalk.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
                buttonCycle.setBackgroundResource(R.drawable.button_theme_outline)
                buttonCycle.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
                startActivity(Intent(this, HomeActivity::class.java))
            }
            R.id.buttonWalk -> {
                buttonRun.setBackgroundResource(R.drawable.button_theme_outline)
                buttonRun.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
                buttonWalk.setBackgroundResource(R.drawable.button_theme_color_background)
                buttonWalk.setTextColor(ContextCompat.getColor(this, R.color.colorWhite))
                buttonCycle.setBackgroundResource(R.drawable.button_theme_outline)
                buttonCycle.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
                startActivity(Intent(this, HomeActivity::class.java))
            }
            R.id.buttonCycle -> {
                buttonRun.setBackgroundResource(R.drawable.button_theme_outline)
                buttonRun.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
                buttonWalk.setBackgroundResource(R.drawable.button_theme_outline)
                buttonWalk.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
                buttonCycle.setBackgroundResource(R.drawable.button_theme_color_background)
                buttonCycle.setTextColor(ContextCompat.getColor(this, R.color.colorWhite))
                startActivity(Intent(this, HomeActivity::class.java))

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)
        val actionBar = supportActionBar
        Utils.setDefaultTitleCenter(actionBar, "Select Activity", this@SelectActivity, true)

        buttonRun.setOnClickListener(this)
        buttonWalk.setOnClickListener(this)
        buttonCycle.setOnClickListener(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
