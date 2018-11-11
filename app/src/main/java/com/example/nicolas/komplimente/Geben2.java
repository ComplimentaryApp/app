package com.example.nicolas.komplimente;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Geben2 extends Fragment {

    EditText compliment;
    Button geben2_next;
    TextView to;

    public Geben2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_geben2, container, false);

        final String wer = getArguments().getString("wer");
        compliment = (EditText) view.findViewById(R.id.geben2_edit);
        geben2_next = (Button) view.findViewById(R.id.geben2_next);
        to = (TextView) view.findViewById(R.id.compliment_to);
        to.setText("Compliment to " + wer);
        geben2_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kompli = compliment.getText().toString();
                if(kompli.length() > 5) {
                    Bundle bundle = new Bundle();
                    bundle.putString("wer",wer);
                    bundle.putString("compli",kompli);
                    Geben3 geben3 = new Geben3();
                    geben3.setArguments(bundle);
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.main_frame,geben3).addToBackStack("geben2").commit();
                } else {
                    Snackbar snackbar = Snackbar
                            .make(getActivity().findViewById(android.R.id.content), "Compliment is too short", Snackbar.LENGTH_LONG);

                    snackbar.show();
                }

            }
        });
        return view;
    }

}
