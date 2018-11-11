package com.example.nicolas.komplimente;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class Compliment extends Fragment {

    int mood;
    int adjective;

    ImageView back;

    public Compliment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_compliment, container, false);
        mood = getArguments().getInt("mood");
        adjective = getArguments().getInt("adjective");
        back = (ImageView) view.findViewById(R.id.back);
        int[] images = {
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
        };
        Random rand = new Random();
        back.setImageResource(images[rand.nextInt(images.length)]);


        return view;
    }

    

}
