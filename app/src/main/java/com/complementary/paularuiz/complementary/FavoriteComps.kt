// Author: Paula Ruiz
// Microsoft Student Creative Hack with Netlight
// 10/11/2018 - 11/11/2018

package com.complementary.paularuiz.complementary


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView


/**
 * A simple [Fragment] subclass.
 */
class FavoriteComps : Fragment() {

    // name your ListView object
    private lateinit var listView: ListView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_favorite__comps, container, false)
        // link ListView object to our xml
        listView = view.findViewById<View>(R.id.myListViewFavorites) as ListView

        // define array values to show into our listView
        val my_comp_list = arrayOf("You are fucking awesome, seriously", "The effort you put in to our relationship means" + " a lot to me", "Smoked salmon is tasty")

        //Define an Adapter
        // Define parameters for our adapter
        // 1. context
        // 2. layout for rows
        // 3. ID for our TextView to which data is written
        // 4. the array of data
        val adapter = ArrayAdapter(activity!!,
                android.R.layout.simple_list_item_1, android.R.id.text1, my_comp_list)

        // Assign adapter to the listView object
        listView.adapter = adapter


        // Inflate the layout for this fragment
        return view
    }

}
