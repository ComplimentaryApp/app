package com.example.nicolas.komplimente


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
class WrittenComps : Fragment() {

    internal lateinit var listView: ListView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_written_comps, container, false)
        // link ListView object to our xml
        listView = view.findViewById(R.id.myListViewWritten)

        // define array values to show into our listView
        val myWrittenCompsList = arrayOf("You are my sunshine when skies are grey", "C'est la vie", "Zahlen zählen nicht")

        //Define an Adapter
        // Define parameters for our adapter
        // 1. context
        // 2. layout for rows
        // 3. ID for our TextView to which data is written
        // 4. the array of data
        val adapter = ArrayAdapter(activity!!,
            android.R.layout.simple_list_item_1, android.R.id.text1, myWrittenCompsList)

        // Assign adapter to the listView object
        listView.adapter = adapter


        // Inflate the layout for this fragment
        return view
    }

}
