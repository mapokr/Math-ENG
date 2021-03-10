//http://unicode.org/charts/PDF/U2070.pdf
package com.example.mathenggame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import android.widget.CheckBox;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class zadania_matematyka extends SQLiteOpenHelper {
    Opcje check_state = new Opcje();

        public static final String NAME_DB ="data_quest.db";
        public static final String NAME = "math_easy";
        public static final String NAME2 = "math_medium";
        public static final String NAME3 = "math_hard";
        public static final String NAME4 = "eng_easy";
        public static final String NAME5 = "eng_medium";
        public static final String NAME6 = "eng_hard";
        public static final String NAME7 = "Results";
        public static final String NAME8 = "Math_F";
        public static final String [] ALL_DB = {NAME,NAME2,NAME3,NAME4,NAME5,NAME6,NAME8};
        public static final String ID_ ="ID";
        public static final String PYTANIE_ ="PYTANIE";
        public static final String ODP_1_ ="ODP_1";
        public static final String ODP_2_ ="ODP_2";
        public static final String ODP_3_ ="ODP_3";
        public static final String TRUDNOSC_ ="TRUDNOSC";
        public static final String POPRAWNA_ODPOWIEDZ_ ="POPRAWNA_ODPOWIEDZ";
        private int rand_int;


    public zadania_matematyka(Context context) {
            super(context, NAME_DB, null, 1);
            // SQLiteDatabase db = this.getWritableDatabase();


        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table " + NAME+ " (ID INTEGER PRIMARY KEY AUTOINCREMENT,PYTANIE TEXT,ODP_1 TEXT,ODP_2 TEXT,ODP_3 TEXT,POPRAWNA_ODPOWIEDZ INTEGER); ");
            db.execSQL("create table " + NAME2+ " (ID INTEGER PRIMARY KEY AUTOINCREMENT,PYTANIE TEXT,ODP_1 TEXT,ODP_2 TEXT,ODP_3 TEXT,POPRAWNA_ODPOWIEDZ INTEGER); ");
            db.execSQL("create table " + NAME3+ " (ID INTEGER PRIMARY KEY AUTOINCREMENT,PYTANIE TEXT,ODP_1 TEXT,ODP_2 TEXT,ODP_3 TEXT,POPRAWNA_ODPOWIEDZ INTEGER); ");
            db.execSQL("create table " + NAME4+ " (ID INTEGER PRIMARY KEY AUTOINCREMENT,PYTANIE TEXT,ODP_1 TEXT,ODP_2 TEXT,ODP_3 TEXT,POPRAWNA_ODPOWIEDZ TEXT); ");
            db.execSQL("create table " + NAME5+ " (ID INTEGER PRIMARY KEY AUTOINCREMENT,PYTANIE TEXT,ODP_1 TEXT,ODP_2 TEXT,ODP_3 TEXT,POPRAWNA_ODPOWIEDZ TEXT); ");
            db.execSQL("create table " + NAME6+ " (ID INTEGER PRIMARY KEY AUTOINCREMENT,PYTANIE TEXT,ODP_1 TEXT,ODP_2 TEXT,ODP_3 TEXT,POPRAWNA_ODPOWIEDZ TEXT); ");
            db.execSQL("create table " + NAME7+ " (ID INTEGER PRIMARY KEY AUTOINCREMENT,PRZEDMIOT TEXT,WYNIK INT,TRUDNOSC INT); ");
            db.execSQL("create table " + NAME8+ " (ID INTEGER PRIMARY KEY AUTOINCREMENT,PYTANIE TEXT,POPRAWNA_ODPOWIEDZ TEXT); ");


        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         db.execSQL("DROP TABLE IF EXISTS "+ NAME);
         db.execSQL("DROP TABLE IF EXISTS "+ NAME2);
         db.execSQL("DROP TABLE IF EXISTS "+ NAME3);
         db.execSQL("DROP TABLE IF EXISTS "+ NAME4);
         db.execSQL("DROP TABLE IF EXISTS "+ NAME5);
         db.execSQL("DROP TABLE IF EXISTS "+ NAME6);
         db.execSQL("DROP TABLE IF EXISTS "+ NAME7);
         db.execSQL("DROP TABLE IF EXISTS "+ NAME8);
         onCreate(db);



    }
    public Cursor GetRandRowDD (){
        SQLiteDatabase db = this.getWritableDatabase();
        Random generator= new Random();
        int x= parseInt(loadState());

        rand_int = generator.nextInt(10)+ 1;
        Cursor row = db.rawQuery("select pytanie,odp_1,odp_2,odp_3,POPRAWNA_ODPOWIEDZ from ("+ALL_DB[x]+") where id =" + rand_int ,null);
       
        return row;
    }
    public Cursor GetRandOne (){
        SQLiteDatabase db = this.getWritableDatabase();
        Random generator= new Random();
        int x= parseInt(loadState());
        if(x<3){
            x=6;
        }
        rand_int = generator.nextInt(10)+ 1;
        Cursor row = db.rawQuery("select pytanie,POPRAWNA_ODPOWIEDZ from ("+ALL_DB[x]+") where id =" + rand_int ,null);

        return row;
    }

    // m_easy
    public boolean insert_value(){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues ctv = new ContentValues();
        ContentValues ctv2= new ContentValues();
        ContentValues ctv3= new ContentValues();
        long r=0;
        //m_easy
        String[] pme = {"2+2","4*3","2+5","6-2","8-1","10+2","20+10","2*20","3+5","6*6"};
        String[] ome1 = {"4","13","7","4","5","15","30","22","8","66"};
        String[] ome2 = {"2","12","2","2","7","16","40","40","6","36"};
        String[] ome3 = {"1","22","5","6","2","12","35","32","12","42"};
        int[] pome = {4,12,7,4,7,12,30,40,8,36};
        for(int i=0;i<pme .length;i++){
            ctv.put(PYTANIE_,pme [i]);
            ctv.put(ODP_1_,ome1[i]);
            ctv.put(ODP_2_,ome2[i]);
            ctv.put(ODP_3_,ome3[i]);
            ctv.put(POPRAWNA_ODPOWIEDZ_,pome[i]);
            r= db.insert(NAME, null, ctv);
        }
        // \u221A pierwisatek
        //m_medium
        String[] pmm = {"\u00BD + \u00BD"   ,"\u00BC * \u00BD"  ,"\u2155 + \u2156 ","5\u00B3","\u221A4","\u221A121","\u221A49","\u221A36","5\u00B2","10\u00B2"};
        String[] omm1 = {"\u00BC"   ,"\u215B"   ,"\u2157","32","11","11","12","33","8","15"};
        String[] omm2 = {"1"    ,"\u2158"    ,"\u215C","125","2","4","7","5","5","20"};
        String[] omm3 = {"\u00BD"   ,"2"    ,"\u215E","2","33","6","15","6","25","100"};
        String[] pomm = {"1"    ,"\u215B"   ,"\u2157","125","2","11","7","6","25","100"};
        for(int i=0;i<pmm .length;i++){
            ctv.put(PYTANIE_,pmm [i]);
            ctv.put(ODP_1_,omm1[i]);
            ctv.put(ODP_2_,omm2[i]);
            ctv.put(ODP_3_,omm3[i]);
            ctv.put(POPRAWNA_ODPOWIEDZ_,pomm[i]);
            r= db.insert(NAME2, null, ctv);
        }
        //m_hard
        String[] pmh = {"4x=4","2+x=5","6y-2=4","3y+4=4","2+(-2x)=15*2","3x-1=2x","30-12=x","x+12=7","5x-(-2x)=14","6x=12"};
        String[] omh1 = {"1","3","7","0","12","2","18","-5","2","12"};
        String[] omh2 = {"-1","4","1","8","6","1","4","-10","-3","2"};
        String[] omh3 = {"5","-2","2","1","-14","17","12","-11","4","22"};
        int[] pomh = {1,3,1,0,-14,1,18,-5,2,2};
        for(int i=0;i<pmh .length;i++){
            ctv.put(PYTANIE_,pmh [i]);
            ctv.put(ODP_1_,omh1[i]);
            ctv.put(ODP_2_,omh2[i]);
            ctv.put(ODP_3_,omh3[i]);
            ctv.put(POPRAWNA_ODPOWIEDZ_,pomh[i]);
            r= db.insert(NAME3, null, ctv);
        }
        //e_easy
        String[] pee = {"dodawanie","odejmowanie","dzielenie","mnożenie","kwadrat","koło","trójkąt","minus","suma","cyfra"};
        String[] oee1 = {"addition",  "cat",  "short",    "neck",    "feather",   "cut",   "kind",   "minus", "swim",    "or"};
        String[] oee2 = {"able",   "subtraction",  "division",    "multiplication",  "square",    "key",   "elbow",   "kiss",   "sum",    "lift"};
        String[] oee3 = {"face",   "family",    "flat", "arm",  "few",  "circle"  ,"hand",    "triangle", "run",  "digit"};
        String [] poee = {"addition","subtraction","division","multiplication","square","circle","triangle","minus","sum","digit"};
        for(int i=0;i<pee .length;i++){
            ctv.put(PYTANIE_,pee [i]);
            ctv.put(ODP_1_,oee1[i]);
            ctv.put(ODP_2_,oee2[i]);
            ctv.put(ODP_3_,oee3[i]);
            ctv.put(POPRAWNA_ODPOWIEDZ_,poee[i]);
            r= db.insert(NAME4, null, ctv);
        }
        //e_medium
        String[] peh = {"średnica","kąt","promień","zbiór","potęga","ułamek zwykły","sześcian","procent","stożek","prostokąt"};
        String[] oeh1 = {"diameter","dry","get","now","power","lick","cube","ability","lost","odd"};
        String[] oeh2 = {"anybody","angle","earn","set","hat","mirror","box","per cent","cone","root"};
        String[] oeh3 = {"bubble","car","radius","hair","join","fraction","raw","new","bus","busy"};
        String[] poeh = {"diameter","angle","radius","set","power","fraction","cube","per cent","cone","rectangle"};
        for(int i=0;i<peh .length;i++){
            ctv.put(PYTANIE_,peh [i]);
            ctv.put(ODP_1_,oeh1[i]);
            ctv.put(ODP_2_,oeh2[i]);
            ctv.put(ODP_3_,oeh3[i]);
            ctv.put(POPRAWNA_ODPOWIEDZ_,poeh[i]);
            r= db.insert(NAME5, null, ctv);
        }

        //e_hard
        String[] pem = {"dolewać oliwy do ognia","ciągle, w kółko","sztuka dla sztuki","zdrów jak ryba","na pierwszy rzut oka","wypadki chodzą po ludziach ","wszystko dobre, co się dobrze kończy" /*do poprawienia*/,"innym razem","w rezultacie","przyznać się do porażki "};
        String[] oem1 = {"add fuel to the flames","again and again","art for art is sake","where are you dressing?","today is Tuesday","I hid","all is well that ends well","I created a tournament","as a result","how can I do that?"};
        String[] oem2 = {"I love dogs","what are you doing tomorrow","what's your name","will you marry me ?","at first glance","I went out","march out","another time","I do not know what to do","teach me this"};
        String[] oem3 = {"I like you","Hi buddy","you like me?","as right as rain","I run to school","accidents will happen","help me","I lost the tournament","I am refreshed","admit defeat"};
        String[] poem = {"add fuel to the flames","again and again","art for art is sake","as right as rain","at first glance","accidents will happen","all is well that ends well","another time","as a result","admit defeat"};
        for(int i=0;i<pem .length;i++){
            ctv.put(PYTANIE_,pem [i]);
            ctv.put(ODP_1_,oem1[i]);
            ctv.put(ODP_2_,oem2[i]);
            ctv.put(ODP_3_,oem3[i]);
            ctv.put(POPRAWNA_ODPOWIEDZ_,poem[i]);
            r= db.insert(NAME6, null, ctv);
        }
        //

        for(int i=0;i<6;i++){
            ctv2.put("PRZEDMIOT","0");
            ctv2.put("WYNIK",0);
            ctv2.put("TRUDNOSC",i);
            r= db.insert(NAME7, null, ctv2);
        }
        //m_fish
        String[] pmf = {"Pole kwadratu",    "Pole prostokąta"   ,"Pole trójkąta"    ,"Obwód Kwadratu",  "Obwód Prostokąta", "obwód koła",   "Obwód deltoidu","Objętność sześcianu","Pole całkowite sześcianu","Przekątna sześcianu"};
        String[] pomf = {"P=a*a",   "P=a*b" ,"P=\u00BD*a*h" ,"Ob=4*a",  "Ob=2*a+2*b"    ,"P=\u03C0*r\u00B2",    "Ob=2*a+2*b","V = a\u00B3","Pc=6*a\u00B2","d=a*\u221A3"};
        for(int i=0;i<pmf .length;i++){
            ctv3.put(PYTANIE_,pomf [i]);
            ctv3.put(POPRAWNA_ODPOWIEDZ_,pmf[i]);
            r= db.insert(NAME8, null, ctv3);
        }



        if(r==-1){
            return false;
        }
        else{
            return true;
        }
        }
        public boolean Insert_Result(int w){
            long r=0;
            String pr = " ";
            if(Opcje.get_state()<3){
                pr = "Matematyka";
            }
            else{
                pr = "Angielski";
            }

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues ctv = new ContentValues();

            ctv.put("PRZEDMIOT",pr);
            ctv.put("WYNIK",w);
            ctv.put("TRUDNOSC",Opcje.get_state());
            r= db.insert(NAME7, null, ctv);

            if(r==-1){
                return false;
            }
            else{
                return true;
            }
        }
    public Cursor Get_data(int x){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("Select MAX(WYNIK) from Results WHERE Trudnosc="+x,null);
        return c;

    }
    public static String loadState(){
        String get_text = "";
        FileInputStream load_state = null;
        try {
            load_state = new FileInputStream("/data/data/com.example.mathenggame/files/level.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            InputStreamReader input = new InputStreamReader(load_state);
            BufferedReader bufor = new BufferedReader(input);
            StringBuilder builder = new StringBuilder();
            get_text=bufor.readLine();
            builder.append(get_text);
            System.out.println("kotek:"+get_text);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                load_state.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return get_text;
    }
}
