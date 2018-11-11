package com.example.nicolas.komplimente


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.ViewGroup


class Profile : Fragment() {

    private lateinit var mTextMessage: TextView
    private val favorite_comps = FavoriteComps()
    private val friends = Friends()
    private val written_comps = WrittenComps()

    private lateinit var favesButton: Button
    private lateinit var writtenButton: Button
    private lateinit var friendsButton: Button

    private lateinit var frameLayout: FrameLayout



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_profile, container, false)

        favesButton = view.findViewById(R.id.favorite_nav_butt)
        writtenButton = view.findViewById(R.id.written_nav_butt)
        friendsButton = view.findViewById(R.id.friends_nav_butt)
        frameLayout = view.findViewById(R.id.profile_frame_block)


        favesButton.setOnClickListener { fragChange(favorite_comps) }
        writtenButton.setOnClickListener { fragChange(written_comps) }
        friendsButton.setOnClickListener { fragChange(friends) }

        val comps = arrayOf("You are fucking awesome, seriously", "Your smile warms the world", "My life is better because you are in it")

        //mTextMessage = view.findViewById<View>(R.id.message) as TextView
        favesButton.callOnClick()

        return view
    }

    private fun fragChange(fragment: Fragment) {
        //val fragmentTransaction = activity.supportFragmentManager.beginTransaction()
        val fragmentTransaction = (activity as AppCompatActivity).supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(frameLayout.id, fragment)
        fragmentTransaction.commit()
    }
}