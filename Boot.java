package com.example.stijn.ikpmd5;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Boot {

    public String BootNaam;
    public String Nummer;
    public Boolean achttotnegen;
    public String achttotnegenDoor;
    public Boolean negentottien;
    public String negentottienDoor;
    public Boolean tientotelf;
    public String tientotelfDoor;
    public Boolean elftottwaalf;
    public String elftottwaalfDoor;
    public Boolean twaalftoteen;
    public String twaalftoteenDoor;
    public Boolean eentottwee;
    public String eentottweeDoor;
    public Boolean tweetotdrie;
    public String tweetotdrieDoor;
    public Boolean drietotvier;
    public String drietotvierDoor;
    public Boolean viertotvijf;
    public String viertotvijfDoor;
    public Boolean vijftotzes;
    public String vijftotzesDoor;
    public Boolean zestotzeven;
    public String zestotzevenDoor;
    public Boolean zeventotacht;
    public String zeventotachtDoor;


   public Boot() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
       //
    }

    public Boot(String BootNaam, String Nummer, Boolean achttotnegen, String achttotnegenDoor, Boolean negentottien, String negentottienDoor, Boolean tientotelf, String tientotelfDoor, Boolean elftottwaalf, String elftottwaalfDoor, Boolean twaalftoteen, String twaalftoteenDoor, Boolean eentottwee, String eentottweeDoor, Boolean tweetotdrie, String tweetotdrieDoor, Boolean drietotvier, String drietotvierDoor, Boolean viertotvijf, String viertotvijfDoor, Boolean vijftotzes, String vijftotzesDoor, Boolean zestotzeven, String zestotzevenDoor, Boolean zeventotacht, String zeventotachtDoor) {
        this.BootNaam = BootNaam;
        this.Nummer = Nummer;
        this.achttotnegen = achttotnegen;
        this.achttotnegenDoor= achttotnegenDoor;
        this.negentottien = negentottien;
        this.negentottienDoor = negentottienDoor;
        this.tientotelf = tientotelf;
        this.tientotelfDoor = tientotelfDoor;
        this.elftottwaalf = elftottwaalf;
        this.elftottwaalfDoor = elftottwaalfDoor;
        this.twaalftoteen = twaalftoteen;
        this.twaalftoteenDoor = twaalftoteenDoor;
        this.eentottwee = eentottwee;
        this.eentottweeDoor = eentottweeDoor;
        this.tweetotdrie = tweetotdrie;
        this.tweetotdrieDoor = tweetotdrieDoor;
        this.drietotvier = drietotvier;
        this.drietotvierDoor = drietotvierDoor;
        this.viertotvijf = viertotvijf;
        this.viertotvijfDoor = viertotvijfDoor;
        this.vijftotzes = vijftotzes;
        this.vijftotzesDoor = vijftotzesDoor;
        this.zestotzeven = zestotzeven;
        this.zestotzevenDoor = zestotzevenDoor;
        this.zeventotacht = zeventotacht;
        this.zeventotachtDoor = zeventotachtDoor;

    }

}
