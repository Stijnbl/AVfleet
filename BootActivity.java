package com.example.stijn.ikpmd5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BootActivity extends AppCompatActivity {
    Button Nemea, afschrijfscherm, Dikke, Skiffing, Knorlando, Oktober, ma, reset ;
    DatabaseReference rootRef,demoRef;
    TextView demoValue;
    String inlogNaam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boot);

        Bundle b = getIntent().getExtras();
        setTitle("AVfleet");
        reset = (Button) findViewById(R.id.reset) ;
        if(b != null){
            inlogNaam = b.getString("gebruiker");
            if(inlogNaam.equals("Admin")){
                reset.setVisibility(View.VISIBLE);
            }

        }
        Nemea = (Button) findViewById(R.id.Nemea);
        Oktober = (Button) findViewById(R.id.Oktober);
        Dikke = (Button) findViewById(R.id.Dikke);
        Skiffing = (Button) findViewById(R.id.Skiffing);
        Knorlando = (Button) findViewById(R.id.Knorlando);



        rootRef = FirebaseDatabase.getInstance().getReference();
        //database reference pointing to demo node
        demoRef = rootRef.child("demo");
        ma = (Button) findViewById(R.id.ma);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeNewBoot("Knorlando Bloom","2-", true, "", true , "", true,"", true,"",true, "", true , "", true,"", true, "", true , "", true,"", true, "", true,"" );
                writeNewBoot("Skiffing Image","1", true,"",true,"",true, "", true, "",true, "", true , "", true,"", true,"",true, "", true , "", true,"", true,"" );
                writeNewBoot("Nemea","Gladde 4", true, "", true , "", true,"", true,"",true, "", true , "", true,"", true,"",true, "", true , "", true,"", true,"" );
                writeNewBoot("Dikke dik","8", true, "", true , "", true,"", true,"",true, "", true , "", true,"", true,"",true, "", true , "", true,"", true,"" );
                writeNewBoot("1 Oktober","c4", true, "", true , "", true,"", true,"",true, "", true , "", true,"", true,"",true, "", true , "", true,"", true,"" );
            }
        });
        ma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent OverzichtIntent = new Intent(BootActivity.this, OverzichtActivity.class);
                Bundle b = new Bundle();
                b.putString("inlognaam", inlogNaam);
                OverzichtIntent.putExtras(b);
                startActivity(OverzichtIntent);
            }
        });
        Nemea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                naarAfschrijven("Nemea", inlogNaam);
            }
        });
        Oktober.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                naarAfschrijven("1 Oktober", inlogNaam);
            }
        });
        Skiffing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                naarAfschrijven("Skiffing Image", inlogNaam);
            }
        });
        Dikke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                naarAfschrijven("Dikke dik", inlogNaam);
            }
        });
        Knorlando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                naarAfschrijven("Knorlando Bloom", inlogNaam);
            }
        });


    }
    private void writeNewBoot(String BootNaam, String Nummer,boolean achttotnegen, String achttotnegenDoor, Boolean negentottien,String negentottienDoor, Boolean tientotelf,String tientotelfDoor, boolean elftottwaalf, String elftottwaalfDoor, Boolean twaalftoteen, String twaalftoteenDoor, Boolean eentottwee, String eentottweeDoor, Boolean tweetotdrie, String tweetotdrieDoor, Boolean drietotvier, String drietotvierDoor, Boolean viertotvijf, String viertotvijfDoor, Boolean vijftotzes, String vijftotzesDoor, Boolean zestotzeven, String zestotzevenDoor, Boolean zeventotacht, String zeventotachtDoor ) {
        Boot boot = new Boot(BootNaam, Nummer,achttotnegen, achttotnegenDoor,negentottien, negentottienDoor, tientotelf, tientotelfDoor,elftottwaalf, elftottwaalfDoor, twaalftoteen, twaalftoteenDoor, eentottwee, eentottweeDoor,  tweetotdrie,  tweetotdrieDoor, drietotvier,  drietotvierDoor,  viertotvijf,viertotvijfDoor,  vijftotzes,  vijftotzesDoor,  zestotzeven, zestotzevenDoor,  zeventotacht,  zeventotachtDoor );

        demoRef.child("boot").child(BootNaam).setValue(boot);
    }
    private void afschrijven(final String BootNaam, final String inlogNaam){


        demoRef.child("boot").child(BootNaam).child("IsVrij").setValue(false);
        demoRef.child("boot").child(BootNaam).child("AfgeschrevenDoor").setValue("stijn");
    }
    private void naarAfschrijven(String BootNaam, String inlogNaam){


        Log.d("halo", "lksafjd;lfkandsg;lasknga;dsgnasdovnasdovbnasdk;fnadskfnasdofnasodfn: ");
        Intent intent = new Intent(BootActivity.this, afschrijfActivity.class);
        Bundle b = new Bundle();
        b.putString("boot", BootNaam);
        b.putString("inlognaam", inlogNaam);
        intent.putExtras(b);
        startActivity(intent);
    }

}

