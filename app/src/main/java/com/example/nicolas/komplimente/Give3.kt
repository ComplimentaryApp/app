package com.example.nicolas.komplimente


import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.SeekBar
import android.widget.Switch


/**
 * A simple [Fragment] subclass.
 */
class Give3 : Fragment() {

    internal lateinit var give3_send: Button
    internal lateinit var positivity: SeekBar
    internal lateinit var anonymous: Switch
    internal lateinit var cb1: CheckBox
    internal lateinit var cb2: CheckBox
    internal lateinit var cb3: CheckBox
    internal lateinit var cb4: CheckBox


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_give3, container, false)

        val subject = arguments!!.getString("subject")
        give3_send = view.findViewById<View>(R.id.give3_send) as Button
        positivity = view.findViewById(R.id.how_good)
        anonymous = view.findViewById(R.id.anonym)
        cb1 = view.findViewById(R.id.checkBox_sad)
        cb2 = view.findViewById(R.id.checkBox_incompetent)
        cb3 = view.findViewById(R.id.checkBox_stress)
        cb4 = view.findViewById(R.id.checkBox_lonely)

        give3_send.setOnClickListener {
            val body = arguments!!.getString("body")
            //make more restictions
            if (body!!.length > 5) {
                send(subject, body, anonymous.isActivated, positivity.progress)
                val give4 = Give4()
                val fragmentManager = activity!!.supportFragmentManager
                fragmentManager.popBackStack("main", FragmentManager.POP_BACK_STACK_INCLUSIVE)
                fragmentManager.beginTransaction().replace(R.id.main_frame, give4).commit()
            } else {
                val snackbar = Snackbar
                    .make(
                        activity!!.findViewById(android.R.id.content),
                        "Compliment is too short",
                        Snackbar.LENGTH_LONG
                    )

                snackbar.show()
            }
        }
        return view
    }

    private fun send(subject: String?, body: String?, anonymous: Boolean, positivity: Int) {
        val snackbar = Snackbar
            .make(
                activity!!.findViewById(android.R.id.content),
                "Your compliment is on the way, and will reach "+subject+" soon.",
                Snackbar.LENGTH_LONG
            )

        snackbar.show()
    }

}// Required empty public constructor
