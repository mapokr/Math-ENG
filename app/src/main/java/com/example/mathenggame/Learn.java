package com.example.mathenggame;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import static java.lang.Integer.parseInt;

public class Learn extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public Learn() {

    }
    public static Learn newInstance(String param1, String param2) {
        Learn fragment = new Learn();
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
  private Button presentSimple,presentContinues,presentPerfect,futureSimple,pastContinues,futureContinues,pastSimple;
    public zadania_matematyka state;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_learn, container, false);
        presentSimple = (Button) v.findViewById(R.id.present_simple);
        presentContinues = (Button) v.findViewById(R.id.present_continues);
        presentPerfect =(Button) v.findViewById(R.id.present_perfect);
        futureSimple=(Button) v.findViewById(R.id.future_simple);
        pastContinues =(Button) v.findViewById(R.id.past_continues);
        futureContinues =(Button) v.findViewById(R.id.future_continues);
        pastSimple = (Button) v.findViewById(R.id.past_simple);
        int x = parseInt(state.loadState());
        if(x<3){
            presentSimple.setText("kwadrat");
            presentContinues.setText("prostokat");
            presentPerfect.setText("trójkąt");
            futureSimple.setText("sześcian");
            pastContinues.setText("równania");
            futureContinues.setText("asd ");
            pastSimple.setText("trapez");
        }
        if(x>=3)
        {
            presentSimple.setText("present simple");
            presentContinues.setText("present continues");
            presentPerfect.setText("present perfect");
            futureSimple.setText("future simple");
            pastContinues.setText("past continues");
            futureContinues.setText("czasowniki nieregularne");
            pastSimple.setText("past simple");
        }
        presentSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(presentSimple.getText().equals("present simple")){
                    open_presentSimple();
                }
                if(presentSimple.getText().equals("kwadrat")){
                    open_square();
                }
            }
        });
        presentContinues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(presentContinues.getText().equals("present continues")){
                    open_presentContinues();
                }
                if(presentContinues.getText().equals("rectangle")){
                    open_rectangle();
                }
            }

        });
        pastSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pastSimple.getText().equals("past simple")){
                    open_pastSimple();
                }
                if(pastSimple.getText().equals("trapez")){
                    open_trapeze();
                }
            }

        });
        presentPerfect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(presentPerfect.getText().equals("present perfect")){
                    open_presentperfect();
                }
                if(presentPerfect.getText().equals("trójkąt")){
                    open_triangle();
            }
            }

        });
        futureSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(futureSimple.getText().equals("future simple")){
                    open_futureSimple();
                }
                if(futureSimple.getText().equals("sześcian")){
                    open_cube();
                }
            }
        });
        pastContinues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pastContinues.getText().equals("past continues")){
                    open_pastContinues();
                }
                if(pastContinues.getText().equals("równiania")){
                    open_equations();
                }
            }
        });
        futureContinues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(futureContinues.getText().equals("czasowniki nieregularne")){
                    open_reg();
                }
            }
        });

        return v;
    }
    public void open_presentSimple(){
        Intent start = new Intent(getContext(), com.example.mathenggame.presentSimple.class);
        startActivity(start);
    }
    public void open_square(){
        Intent start = new Intent(getContext(), com.example.mathenggame.square.class);
        startActivity(start);
    }
    public void open_presentContinues(){
        Intent start = new Intent(getContext(),com.example.mathenggame.presentcontinues.class);
        startActivity(start);

    }
    public void open_rectangle(){
        Intent start = new Intent(getContext(),com.example.mathenggame.rectangle.class);
        startActivity(start);
    }
    public void open_pastSimple(){
        Intent start = new Intent(getContext(),com.example.mathenggame.pastsimple.class);
        startActivity(start);

    }
    public void open_trapeze(){
        Intent start = new Intent(getContext(),com.example.mathenggame.trapeze.class);
        startActivity(start);
    }
    public void open_presentperfect(){
        Intent start = new Intent(getContext(),com.example.mathenggame.presentperfect.class);
        startActivity(start);

    }
    public void open_futureSimple(){
        Intent start = new Intent(getContext(),com.example.mathenggame.futuresimple.class);
        startActivity(start);

    }
    public void open_triangle(){
        Intent start = new Intent(getContext(),com.example.mathenggame.triangle.class);
        startActivity(start);
    }
    public void open_cube(){
        Intent start = new Intent(getContext(),com.example.mathenggame.cube.class);
        startActivity(start);
    }
    public void open_equations(){
        Intent start = new Intent(getContext(),com.example.mathenggame.equations.class);
        startActivity(start);
    }
    public void open_pastContinues(){
        Intent start = new Intent(getContext(),com.example.mathenggame.pastcontinues.class);
        startActivity(start);
    }
    public void open_reg(){
        Intent start = new Intent(getContext(),com.example.mathenggame.verbs.class);
        startActivity(start);
    }
    public void open_asd(){
        Intent start = new Intent(getContext(),com.example.mathenggame.pastcontinues.class);
        startActivity(start);
    }
}