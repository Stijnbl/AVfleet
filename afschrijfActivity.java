package com.example.stijn.ikpmd5;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class afschrijfActivity extends AppCompatActivity {

//    private int[] b = {0};
//    private ArrayList<Entry> yvalues = new ArrayList<>();
//    private PieChart pieChart ;
//
//
//
//
//
//    private ArrayList<String> xVals = new ArrayList<String>();


    DatabaseReference rootRef,demoRef;
    String inlogNaam;
   // public counter i = new counter(0);
   // Switch acht;

    private TextView naam;
//    private int counterI;
//    static int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // acht = (Switch) findViewById(R.id.acht);
        rootRef = FirebaseDatabase.getInstance().getReference();
        //database reference pointing to demo node
        demoRef = rootRef.child("demo");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afschrijf);
        setTitle("AVfleet");

        Bundle c = getIntent().getExtras();

        if(c != null){
            inlogNaam = c.getString("inlognaam");

        }


        Switch acht = (Switch)  findViewById(R.id.acht);
        Switch negen = (Switch)  findViewById(R.id.negen);
        Switch tien = (Switch)  findViewById(R.id.tien);
        Switch elf = (Switch)  findViewById(R.id.elf);
        Switch twaalf = (Switch)  findViewById(R.id.twaalf);
        Switch een = (Switch)  findViewById(R.id.een);
        Switch twee = (Switch)  findViewById(R.id.twee);
        Switch drie = (Switch)  findViewById(R.id.drie);
        Switch vier = (Switch)  findViewById(R.id.vier);
        Switch vijf = (Switch)  findViewById(R.id.vijf);
        Switch zes = (Switch)  findViewById(R.id.zes);
        Switch zeven = (Switch)  findViewById(R.id.zeven);
        TextView bezet8 = (TextView) findViewById(R.id.Bezet8);
        TextView bezet9 = (TextView) findViewById(R.id.Bezet9);
        TextView bezet10 = (TextView) findViewById(R.id.Bezet10);
        TextView bezet11= (TextView) findViewById(R.id.Bezet11);
        TextView bezet12= (TextView) findViewById(R.id.Bezet12);
        TextView bezet13= (TextView) findViewById(R.id.Bezet13);
        TextView bezet14= (TextView) findViewById(R.id.Bezet14);
        TextView bezet15= (TextView) findViewById(R.id.Bezet15);
        TextView bezet16= (TextView) findViewById(R.id.Bezet16);
        TextView bezet17= (TextView) findViewById(R.id.Bezet17);
        TextView bezet18= (TextView) findViewById(R.id.Bezet18);
        TextView bezet19= (TextView) findViewById(R.id.Bezet19);
        Bundle b = getIntent().getExtras();
        if(b != null){
            String bootNaam = b.getString("boot");
            bezet(inlogNaam,bootNaam, "achttotnegen",acht,bezet8,"achttotnegenDoor" );
            bezet(inlogNaam,bootNaam, "negentottien",negen,bezet9,"negentottienDoor" );
            bezet(inlogNaam,bootNaam, "tientotelf",tien,bezet10, "tientotelfDoor");
            bezet(inlogNaam,bootNaam, "elftottwaalf",elf,bezet11, "elftottwaalfDoor");
            bezet(inlogNaam,bootNaam, "twaalftoteen",twaalf,bezet12,"twaalftoteenDoor");
            bezet(inlogNaam,bootNaam, "eentottwee",een,bezet13,"eentottweeDoor");
            bezet(inlogNaam,bootNaam, "tweetotdrie",twee,bezet14,"tweetotdrieDoor");
            bezet(inlogNaam,bootNaam, "drietotvier",drie,bezet15,"drietotvierDoor");
            bezet(inlogNaam,bootNaam, "viertotvijf",vier,bezet16,"viertotvijfDoor");
            bezet(inlogNaam,bootNaam, "vijftotzes",vijf,bezet17,"vijftotzesDoor");
            bezet(inlogNaam,bootNaam, "zestotzeven",zes,bezet18,"zestotzevenDoor");
            bezet(inlogNaam,bootNaam, "zeventotacht",zeven,bezet19,"zeventotachtDoor");
            bezet2(inlogNaam,bootNaam, "achttotnegen",acht,bezet8,"achttotnegenDoor" );
            bezet2(inlogNaam,bootNaam, "negentottien",negen,bezet9,"negentottienDoor" );
            bezet2(inlogNaam,bootNaam, "tientotelf",tien,bezet10, "tientotelfDoor");
            bezet2(inlogNaam,bootNaam, "elftottwaalf",elf,bezet11, "elftottwaalfDoor");
            bezet2(inlogNaam,bootNaam, "twaalftoteen",twaalf,bezet12,"twaalftoteenDoor");
            bezet2(inlogNaam,bootNaam, "eentottwee",een,bezet13,"eentottweeDoor");
            bezet2(inlogNaam,bootNaam, "tweetotdrie",twee,bezet14,"tweetotdrieDoor");
            bezet2(inlogNaam,bootNaam, "drietotvier",drie,bezet15,"drietotvierDoor");
            bezet2(inlogNaam,bootNaam, "viertotvijf",vier,bezet16,"viertotvijfDoor");
            bezet2(inlogNaam,bootNaam, "vijftotzes",vijf,bezet17,"vijftotzesDoor");
            bezet2(inlogNaam,bootNaam, "zestotzeven",zes,bezet18,"zestotzevenDoor");
            bezet2(inlogNaam,bootNaam, "zeventotacht",zeven,bezet19,"zeventotachtDoor");
            //maakChart("Nemea","Knorlando Bloom", "Dikke dik", "1 Oktober", "Skiffing Image");
        }
        afschrijfbutton(inlogNaam,"achttotnegen", "achttotnegenDoor", acht);
        afschrijfbutton(inlogNaam,"negentottien", "negentottienDoor", negen);
        afschrijfbutton(inlogNaam,"tientotelf", "tientotelfDoor", tien);
        afschrijfbutton(inlogNaam,"elftottwaalf", "elftottwaalfDoor", elf);
        afschrijfbutton(inlogNaam,"twaalftoteen", "twaalftoteenDoor", twaalf);
        afschrijfbutton(inlogNaam,"eentottwee", "eentottweeDoor", een);
        afschrijfbutton(inlogNaam,"tweetotdrie", "tweetotdrieDoor", twee);
        afschrijfbutton(inlogNaam,"drietotvier", "drietotvierDoor", drie);
        afschrijfbutton(inlogNaam,"viertotvijf", "viertotvijfDoor", vier);
        afschrijfbutton(inlogNaam,"vijftotzes", "vijftotzesDoor", vijf);
        afschrijfbutton(inlogNaam,"zestotzeven", "zestotzevenDoor", zes);
        afschrijfbutton(inlogNaam,"zeventotacht", "zeventotachtDoor", zeven);

        }
    private void afschrijven(final String bootNaam, final String inlogNaam, final String tijd, final String tijdDoor){


        demoRef.child("boot").child(bootNaam).child(tijd).setValue(false);
        demoRef.child("boot").child(bootNaam).child(tijdDoor).setValue(inlogNaam);

    }
    private void annuleren(final String bootNaam, final String tijd, final String tijdDoor){


        demoRef.child("boot").child(bootNaam).child(tijd).setValue(true);
        demoRef.child("boot").child(bootNaam).child(tijdDoor).setValue("");

    }
    private void bezet(final String inlogNaam, final String bootNaam, final String tijd, final Switch schakelaar, final TextView tv, final String tijdDoor  ) {

        demoRef.child("boot").child(bootNaam).child(tijd).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                boolean value = dataSnapshot.getValue(boolean.class);
                if (value == false) {
                    tv.setVisibility(View.VISIBLE);
                    schakelaar.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
    private void bezet2(final String inlogNaam, final String bootNaam, final String tijd, final Switch schakelaar, final TextView tv, final String tijdDoor  ){


        demoRef.child("boot").child(bootNaam).child(tijdDoor).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                if (value.equals(inlogNaam) ) {
                    tv.setVisibility(View.INVISIBLE);
                    schakelaar.setVisibility(View.VISIBLE);
                    schakelaar.setChecked(true);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
    private void afschrijfbutton(final String inlogNaam, final String tijd, final String tijdDoor, Switch sButton){
        sButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Bundle b = getIntent().getExtras();

                if(b != null){
                    String bootNaam = b.getString("boot");
                    if (isChecked){
                        afschrijven(bootNaam,inlogNaam,tijd, tijdDoor);
                        }

                    else {
                        annuleren(bootNaam,tijd,tijdDoor);


                    }
                }

            }

        });
    }}

