package com.example.nicolas.komplimente

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    var bekommen = Receive()
    var geben = Give()
    var profil = Profile()

    var mood = 0

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_bekommen -> {
                changeFragment(bekommen)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_geben -> {
                changeFragment(geben)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profil -> {
                changeFragment(profil)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun changeFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(main_frame.id,fragment).addToBackStack("main")
        fragmentTransaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_nav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        changeFragment(bekommen)

    }

    fun getVisibleFragment(): Fragment? {
        val fragmentManager = this@MainActivity.supportFragmentManager
        val fragments = fragmentManager.fragments
        if (fragments != null) {
            for (fragment in fragments) {
                if (fragment != null && fragment.isVisible)
                    return fragment
            }
        }
        return null
    }

    override fun onBackPressed() {
        if (fragmentManager.backStackEntryCount > 0) {
            fragmentManager.popBackStack()
            main_nav.selectedItemId = R.id.navigation_bekommen
        } else {
            super.onBackPressed()
        }
    }
}
