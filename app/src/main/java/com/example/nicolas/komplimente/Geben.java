package com.example.nicolas.komplimente;


import android.graphics.ColorSpace;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Geben extends Fragment {

    private ArrayAdapter arrayAdapter;
    ArrayList<String> names;


    public Geben() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_geben, container, false);
        final ListView listView = (ListView) view.findViewById(R.id.allfriends);
        EditText editText = (EditText) view.findViewById(R.id.search);

        names = new ArrayList<>();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putString("wer", parent.getItemAtPosition(position).toString());
                Geben2 geben2 = new Geben2();
                geben2.setArguments(bundle);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.main_frame,geben2).addToBackStack("geben1").commit();
            }
        });


        names.add("Paula");
        names.add("Matze");
        names.add("Charly");
        names.add("Nicolas");
        names.add("Nils");
        names.add("Thomas");
        names.add("Dominic");
        names.add("Jan");
        names.add("Phillip");
        arrayAdapter = new ArrayAdapter(getActivity(),R.layout.simple_list_layout,names);
        listView.setAdapter(arrayAdapter);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                (Geben.this).arrayAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        return view;
    }

}