//    private void maakChart(String Boot1,String Boot2,String Boot3,String Boot4,String Boot5){
//
//        pieChart = (PieChart) findViewById(R.id.piechart);
//
//
//        xVals.add("Nemea");
//        xVals.add("Knorlando Bloom");
//        xVals.add("Dikke dik");
//        xVals.add("Skiffing Image");
//        xVals.add("1 Oktober");
//        for(String string:xVals){
//            aantalafschrijvingen(string);
//        }
//        }
//
//        public void aantalafschrijvingen(final String bootNaam){
//            demoRef.child("boot").child(bootNaam)
//                    .addListenerForSingleValueEvent(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(DataSnapshot dataSnapshot) {
//
//                            b[0] = 0;
//                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                                if (snapshot.getValue() instanceof Boolean) {
//                                    Boolean naam = snapshot.getValue(Boolean.class);
//
//                                    if (naam.equals(false)) {
//                                       // i.addCounter();
//                                        Log.d("wow", bootNaam + String.valueOf(b[0]));
//                                        b[0]++;
//                                    }
//
//                                }
//                            }
//                            dataisfetched();
//                        }
//
//                        @Override
//                        public void onCancelled(DatabaseError databaseError) {
//                        }
//                    });
//
//
//
//        }
//
//        public void dataisfetched(){
//            for(int i =0; i < b.length; i++){
//                yvalues.add(new Entry(b[i], i));
//            }
//
//            if(yvalues.size() == xVals.size()){
//                System.out.println(xVals);
//                for(Entry entry: yvalues){
//                    System.out.println(entry.getVal());
//                }
//                PieDataSet dataSet = new PieDataSet(yvalues, "Election Results");
//
//                dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
//                pieChart.setDescription("");
//                pieChart.getLegend().setEnabled(false);
//                pieChart.setCenterText("Meest gehuurde boten");
//
//                pieChart.setCenterTextSize(25f);
//
//                dataSet.setValueTextSize(17f);
//                PieData data = new PieData(xVals, dataSet);
//                //data.setValueFormatter(new PercentFormatter());
//                pieChart.setData(data);
//                pieChart.invalidate();
//                pieChart.isDrawSliceTextEnabled();
//            }
//
//
//        }
//
//
//    }


