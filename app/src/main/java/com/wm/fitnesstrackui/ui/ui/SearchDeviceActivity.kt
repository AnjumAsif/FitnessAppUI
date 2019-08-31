package com.wm.fitnesstrackui.ui.ui

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.wm.fitnesstrackui.R
import com.wm.fitnesstrackui.ui.utility.Utils
import kotlinx.android.synthetic.main.activity_search_device.*


class SearchDeviceActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.buttonSelectDevice -> {
                if (contentRipple.isRippleAnimationRunning)
                    contentRipple.stopRippleAnimation()
                startActivity(Intent(this, SelectActivity::class.java))
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_device)
//        centerImage.setOnClickListener { contentRipple.startRippleAnimation() }
        val ab = supportActionBar
        Utils.setDefaultTitleCenter(ab, "Select Device", this, true)
        buttonSelectDevice.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        if (foundDevice.isVisible)
            foundDevice.visibility = View.INVISIBLE
        contentRipple.startRippleAnimation()
        Handler().postDelayed({ foundDevice() }, 3000)
    }

    private fun foundDevice() {
        val animatorSet = AnimatorSet()
        animatorSet.duration = 400
        animatorSet.interpolator = AccelerateDecelerateInterpolator()
        val animatorList = ArrayList<Animator>()
        val scaleXAnimator = ObjectAnimator.ofFloat(foundDevice, "ScaleX", 0f, 1.2f, 1f)
        animatorList.add(scaleXAnimator)
        val scaleYAnimator = ObjectAnimator.ofFloat(foundDevice, "ScaleY", 0f, 1.2f, 1f)
        animatorList.add(scaleYAnimator)
        animatorSet.playTogether(animatorList)
        foundDevice.visibility = View.VISIBLE
        animatorSet.start()
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
