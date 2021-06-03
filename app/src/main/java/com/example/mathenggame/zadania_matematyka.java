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

        rand_int = generator.nextInt(30)+ 1;
        Cursor row = db.rawQuery("select pytanie,odp_1,odp_2,odp_3,POPRAWNA_ODPOWIEDZ from ("+ALL_DB[x]+") where id =" + rand_int ,null);

        return row;
    }

    public Cursor GetRandOne (){
        SQLiteDatabase db = this.getWritableDatabase();
        Random generator = new Random();
        int x= parseInt(loadState());
        if(x<3){
            x=6;
        }
        rand_int = generator.nextInt(30)+ 1;
        Cursor row = db.rawQuery("select pytanie,POPRAWNA_ODPOWIEDZ from ("+ALL_DB[x]+") where id =" + rand_int ,null);

        return row;
    }
    // - KROPKA \u2022
    // m_easy
    public boolean insert_value(){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues ctv = new ContentValues();
        ContentValues ctv2= new ContentValues();
        ContentValues ctv3= new ContentValues();
        long r=0;
        //m_easy
//        String[] pme = {"2+2","4*3","2+5","6-2","8-1","10+2","20+10","2*20","3+5","6*6"};
//        String[] ome1 = {"4","13","7","4","5","15","30","22","8","66"};
//        String[] ome2 = {"2","12","2","2","7","16","40","40","6","36"};
//        String[] ome3 = {"1","22","5","6","2","12","35","32","12","42"};
//        int[] pome = {4,12,7,4,7,12,30,40,8,36};
        String[] pme = {"2+2=",	"10+2=",	"6+9=",	"13+13=",	"4+22=",	"1+7=",	"10-2=",	"20-13=",	"2-4=",	"22-11=",	"3-3=",	"14-13=",	"7\u20227=",	"2\u20225=",	"10\u202210=",	"1\u20226=",	"5\u20226=",	"5\u20225=",	"16:4=",	"60:10=",	"28:4=",	"25:5=",	"100:10=",	"81:9=",	"121:11=",	"30-5=",	"15+15=",	"13-7=",	"1+3=",	"12:4="};
        String[] ome1 = {"4",	"11",	"26",	"26",	"8",	"11",	"8",	"-2",	"0",	"11",	"1",	"15",	"49",	"21",	"15",	"6",	"8",	"20",	"2",	"5",	"13",	"5",	"11",	"8",	"11",	"20",	"32",	"6",	"5",	"2"};
        String[] ome2 = {"12",	"12",	"4",	"0",	"25",	"4",	"10",	"7",	"-1",	"13",	"0",	"8",	"33",	"10",	"9",	"4",	"30",	"55",	"1",	"6",	"4",	"4",	"10",	"12",	"14",	"25",	"40",	"3",	"4",	"14"};
        String[] ome3 = {"7",	"8",	"15",	"11",	"26",	"8",	"4",	"8",	"-2",	"22",	"2",	"1",	"77",	"8",	"100",	"7",	"35",	"25",	"7",	"7",	"7",	"9",	"1",	"9",	"7",	"22",	"30",	"4",	"10",	"3",};
        int[] pome = {4,12,	15,	26,	25,	8,	8,	7,	-2,	11,	0,	1,	49,	10,	100,	6,	30,	25,	2,	6,	7,	5,	10,	9,	11,	25,	30,	6,	4,	3};
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
        String[] pmm = {"½ + ½=",	"¼ \u2022 ½=",	"⅕ + ⅖=",	"\u221A4=",	"\u221A9=",	"\u221A25=",	"\u221A100=",	"\u221A49=",	"\u221A36=",	"\u221A121=",	"\u221A81=",	"\u221A64=",	"5²=",	"6²=",	"7²=",	"4²=",	"3²=",	"11²=",	"12²=",	"8²=",	"2²=",	"obwód kwadratu o boku 5=",	"Pole kwadratu o boku 2=",	"obwód prostokąta o bokach 2 i 3=",	"Pole prostokąta o bokach 4 i 5=",	"3\u00B3=",	"2\u00B3=",	"4\u00B3=",	"5\u00B3=",	"\u221A16="};
        String[] omm1 = {"1",	"⅕",	"3",	"2",	"6",	"2",	"10",	"14",	"7",	"11",	"6",	"11",	"25",	"12",	"14",	"16",	"6",	"22",	"144",	"38",	"3",	"20",	"6",	"21",	"20",	"28",	"7",	"64",	"15",	"3"};
        String[] omm2 = {"⅗",	"⅛",	"½",	"1",	"3",	"3",	"12",	"7",	"14",	"12",	"9",	"5",	"14",	"36",	"40",	"8",	"9",	"111",	"121",	"64",	"6",	"22",	"4",	"16",	"15",	"27",	"8",	"16",	"125",	"8"};
        String[] omm3 = {"⅕",	"⅖",	"⅗",	"4",	"8",	"5",	"11",	"5",	"6",	"8",	"7",	"8",	"10",	"30",	"49",	"13",	"2",	"121",	"24",	"66",	"4",	"18",	"3",	"10",	"14",	"13",	"8",	"65",	"121",	"4"};
        String[] pomm = {"1",	"⅛",	"⅗",	"2",	"3",	"5",	"10",	"7",	"6",	"11",	"9",	"8",	"25",	"36",	"49",	"16",	"9",	"121",	"144",	"64",	"4",	"20",	"4",	"10",	"20",	"27",	"8",	"64",	"125",	"4"};
        for(int i=0;i<pmm .length;i++){
            ctv.put(PYTANIE_,pmm [i]);
            ctv.put(ODP_1_,omm1[i]);
            ctv.put(ODP_2_,omm2[i]);
            ctv.put(ODP_3_,omm3[i]);
            ctv.put(POPRAWNA_ODPOWIEDZ_,pomm[i]);
            r= db.insert(NAME2, null, ctv);
        }
        //m_hard
//        String[] pmh = {"4x=4","2+x=5","6y-2=4","3y+4=4","2+(-2x)=15*2","3x-1=2x","30-12=x","x+12=7","5x-(-2x)=14","6x=12"};
//        String[] omh1 = {"1","3","7","0","12","2","18","-5","2","12"};
//        String[] omh2 = {"-1","4","1","8","6","1","4","-10","-3","2"};
//        String[] omh3 = {"5","-2","2","1","-14","17","12","-11","4","22"};
//        int[] pomh = {1,3,1,0,-14,1,18,-5,2,2};
        String[] pmh = {"log\u20824=",	"log\u20828=",	"log\u208216=",	"log\u208232=",	"log\u20839=",	"log\u208327=",	"x-30=-3",	"4x=4",	"2+x=5",	"6y-2=4",	"3y+4=4",	"6x=12",	"5x-(-2x)=14",	"x+12=7",	"30-12=x",	"5y=20",	"\u221B27=",	"\u221B8=",	"\u221B64=",	"\u221B125=",	"321+123=",	"20\u202221=",	"490-343=",	"150:5=",	"128+241=",	"11\u202213=",	"156-72=",	"68:12=",	"2x=x+15",	"y= -2y-3",};
        String[] omh1 = {"2",	"4",	"5",	"5",	"2",	"14",	"12",	"x=1",	"x=7",	"x=(-2)",	"y=0",	"x=10",	"x=4",	"x=-5",	"x=33",	"y=4",	"3",	"4",	"15",	"4",	"444",	"342",	"160",	"30",	"359",	"156",	"84",	"5",	"x=12",	"y=1",};
        String[] omh2 = {"6",	"3",	"8",	"3",	"3",	"3",	"16",	"x=(-1)",	"x=3",	"x=3",	"y=-5",	"x=2",	"x=-12",	"x=4",	"x=18",	"y=6",	"6",	"2",	"6",	"6",	"555",	"420",	"177",	"20",	"369",	"122",	"93",	"3",	"x=14",	"y=4",};
        String[] omh3 = {"4",	"5",	"4",	"2",	"6",	"12",	"27",	"x=4",	"x=5",	"x=1",	"y=6",	"x=6",	"x=2",	"x=5",	"x=16",	"y=1",	"9",	"6",	"4",	"5",	"666",	"462",	"147",	"50",	"379",	"143",	"74",	"6",	"x=15",	"y=-1",};
        String[] pomh = {"2",	"3",	"4",	"5",	"2",	"3",	"27",	"x=1",	"x=5",	"x=1",	"y=0",	"x=2",	"x=2",	"x=-5",	"x=18",	"y=4",	"3",	"2",	"4",	"5",	"444",	"420",	"147",	"30",	"369",	"143",	"84",	"6",	"x=15",	"y=-1",};
        for(int i=0;i<pmh .length;i++){
            ctv.put(PYTANIE_,pmh [i]);
            ctv.put(ODP_1_,omh1[i]);
            ctv.put(ODP_2_,omh2[i]);
            ctv.put(ODP_3_,omh3[i]);
            ctv.put(POPRAWNA_ODPOWIEDZ_,pomh[i]);
            r= db.insert(NAME3, null, ctv);
        }
        //e_easy
//        String[] pee = {"dodawanie","odejmowanie","dzielenie","mnożenie","kwadrat","koło","trójkąt","minus","suma","cyfra"};
//        String[] oee1 = {"addition",  "cat",  "short",    "neck",    "feather",   "cut",   "kind",   "minus", "swim",    "or"};
//        String[] oee2 = {"able",   "subtraction",  "division",    "multiplication",  "square",    "key",   "elbow",   "kiss",   "sum",    "lift"};
//        String[] oee3 = {"face",   "family",    "flat", "arm",  "few",  "circle"  ,"hand",    "triangle", "run",  "digit"};
//        String [] poee = {"addition","subtraction","division","multiplication","square","circle","triangle","minus","sum","digit"};
        String[] pee = {"dodawanie",	"odejmowanie",	"mnożenie",	"dzielenie",	"wynik",	"suma",	"różnica",	"iloczyn",	"ułamek",	"koło",	"kwadrat",	"prostokąt",	"stożek",	"sześcian",	"promień",	"kąt",	"pole powierzchni",	"procent",	"romb",	"kula",	"obliczenie",	"skrócić",	"trapez",	"cięciwa",	"objętość",	"linijka",	"kątomierz",	"tablica",	"kreda"	,"cyrkiel"};
        String[] oee1 = {"addition",	"multiplication",	"difference",	"division",	"circle",	"rhomb",	"difference",	"calculation",	"area",	"circle",	"sphere",	"board",	"cone"	,"compass"	,"calculation"	,"angle"	,"board"	,"trapezium"	,"rhomb",	"chalk"	,"calculation"	,"circle"	,"cube",	"chord",	"division"	,"angle"	,"protractor"	,"rhomb",	"subtraction",	"compass"};
        String[] oee2 = {"division",	"subtraction",	"result",	"rectangle",	"result",	"sphere",	"fraction",	"product"	,"angle"	,"cube"	,"square"	,"ruler"	,"cube"	,"cube",	"reduce"	,"rhomb"	,"area",	"rhomb",	"calculation",	"sphere",	"square"	,"reduce"	,"radius"	,"angle",	"volume",	"cone",	"radius"	,"board"	,"chord",	"ruler"};
        String[] oee3 = {"result",	"fraction",	"multiplication ",	"cone",	"difference",	"total",	"square",	"reduce",	"fraction",	"radius",	"volume",	"rectangle",	"sphere"	,"square",	"radius",	"difference"	,"reduce"	,"percent"	,"ruler",	"rectangle"	,"circle",	"result",	"trapezium",	"division",	"subtraction",	"ruler"	,"calculation",	"trapezium",	"chalk"	,"area"};
        String [] poee = {"addition",	"subtraction",	"multiplication",	"division",	"result",	"total",	"difference",	"product",	"fraction",	"circle",	"square",	"rectangle",	"cone",	"cube"	,"radius"	,"angle",	"area"	,"percent",	"rhomb"	,"sphere"	,"calculation",	"reduce",	"trapezium"	,"chord"	,"volume"	,"ruler",	"protractor",	"board"	,"chalk"	,"compass"};
        for(int i=0;i<pee .length;i++){
            ctv.put(PYTANIE_,pee [i]);
            ctv.put(ODP_1_,oee1[i]);
            ctv.put(ODP_2_,oee2[i]);
            ctv.put(ODP_3_,oee3[i]);
            ctv.put(POPRAWNA_ODPOWIEDZ_,poee[i]);
            r= db.insert(NAME4, null, ctv);
        }

        //e_medium
//        String[] peh = {"średnica","kąt","promień","zbiór","potęga","ułamek zwykły","sześcian","procent","stożek","prostokąt"};
//        String[] oeh1 = {"diameter","dry","get","now","power","lick","cube","ability","lost","odd"};
//        String[] oeh2 = {"anybody","angle","earn","set","hat","mirror","box","per cent","cone","root"};
//        String[] oeh3 = {"bubble","car","radius","hair","join","fraction","raw","new","bus","busy"};
//        String[] poeh = {"diameter","angle","radius","set","power","fraction","cube","per cent","cone","rectangle"};
        String[] peh = {" być (III forma)",	"zaczynać (II forma)",	"robić(II forma)",	"być (II forma)",	"pić (II forma)",	"dostawać (II forma)",	"latać (II forma)",	"stawać się (II forma)",	"jeździć  (II forma)",	"dzwonić(III forma)",	"jeść (III forma)",	"iść (III forma)",	"prowadzić (III forma)",	"wiedzieć (III forma)",	"pokazywać (III forma)",	"spiewać (III forma)",	"spiewać (I forma)",	"mieć (I forma)",	"budować (I forma)",	"iść (I forma)",	"zgubić (I forma)",	"rzucić (I forma)",	"spotykać (I forma)",	"trzymać (I forma)",	"wygrywać (II forma)",	"pokazywać (I forma)",	"iść (II forma)",	"zaczynać (I forma)",	"powiedzieć (II forma)",	"spać(II forma)"};
        String[] oeh1 = {"been",	"begin",	"did",	"was/were",	"drunk",	"get",	"flew",	"become",	"ride",	"rung",	"eat",	"went",	"driven",	"knew",	"show",	"sung",	"sung",	"have",	"bait",	"went",	"lost",	"throw",	"met",	"kept",	"won",	"show",	"went",	"begin",	"tell",	"sleep"};
        String[] oeh2 = {"was",	"began",	"do",	"be",	"drank",	"got",	"fly",	"became",	"ridden",	"rang",	"eaten",	"go",	"drove",	"known",	"showed",	"sang",	"sang",	"had",	"build",	"go",	"last",	"threw",	"meet",	"know",	"win",	"showed",	"go",	"began",	"tall",	"slept"};
        String[] oeh3 = {"were",	"begun",	"done",	"been",	"drink",	"gat",	"flewn",	"becam",	"rode",	"ring",	"ate",	"gone",	"drive",	"know",	"shown",	"sing",	"sing",	"hidden",	"bilt",	"gone",	"lose",	"thrown",	"mealt",	"keep",	"went",	"shown",	"gone",	"begun",	"told",	"slopt"};
        String[] poeh = {"been",	"began",	"did",	"was/were",	"drank",	"got",	"flew",	"became",	"rode",	"rung",	"eaten",	"gone",	"driven",	"known",	"shown",	"sung",	"sing",	"have",	"build",	"go",	"lose",	"throw",	"meet",	"keep",	"won",	"showed",	"wenr",	"begin",	"told",	"slept"};
        for(int i=0;i<peh .length;i++){
            ctv.put(PYTANIE_,peh [i]);
            ctv.put(ODP_1_,oeh1[i]);
            ctv.put(ODP_2_,oeh2[i]);
            ctv.put(ODP_3_,oeh3[i]);
            ctv.put(POPRAWNA_ODPOWIEDZ_,poeh[i]);
            r= db.insert(NAME5, null, ctv);
        }

        //e_hard
//        String[] pem = {"dolewać oliwy do ognia","ciągle, w kółko","sztuka dla sztuki","zdrów jak ryba","na pierwszy rzut oka","wypadki chodzą po ludziach ","Czas leczy rany" ,"innym razem","w rezultacie","przyznać się do porażki "};
//        String[] oem1 = {"add fuel to the flames","again and again","art for art is sake","where are you dressing?","today is Tuesday","I hid","Time heals all wounds","I created a tournament","as a result","how can I do that?"};
//        String[] oem2 = {"I love dogs","what are you doing tomorrow","what's your name","will you marry me ?","at first glance","I went out","march out","another time","I do not know what to do","teach me this"};
//        String[] oem3 = {"I like you","Hi buddy","you like me?","as right as rain","I run to school","accidents will happen","help me","I lost the tournament","I am refreshed","admit defeat"};
//        String[] poem = {"add fuel to the flames","again and again","art for art is sake","as right as rain","at first glance","accidents will happen","Time heals all wounds","another time","as a result","admit defeat"};
        String[] pem = {"Dawno się nie widzieliśmy",	"Nie mogę narzekać",	"Skąd wiesz",	"Dziękuję z góry",	"Nic się nie martw",	"Co się dzieje?",	"Nieważne",	"Rzeczy się wydarzają",	"Na czym to skończyliśmy",	"Głowa do góry",	"Ani trochę",	"To nie jest tego warte",	"Dolewać oliwy do ognia",	"Ciągle, w kółko",	"Sztuka dla sztuki",	"Zdrów jak ryba",	"Na pierwszy rzut oka",	"Czas leczy rany",	"Innym razem",	"W rezultacie",	"Przyznać się do porażki",	"Tak przypuszczam",	"Co robisz?",	"Która jest godzina?",	"Miło mi cię poznać",	"Będziemy w kontakcie",	"To się już nigdy nie powtórzy",	"Napisz wkrótce",	"Trzymaj się",	"Bardzo ci dziękuję"};
        String[] oem1 = {"Long time no see",	"It doesn’t matter",	"Cheer up",	"Thank you in advance",	"another time",	"Long time no see",	"It doesn’t matter",	"Nice to meet you.",	"as right as rain",	"Cheer up",	"It will never happen again",	"What time is it?",	"add fuel to the flames",	"Where were we",	"Thank you so much.",	"as right as rain",	"as a result",	"What are you doing",	"another time",	"art for art is sake",	"Take care",	"I suppose so",	"Write soon",	"add fuel to the flames",	"Nice to meet you.",	"The plan includes",	"I must support this poin",	"Write soon",	"It is not clear to me",	"things happen"};
        String[] oem2 = {"I can’t complain",	"I can’t complain",	"again and again",	"It doesn’t matter",	"No worries",	"I can’t complain",	"What time is it?",	"things happen",	"We'll be in touch",	"at first glance",	"Not a bit",	"We'll be in touch",	"Long time no see",	"again and again",	"Write soon",	"We'll be in touch",	"at first glance",	"It’s not worth it",	"Thank you so much.",	"as a result",	"things happen",	"It’s not worth it",	"What are you doing",	"It doesn’t matter",	"I suppose so",	"We'll be in touch",	"I'm so sorry",	"Yours faithfully",	"Take care",	"How are you"};
        String[] oem3 = {"Thank you in advance",	"things happen",	"How do you know",	"Time heals all wounds",	"art for art is sake",	"What’s going on?",	"admit defeat",	"Cheer up",	"Where were we",	"I can’t complain",	"Write soon",	"It’s not worth it",	"What time is it?",	"Take care",	"art for art is sake",	"I suppose so",	"as right as rain",	"Time heals all wounds",	"It doesn’t matter",	"as right as rain",	"admit defeat",	"Time heals all wounds",	"Could you tell me",	"What time is it?",	"I must support this poin",	"It is not clear to me",	"It will never happen again",	"I'm so sorry",	"another time",	"Thank you so much."};
        String[] poem = {"Long time no see",	"I can’t complain",	"How do you know",	"Thank you in advance",	"No worries",	"What’s going on?",	"It doesn’t matter",	"things happen",	"Where were we",	"Cheer up",	"Not a bit",	"It’s not worth it",	"add fuel to the flames",	"again and again",	"art for art is sake",	"as right as rain",	"at first glance",	"Time heals all wounds",	"another time",	"as a result",	"admit defeat",	"I suppose so",	"What are you doing",	"What time is it?",	"Nice to meet you.",	"We'll be in touch",	"It will never happen again",	"Write soon",	"Take care",	"Thank you so much.",};

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
        String[] pmf = {"Pole kwadratu",    "Pole prostokąta"   ,"Pole trójkąta"    ,"Obwód Kwadratu",  "Obwód Prostokąta", "obwód koła",   "Obwód deltoidu","Objętność sześcianu","Pole całkowite sześcianu","Przekątna sześcianu","Pole kwadratu",    "Pole prostokąta"   ,"Pole trójkąta"    ,"Obwód Kwadratu",  "Obwód Prostokąta", "obwód koła",   "Obwód deltoidu","Objętność sześcianu","Pole całkowite sześcianu","Przekątna sześcianu","Pole kwadratu",    "Pole prostokąta"   ,"Pole trójkąta"    ,"Obwód Kwadratu",  "Obwód Prostokąta", "obwód koła",   "Obwód deltoidu","Objętność sześcianu","Pole całkowite sześcianu","Przekątna sześcianu","Pole kwadratu",    "Pole prostokąta"   ,"Pole trójkąta"    ,"Obwód Kwadratu",  "Obwód Prostokąta", "obwód koła",   "Obwód deltoidu","Objętność sześcianu","Pole całkowite sześcianu","Przekątna sześcianu","Pole kwadratu",    "Pole prostokąta"   ,"Pole trójkąta"    ,"Obwód Kwadratu",  "Obwód Prostokąta", "obwód koła",   "Obwód deltoidu","Objętność sześcianu","Pole całkowite sześcianu","Przekątna sześcianu","Pole kwadratu",    "Pole prostokąta"   ,"Pole trójkąta"    ,"Obwód Kwadratu",  "Obwód Prostokąta", "obwód koła",   "Obwód deltoidu","Objętność sześcianu","Pole całkowite sześcianu","Przekątna sześcianu"};
        String[] pomf = {"P=a*a",   "P=a*b" ,"P=\u00BD*a*h" ,"Ob=4*a",  "Ob=2*a+2*b"    ,"P=\u03C0*r\u00B2",    "Ob=2*a+2*b","V = a\u00B3","Pc=6*a\u00B2","d=a*\u221A3","P=a*a",   "P=a*b" ,"P=\u00BD*a*h" ,"Ob=4*a",  "Ob=2*a+2*b"    ,"P=\u03C0*r\u00B2",    "Ob=2*a+2*b","V = a\u00B3","Pc=6*a\u00B2","d=a*\u221A3","P=a*a",   "P=a*b" ,"P=\u00BD*a*h" ,"Ob=4*a",  "Ob=2*a+2*b"    ,"P=\u03C0*r\u00B2",    "Ob=2*a+2*b","V = a\u00B3","Pc=6*a\u00B2","d=a*\u221A3","P=a*a",   "P=a*b" ,"P=\u00BD*a*h" ,"Ob=4*a",  "Ob=2*a+2*b"    ,"P=\u03C0*r\u00B2",    "Ob=2*a+2*b","V = a\u00B3","Pc=6*a\u00B2","d=a*\u221A3","P=a*a",   "P=a*b" ,"P=\u00BD*a*h" ,"Ob=4*a",  "Ob=2*a+2*b"    ,"P=\u03C0*r\u00B2",    "Ob=2*a+2*b","V = a\u00B3","Pc=6*a\u00B2","d=a*\u221A3","P=a*a",   "P=a*b" ,"P=\u00BD*a*h" ,"Ob=4*a",  "Ob=2*a+2*b"    ,"P=\u03C0*r\u00B2",    "Ob=2*a+2*b","V = a\u00B3","Pc=6*a\u00B2","d=a*\u221A3"};
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
            if(parseInt(loadState())<3){
                pr = "Matematyka";
            }
            else{
                pr = "Angielski";
            }

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues ctv = new ContentValues();

            ctv.put("PRZEDMIOT",pr);
            ctv.put("WYNIK",w);
            ctv.put("TRUDNOSC",parseInt(loadState()));
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
            get_text = "2";
            e.printStackTrace();
        }
        if(load_state!=null){
        try {
            InputStreamReader input = new InputStreamReader(load_state);
            BufferedReader bufor = new BufferedReader(input);
            StringBuilder builder = new StringBuilder();
            get_text=bufor.readLine();
            builder.append(get_text);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            get_text = "2";
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                load_state.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }
        return get_text;
    }
}
