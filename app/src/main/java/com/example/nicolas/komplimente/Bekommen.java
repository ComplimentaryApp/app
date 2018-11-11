package com.example.nicolas.komplimente;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.internal.BottomNavigationMenu;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.akaita.android.circularseekbar.CircularSeekBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class Bekommen extends Fragment {

    CircularSeekBar circularSeekBar;
    @SuppressLint("NewApi")
    Color startColor = Color.valueOf(Color.BLUE);
    @SuppressLint("NewApi")
    Color endColor = Color.valueOf(Color.RED);

    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    Button next;

    Button now_orrange = null;

    ImageView smiley;

    int mood = 0;
    int adjective = 0;

    public Bekommen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_bekommen, container, false);
        circularSeekBar = view.findViewById(R.id.bekommen_circular);
        b1 = view.findViewById(R.id.excited);
        b2 = view.findViewById(R.id.stressed);
        b3 = view.findViewById(R.id.lonely);
        b4 = view.findViewById(R.id.nostalgic);
        b5 = view.findViewById(R.id.anxious);
        b6 = view.findViewById(R.id.happy);
        b7 = view.findViewById(R.id.incompetend);
        b8 = view.findViewById(R.id.sad);
        b9 = view.findViewById(R.id.idk);
        next = view.findViewById(R.id.next);
        smiley = view.findViewById(R.id.smiley);

        circularSeekBar.setOnCircularSeekBarChangeListener(new CircularSeekBar.OnCircularSeekBarChangeListener() {
            @SuppressLint("NewApi")
            @Override
            public void onProgressChanged(CircularSeekBar seekBar, float progress, boolean fromUser) {
                mood = (int) progress;
                int color = machFarbe(progress);
                circularSeekBar.setRingColor(color);
                circularSeekBar.setInnerCircleColor(color);
                if(progress > 88) {
                    smiley.setImageResource(R.drawable.smiley9);
                } else if (progress > 77) {
                    smiley.setImageResource(R.drawable.smiley8);
                } else if (progress > 66) {
                    smiley.setImageResource(R.drawable.smiley7);
                } else if (progress > 55) {
                    smiley.setImageResource(R.drawable.smiley6);
                } else if (progress > 44) {
                    smiley.setImageResource(R.drawable.smiley5);
                } else if (progress > 33) {
                    smiley.setImageResource(R.drawable.smiley4);
                } else if (progress > 22) {
                    smiley.setImageResource(R.drawable.smiley3);
                } else if (progress > 11) {
                    smiley.setImageResource(R.drawable.smiley2);
                } else {
                    smiley.setImageResource(R.drawable.smiley1);
                }
            }

            @RequiresApi(api = Build.VERSION_CODES.O)
            private int machFarbe(float progress) {
                float red = ((endColor.red() - startColor.red())/100)*progress + startColor.red();
                float blue = ((endColor.blue() - startColor.blue())/100)*progress + startColor.blue();
                float green = ((endColor.green() - startColor.green())/100)*progress + startColor.green();

                return Color.rgb(red,green,blue);
            }

            @Override
            public void onStartTrackingTouch(CircularSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(CircularSeekBar seekBar) {

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adjective = 1;
                change_Button(b1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adjective = 2;
                change_Button(b2);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adjective = 3;
                change_Button(b3);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adjective = 4;
                change_Button(b4);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adjective = 5;
                change_Button(b5);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adjective = 6;
                change_Button(b6);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adjective = 7;
                change_Button(b7);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adjective = 8;
                change_Button(b8);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adjective = 9;
                change_Button(b9);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putInt("mood",mood);
                bundle.putInt("adjective",adjective);
                Compliment compliment = new Compliment();
                compliment.setArguments(bundle);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.main_frame,compliment).addToBackStack("bekommen").commit();
            }
        });


        return view;
    }


    public void change_Button(Button button) {
        if(now_orrange != null){
            now_orrange.setBackgroundColor(Color.WHITE);
            now_orrange.setBackgroundTintMode(PorterDuff.Mode.ADD);
        }
        button.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        button.setBackgroundTintMode(PorterDuff.Mode.SRC_OVER);
        now_orrange = button;
    }
}
