package com.wm.fitnesstrackui.ui.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.wm.fitnesstrackui.R
import com.wm.fitnesstrackui.ui.utility.Constant
import com.wm.fitnesstrackui.ui.utility.SharedPreference

class SplashActivity : AppCompatActivity() {
    lateinit var sharedPreference: SharedPreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        sharedPreference = SharedPreference(this)
        Handler().postDelayed(Runnable {
            if (sharedPreference.getValueString(Constant.LOGIN_SUCCESS).equals("1")) {
                startActivity(Intent(this, SearchDeviceActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this, GetStartedActivity::class.java))
                finish()
            }
        }, 3000)
    }
}
