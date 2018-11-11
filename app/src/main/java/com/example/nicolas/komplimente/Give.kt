package com.example.nicolas.komplimente


import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView


/**
 * A simple [Fragment] subclass.
 */
class Give : Fragment() {

    private lateinit var arrayAdapter: ArrayAdapter<*>
    private val names = Friends.friendsList


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_give1, container, false)
        val listView = view.findViewById<ListView>(R.id.allfriends)
        val editText = view.findViewById<EditText>(R.id.search)

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val bundle = Bundle()
            bundle.putString("subject", parent.getItemAtPosition(position).toString().split('(', ')').get(1))
            val give2 = Give2()
            give2.arguments = bundle
            val fragmentManager = activity!!.supportFragmentManager
            fragmentManager.beginTransaction().replace(R.id.main_frame, give2).addToBackStack("give").commit()
        }

        arrayAdapter = ArrayAdapter(activity!!, R.layout.simple_list_layout, names.map { "${it.first} ${it.last} (${it.id})" })
        listView.adapter = arrayAdapter

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) { }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                arrayAdapter.filter.filter(s)
            }

            override fun afterTextChanged(s: Editable) { }
        })


        return view
    }

}// Required empty public constructor
