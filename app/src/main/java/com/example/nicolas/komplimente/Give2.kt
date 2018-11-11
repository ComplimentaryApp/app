package com.example.nicolas.komplimente


import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


/**
 * A simple [Fragment] subclass.
 */
class Give2 : Fragment() {

    internal lateinit var compliment: EditText
    internal lateinit var give2_next: Button
    internal lateinit var to: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_give2, container, false)

        val subject = arguments?.getString("subject")
        compliment = view.findViewById(R.id.give2_edit)
        give2_next = view.findViewById(R.id.give2_next)
        to = view.findViewById(R.id.compliment_to)
        to.text = "Compliment to " + subject!!
        give2_next.setOnClickListener {
            val body = compliment.text.toString()
            if (body.length > 5) {
                val bundle = Bundle()
                bundle.putString("subject", subject)
                bundle.putString("body", body)
                val give3 = Give3()
                give3.arguments = bundle
                val fragmentManager = activity!!.supportFragmentManager
                fragmentManager.beginTransaction().replace(R.id.main_frame, give3).addToBackStack("fragment_give2").commit()
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

}
