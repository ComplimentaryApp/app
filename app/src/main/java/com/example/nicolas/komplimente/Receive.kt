package com.example.nicolas.komplimente


import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.akaita.android.circularseekbar.CircularSeekBar


/**
 * A simple [Fragment] subclass.
 */
class Receive : Fragment() {

    internal lateinit var circularSeekBar: CircularSeekBar
    internal var startColor = Color.valueOf(Color.BLUE)
    internal var endColor = Color.valueOf(Color.RED)

    internal lateinit var b1: Button
    internal lateinit var b2: Button
    internal lateinit var b3: Button
    internal lateinit var b4: Button
    internal lateinit var b5: Button
    internal lateinit var b6: Button
    internal lateinit var b7: Button
    internal lateinit var b8: Button
    internal lateinit var b9: Button
    internal lateinit var next: Button

    internal var now_orange: Button? = null

    internal lateinit var smiley: ImageView

    internal var mood = 0
    internal var adjective = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_receive, container, false)
        circularSeekBar = view.findViewById(R.id.bekommen_circular)
        b1 = view.findViewById(R.id.excited)
        b2 = view.findViewById(R.id.stressed)
        b3 = view.findViewById(R.id.lonely)
        b4 = view.findViewById(R.id.nostalgic)
        b5 = view.findViewById(R.id.anxious)
        b6 = view.findViewById(R.id.happy)
        b7 = view.findViewById(R.id.incompetend)
        b8 = view.findViewById(R.id.sad)
        b9 = view.findViewById(R.id.idk)
        next = view.findViewById(R.id.next)
        smiley = view.findViewById(R.id.smiley)

        circularSeekBar.setOnCircularSeekBarChangeListener(object : CircularSeekBar.OnCircularSeekBarChangeListener {
            @SuppressLint("NewApi")
            override fun onProgressChanged(seekBar: CircularSeekBar, progress: Float, fromUser: Boolean) {
                mood = progress.toInt()
                val color = machFarbe(progress)
                circularSeekBar.ringColor = color
                circularSeekBar.innerCircleColor = color
                if (progress > 88) {
                    smiley.setImageResource(R.drawable.smiley9)
                } else if (progress > 77) {
                    smiley.setImageResource(R.drawable.smiley8)
                } else if (progress > 66) {
                    smiley.setImageResource(R.drawable.smiley7)
                } else if (progress > 55) {
                    smiley.setImageResource(R.drawable.smiley6)
                } else if (progress > 44) {
                    smiley.setImageResource(R.drawable.smiley5)
                } else if (progress > 33) {
                    smiley.setImageResource(R.drawable.smiley4)
                } else if (progress > 22) {
                    smiley.setImageResource(R.drawable.smiley3)
                } else if (progress > 11) {
                    smiley.setImageResource(R.drawable.smiley2)
                } else {
                    smiley.setImageResource(R.drawable.smiley1)
                }
            }

            @RequiresApi(api = Build.VERSION_CODES.O)
            private fun machFarbe(progress: Float): Int {
                val red = (endColor.red() - startColor.red()) / 100 * progress + startColor.red()
                val blue = (endColor.blue() - startColor.blue()) / 100 * progress + startColor.blue()
                val green = (endColor.green() - startColor.green()) / 100 * progress + startColor.green()

                return Color.rgb(red, green, blue)
            }

            override fun onStartTrackingTouch(seekBar: CircularSeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: CircularSeekBar) {

            }
        })

        b1.setOnClickListener {
            adjective = 1
            change_Button(b1)
        }
        b2.setOnClickListener {
            adjective = 2
            change_Button(b2)
        }
        b3.setOnClickListener {
            adjective = 3
            change_Button(b3)
        }
        b4.setOnClickListener {
            adjective = 4
            change_Button(b4)
        }
        b5.setOnClickListener {
            adjective = 5
            change_Button(b5)
        }
        b6.setOnClickListener {
            adjective = 6
            change_Button(b6)
        }
        b7.setOnClickListener {
            adjective = 7
            change_Button(b7)
        }
        b8.setOnClickListener {
            adjective = 8
            change_Button(b8)
        }
        b9.setOnClickListener {
            adjective = 9
            change_Button(b9)
        }

        next.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("mood", mood)
            bundle.putInt("adjective", adjective)
            val compliment = Compliment()
            compliment.arguments = bundle
            val fragmentManager = activity!!.supportFragmentManager
            fragmentManager.beginTransaction().replace(R.id.main_frame, compliment).addToBackStack("receive").commit()
        }


        return view
    }


    fun change_Button(button: Button) {
        if (now_orange != null) {
            now_orange!!.setBackgroundColor(Color.WHITE)
            now_orange!!.backgroundTintMode = PorterDuff.Mode.ADD
        }
        button.setBackgroundColor(resources.getColor(R.color.colorPrimary))
        button.backgroundTintMode = PorterDuff.Mode.SRC_OVER
        now_orange = button
    }
}// Required empty public constructor
