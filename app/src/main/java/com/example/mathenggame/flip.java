package com.example.mathenggame;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link flip#newInstance} factory method to
 * create an instance of this fragment.
 */
public class flip extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public flip() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment flip.
     */
    // TODO: Rename and change types and number of parameters
    public static flip newInstance(String param1, String param2) {
        flip fragment = new flip();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }




    }
    private Button flip1;
    private static Button next;
    private zadania_matematyka sld;
    private static String tmp,tmp2;
    private int count=0;
    private Cursor c;
    private static int  TIME = 500;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_flip, container, false);
        sld = new zadania_matematyka(getActivity());
        flip1 = (Button) v.findViewById(R.id.flip_3);
        next = (Button) v.findViewById(R.id.next_button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set_quest();
                MainActivity.play_sound();
                count=0;
                next.setText("NEXT");

            }
        });
        flip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tran_button();
                MainActivity.play_sound();

            }
        });
       return v;
    }
    public void tran_button() {
        Handler handler = new Handler();
        if (count == 0) {
            flip1.animate().scaleX(0);
            flip1.animate().start();
            new Handler().postDelayed(new Runnable() {
                                          @Override
                                          public void run() {
                                              flip1.animate().scaleX(1);
                                              flip1.animate().start();
                                              flip1.setText(tmp);
                                              count++;
                                          }
                                      }, TIME
            );

        } else {

            flip1.animate().scaleX(0);
            flip1.animate().start();
            new Handler().postDelayed(new Runnable() {

                                          @Override
                                          public void run() {
                                              flip1.animate().scaleX(1);
                                              flip1.animate().start();
                                              flip1.setText(tmp2);
                                              count--;
                                          }
                                      }, TIME
            );




        }
    }
    public void set_quest(){
        c =sld.GetRandOne();
        if(c.getCount()==0){
            System.out.println("on_click_f");
        }
        else{
            while(c.moveToNext()){
                flip1.setText(c.getString(1).toString());
                tmp=c.getString(0).toString();
                tmp2 =c.getString(1).toString();


            }

        }
}}