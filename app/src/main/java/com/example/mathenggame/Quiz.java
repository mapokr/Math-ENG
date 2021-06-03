package com.example.mathenggame;

import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Quiz extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Quiz() {
    }

    public static Quiz newInstance(String param1, String param2) {
        Quiz fragment = new Quiz();
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
    private Button ans_1,ans_2,ans_3,start_game;
    private int count=0;
    private zadania_matematyka sld;
    private TextView question,count_view;
    private Cursor c;
    private String tmp=" ";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_quiz, container, false);
        sld = new zadania_matematyka(getActivity());
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ans_1 =(Button) v.findViewById(R.id.anwser_1);
        ans_2 =(Button) v.findViewById(R.id.anwser_2);
        ans_3 =(Button) v.findViewById(R.id.anwser_3);
        start_game =(Button) v.findViewById(R.id.start_game_button);
        question = (TextView) v.findViewById(R.id.question_view);
        count_view = (TextView) v.findViewById(R.id.correct_count);
        start_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.play_sound();
                set_quest_quiz();
                v.setVisibility(v.GONE);
            }
        });
        ans_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click_button(1);
                MainActivity.play_sound();
            }
        });
        ans_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click_button(2);
                MainActivity.play_sound();
            }

        });
        ans_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click_button(3);
                MainActivity.play_sound();
            }

        });
        return v;
    }

    public void click_button(int x){
        if(!tmp.equals(" ")) {
            switch (x) {
                case 1:
                    if (ans_1.getText().equals(tmp)) {
                        count += 1;
                        set_quest_quiz();
                    } else {
                        set_quest_quiz();
                    }
                    break;

                case 2:
                    if (ans_2.getText().equals(tmp)) {

                        count += 1;
                        set_quest_quiz();
                    } else {
                        set_quest_quiz();
                    }
                    break;
                case 3:
                    if (ans_3.getText().equals(tmp)) {
                        count += 1;
                        set_quest_quiz();
                    } else {
                        set_quest_quiz();
                    }
                    break;
                default:
                    set_quest_quiz();

            }
        }
        else{
            Toast.makeText(getActivity(),"Musisz wystartować grę", Toast.LENGTH_SHORT).show();
        }
    }

    public void set_quest_quiz(){
        c =sld.GetRandRowDD();
        if(c.getCount()==0){
            System.out.println("błąd odczytu");
        }
        else{
            while(c.moveToNext()){
                ans_1.setText(c.getString(1).toString());
                ans_2.setText(c.getString(3).toString());
                ans_3.setText(c.getString(2).toString());
                question.setText(c.getString(0).toString());
                count_view.setText("PKT: "+count);
                tmp =c.getString(4).toString();
            }
        }
    }
}