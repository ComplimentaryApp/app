// Author: Paula Ruiz
// Microsoft Student Creative Hack with Netlight

package com.complementary.paularuiz.complementary

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import android.support.v4.app.Fragment


class Profile : AppCompatActivity() {

    private lateinit var mTextMessage: TextView
    private val favorite_comps = FavoriteComps()
    private val friends = Friends()
    private val written_comps = WrittenComps()

    private lateinit var favesButton: Button
    private lateinit var writtenButton: Button
    private lateinit var friendsButton: Button

    private lateinit var frameLayout: FrameLayout

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                mTextMessage.setText(R.string.title_home)
                true
            }
            R.id.navigation_dashboard -> {
                mTextMessage.setText(R.string.title_dashboard)
                true
            }
            R.id.navigation_notifications -> {
                mTextMessage.setText(R.string.title_notifications)
                true
            }
            else -> false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        favesButton = findViewById(R.id.favorite_nav_butt)
        writtenButton = findViewById(R.id.written_nav_butt)
        friendsButton = findViewById(R.id.friends_nav_butt)
        frameLayout = findViewById(R.id.profile_frame_block)

        favesButton.setOnClickListener { fragChange(favorite_comps) }
        writtenButton.setOnClickListener { fragChange(written_comps) }
        friendsButton.setOnClickListener { fragChange(friends) }

        val comps = arrayOf("You are fucking awesome, seriously", "Your smile warms the world", "My life is better because you are in it")

        mTextMessage = findViewById<View>(R.id.message) as TextView
        val navigation = findViewById<View>(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun fragChange(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(frameLayout.id, fragment)
        fragmentTransaction.commit()
    }
}
