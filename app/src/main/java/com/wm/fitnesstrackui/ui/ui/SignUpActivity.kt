package com.wm.fitnesstrackui.ui.ui

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.wm.fitnesstrackui.R
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setTextStyleForTermsCondition()


    }

    /*set color for terms and condition */
    private fun setTextStyleForTermsCondition() {
        val stringBuilder = StringBuilder()
        stringBuilder.append(getString(R.string.terms_condition))
        stringBuilder.append(" ")
        stringBuilder.append(getString(R.string.and))
        stringBuilder.append(" ")
        stringBuilder.append(getString(R.string.privacy_policy))

        val spannableString = SpannableStringBuilder(stringBuilder.toString())
        spannableString.setSpan(
            StyleSpan(Typeface.ITALIC),
            stringBuilder.indexOf(getString(R.string.terms_condition)),
            stringBuilder.indexOf(getString(R.string.terms_condition)).plus(getString(R.string.terms_condition).length),
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableString.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.colorPrimary)),
            stringBuilder.indexOf(getString(R.string.terms_condition)),
            stringBuilder.indexOf(getString(R.string.terms_condition)).plus(getString(R.string.terms_condition).length),
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        spannableString.setSpan(
            StyleSpan(Typeface.ITALIC),
            stringBuilder.indexOf(getString(R.string.privacy_policy)),
            stringBuilder.indexOf(getString(R.string.privacy_policy)).plus(getString(R.string.privacy_policy).length),
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableString.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.colorPrimary)),
            stringBuilder.indexOf(getString(R.string.privacy_policy)),
            stringBuilder.indexOf(getString(R.string.privacy_policy)).plus(getString(R.string.privacy_policy).length),
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        textViewTerms.setText(spannableString, TextView.BufferType.SPANNABLE)

    }
}
