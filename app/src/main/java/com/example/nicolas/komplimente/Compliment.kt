package com.example.nicolas.komplimente


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import java.util.Random


/**
 * A simple [Fragment] subclass.
 */
class Compliment : Fragment() {

    internal var mood: Int = 0
    internal var adjective: Int = 0

    internal lateinit var back: ImageView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_compliment, container, false)
        mood = arguments!!.getInt("mood")
        adjective = arguments!!.getInt("adjective")
        back = view.findViewById<View>(R.id.back) as ImageView
        val images = listOf(
            R.drawable.backgrounds001,
            R.drawable.backgrounds002,
            R.drawable.backgrounds003,
            R.drawable.backgrounds004,
            R.drawable.backgrounds005,
            R.drawable.backgrounds006,
            R.drawable.backgrounds007,
            R.drawable.backgrounds008,
            R.drawable.backgrounds009,
            R.drawable.backgrounds010
        )
        val rand = Random()
        back.setImageResource(images[rand.nextInt(images.size)])

        return view
    }

}
