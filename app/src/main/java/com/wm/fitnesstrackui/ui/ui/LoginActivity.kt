package com.wm.fitnesstrackui.ui.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.wm.fitnesstrackui.R
import com.wm.fitnesstrackui.ui.utility.Constant
import com.wm.fitnesstrackui.ui.utility.SharedPreference
import com.wm.fitnesstrackui.ui.utility.Utils
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var sharedPreference: SharedPreference

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.buttonFacebook -> {
                Utils.showLongToast(this, "working")
            }

            R.id.textViewCreateAccount -> {
                startActivity(Intent(this, SignUpActivity::class.java))
            }
            R.id.textViewNeedHelp -> {
                Utils.showLongToast(this, "working")
            }
            R.id.buttonSignIn -> {if (sharedPreference.getValueString(Constant.LOGIN_SUCCESS).equals(""))
                sharedPreference.save(Constant.LOGIN_SUCCESS, "1")
                startActivity(Intent(this, SearchDeviceActivity::class.java))
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        sharedPreference = SharedPreference(this)
        buttonFacebook.setOnClickListener(this)
        buttonSignIn.setOnClickListener(this)
        textViewCreateAccount.setOnClickListener(this)
        textViewNeedHelp.setOnClickListener(this)
    }
}
