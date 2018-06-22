package com.example.stijn.ikpmd5;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class OverzichtActivity extends AppCompatActivity {
    DatabaseReference rootRef, demoRef;
    String inlogNaam;
    private int[] b = {0};
    private ArrayList<Entry> yvalues = new ArrayList<>();
    private PieChart pieChart ;
    private int counterI;
    static int i;





    private ArrayList<String> xVals = new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overzicht);
        Bundle c = getIntent().getExtras();
        rootRef = FirebaseDatabase.getInstance().getReference();
        //database reference pointing to demo node
        demoRef = rootRef.child("demo");
        setTitle("AVfleet Overzicht");

        if(c != null){
            inlogNaam = c.getString("inlognaam");

        }
        Bundle b = getIntent().getExtras();
        if(b != null){
            String bootNaam = b.getString("boot");

            maakChart("Nemea","Knorlando Bloom", "Dikke dik", "1 Oktober", "Skiffing Image");
        }
        rootRef = FirebaseDatabase.getInstance().getReference();
        //database reference pointing to demo node
        demoRef = rootRef.child("demo");
        final ListView listView=(ListView)findViewById(R.id.listview);
        final ArrayList<String> arrayList=new ArrayList<>();

//Add elements to arraylist

        check(inlogNaam, "Knorlando Bloom", arrayList, listView);
        check(inlogNaam, "1 Oktober", arrayList,listView);
        check(inlogNaam, "Skiffing Image", arrayList, listView);
        check(inlogNaam, "Dikke dik", arrayList, listView);
        check(inlogNaam, "Nemea", arrayList, listView);
        arrayList.add(inlogNaam);


        //Create Adapter
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                listmaker(arrayList,listView);
            }
        }, 1000);


    }
            private void check(final String inlognaam, final String bootNaam,final ArrayList<String> arrayList, final ListView listView){
                demoRef.child("boot").child(bootNaam)
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                  if (snapshot.getValue() instanceof String) {
                                      String naam = snapshot.getValue(String.class);
                                      String data = snapshot.getKey();
                                      if (data.equals("achttotnegenDoor")) {
                                          data = "08:00 - 09:00";
                                      }
                                      if (data.equals("negentottienDoor")) {
                                          data = "09:00 - 10:00";
                                      }
                                      if (data.equals("tientotelfDoor")) {
                                          data = "10:00 - 11:00";
                                      }
                                      if (data.equals("elftottwaalfDoor")) {
                                          data = "11:00 - 12:00";
                                      }
                                      if (data.equals("twaalftoteenDoor")) {
                                          data = "12:00 - 13:00";
                                      }
                                      if (data.equals("eentottweeDoor")) {
                                          data = "13:00 - 14:00";
                                      }
                                      if (data.equals("tweetotdrieDoor")) {
                                          data = "14:00 - 15:00";
                                      }
                                      if (data.equals("drietotvierDoor")) {
                                          data = "15:00 - 16:00";
                                      }
                                      if (data.equals("viertotvijfDoor")) {
                                          data = "16:00 - 17:00";
                                      }  if (data.equals("vijftotzesDoor")) {
                                          data = "17:00 - 18:00";
                                      }  if (data.equals("zestotzevenDoor")) {
                                          data = "18:00 - 19:00";
                                      }  if (data.equals("zeventotachtDoor")) {
                                          data = "19:00 - 20:00";
                                      }

                                      if (naam.equals(inlognaam)) {
                                          arrayList.add(data+"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+ bootNaam);



                                       // Log.d("wow", String.valueOf(arrayList));

                                      }
                                  }
                                }
                            }


                            @Override
                            public void onCancelled(DatabaseError databaseError) {
                            }
                        });
}
private void listmaker(final ArrayList arrayList,final ListView listView){
    ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);

//assign adapter to listview
    listView.setAdapter(arrayAdapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Toast.makeText(OverzichtActivity.this,"clicked item:"+i+" "+arrayList.get(i).toString(),Toast.LENGTH_SHORT).show();
        }
    });
}



    private void maakChart(String Boot1,String Boot2,String Boot3,String Boot4,String Boot5){

        pieChart = (PieChart) findViewById(R.id.piechart);


        xVals.add("Nemea");
        xVals.add("Knorlando Bloom");
        xVals.add("Dikke dik");
        xVals.add("Skiffing Image");
        xVals.add("1 Oktober");
        for(String string:xVals){
            aantalafschrijvingen(string);
        }
    }

    public void aantalafschrijvingen(final String bootNaam){
        demoRef.child("boot").child(bootNaam)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        b[0] = 0;
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            if (snapshot.getValue() instanceof Boolean) {
                                Boolean naam = snapshot.getValue(Boolean.class);

                                if (naam.equals(false)) {
                                    // i.addCounter();
                                    Log.d("wow", bootNaam + String.valueOf(b[0]));
                                    b[0]++;
                                }

                            }
                        }


                            dataisfetched();

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });



    }

    public void dataisfetched(){
        for(int i =0; i < b.length; i++){
            System.out.println(b[i] + "nummer");

                        System.out.println(b[i]);
                        yvalues.add(new Entry(b[i], i));

        }

        if(yvalues.size() == xVals.size()){
           // System.out.println(xVals+ "wowi");
            for(Entry entry: yvalues){
             //   System.out.println(entry.getVal());
            }
            PieDataSet dataSet = new PieDataSet(yvalues, "m ");

            dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            pieChart.setDescription("");
            pieChart.getLegend().setEnabled(false);
            pieChart.setCenterText("Meest gehuurde boten");

            pieChart.setCenterTextSize(25f);

            dataSet.setValueTextSize(17f);
            PieData data = new PieData(xVals, dataSet);
            //data.setValueFormatter(new PercentFormatter());
            pieChart.setData(data);
            pieChart.invalidate();
            pieChart.isDrawSliceTextEnabled();
            pieChart.spin( 500,0,-360f, Easing.EasingOption.EaseInOutQuad);
        }


    }


}