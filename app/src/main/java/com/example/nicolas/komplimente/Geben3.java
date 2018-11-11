package com.example.nicolas.komplimente;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Switch;


/**
 * A simple {@link Fragment} subclass.
 */
public class Geben3 extends Fragment {

    Button geben3_send;
    SeekBar wie_gut;
    Switch annonym;
    CheckBox cb1;
    CheckBox cb2;
    CheckBox cb3;
    CheckBox cb4;



    public Geben3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_geben3, container, false);

        final String wer = getArguments().getString("wer");
        geben3_send = (Button) view.findViewById(R.id.geben3_send);
        wie_gut = (SeekBar) view.findViewById(R.id.how_good);
        annonym = (Switch) view.findViewById(R.id.anonym);
        cb1 = (CheckBox) view.findViewById(R.id.checkBox_sad);
        cb2 = (CheckBox) view.findViewById(R.id.checkBox_incompetend);
        cb3 = (CheckBox) view.findViewById(R.id.checkBox_stress);
        cb4 = (CheckBox) view.findViewById(R.id.checkBox_lonely);

        geben3_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kompli = getArguments().getString("compli");
                //make more restictions
                if(kompli.length() > 5) {
                    send(wer,kompli,annonym.isActivated(),wie_gut.getProgress());
                    Geben4 geben4 = new Geben4();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentManager.popBackStack("main", FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    fragmentManager.beginTransaction().replace(R.id.main_frame,geben4).commit();
                } else {
                    Snackbar snackbar = Snackbar
                            .make(getActivity().findViewById(android.R.id.content), "Compliment is too short", Snackbar.LENGTH_LONG);

                    snackbar.show();
                }
            }
        });
        return view;
    }

    private void send(String wer, String kompli, boolean annonym, int gut) {
        Snackbar snackbar = Snackbar
                .make(getActivity().findViewById(android.R.id.content), "Yey you send something (not really tho)", Snackbar.LENGTH_LONG);

        snackbar.show();
    }

}
