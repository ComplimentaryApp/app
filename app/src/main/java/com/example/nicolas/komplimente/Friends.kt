package com.example.nicolas.komplimente


import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ListView


/**
 * A simple [Fragment] subclass.
 */
class Friends : Fragment() {

    companion object {
        var friendsList = ArrayList<Friend>()
    }

    internal lateinit var listView: ListView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_friends, container, false)
        // link ListView object to our xml
        listView = view.findViewById<View>(R.id.myListViewFriends) as ListView

        // define array values to show into our listView
        var my_friend_list = arrayListOf("Matze Hamacher", "Nic Neudeck", "Charlie Harding")
        friendsList.forEach { my_friend_list.add("${it.first} ${it.last} (${it.id})") }

        //Define an Adapter
        // Define parameters for our adapter
        // 1. context
        // 2. layout for rows
        // 3. ID for our TextView to which data is written
        // 4. the array of data
        val adapter = ArrayAdapter(activity!!,
            android.R.layout.simple_list_item_1, android.R.id.text1, my_friend_list)

        // Assign adapter to the listView object
        listView.adapter = adapter

        // Inflate the layout for this fragment
        return view
    }

}// Required empty public constructor
