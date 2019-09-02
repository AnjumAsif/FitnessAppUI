package com.wm.fitnesstrackui.ui.ui

import android.content.Context
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.wm.fitnesstrackui.R
import kotlinx.android.synthetic.main.fragment_daily.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [DailyFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [DailyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DailyFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_daily, container, false)
        val progress: Float = 65f
        view.circularProgressBar.progress = progress;        // set progress value
        view.circularProgressBar.maxValue = 100f;            // set progress max value
        view.circularProgressBar.strokeWidth = 10f;        // set stroke width
        view.circularProgressBar.backgroundWidth = 28f;        // set progress background width
        view.circularProgressBar.setProgressColor(
            ContextCompat.getColor(
                context as FragmentActivity,
                R.color.colorPrimary
            )
        );    // set progress color
        view.circularProgressBar.setBackgroundColor("#FFF9916B");    // set progress backgorund color
        view.circularProgressBar.text = returnTextStyleForSteps();    // set progress text
        return view
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onDetach() {
        super.onDetach()
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DailyFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DailyFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    /*set color for terms and condition */
    private fun returnTextStyleForSteps(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append(getString(R.string.steps))
        stringBuilder.append(" : ")
        stringBuilder.append(getString(R.string.steps_count))
        stringBuilder.append("/")
        stringBuilder.append(getString(R.string.steps_miles))

        val spannableString = SpannableStringBuilder(stringBuilder.toString())
        spannableString.setSpan(
            StyleSpan(Typeface.BOLD),
            stringBuilder.indexOf(getString(R.string.steps)),
            stringBuilder.indexOf(getString(R.string.steps)).plus(getString(R.string.steps).length),
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableString.setSpan(
            StyleSpan(Typeface.ITALIC),
            stringBuilder.indexOf(getString(R.string.steps_miles)),
            stringBuilder.indexOf(getString(R.string.steps_miles)).plus(getString(R.string.steps_miles).length),
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )



        /*val stringBuilder = StringBuilder()
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
            ForegroundColorSpan(ContextCompat.getColor(activity as FragmentActivity, R.color.colorPrimary)),
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
            ForegroundColorSpan(ContextCompat.getColor(activity as FragmentActivity, R.color.colorPrimary)),
            stringBuilder.indexOf(getString(R.string.privacy_policy)),
            stringBuilder.indexOf(getString(R.string.privacy_policy)).plus(getString(R.string.privacy_policy).length),
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )*/
        return spannableString.toString()

    }
}
