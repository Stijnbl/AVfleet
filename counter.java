package com.example.stijn.ikpmd5;

public class counter {
    private int i;

    public counter(int i) {
        this.i = i;
    }
    public int getCounter(){
        return this.i;
    }
    public void setCounter(int i){
        this.i = i;
    }
    public void addCounter(){
        this.i = i + 1;
    }
    public void resetCounter(){
        this.i = 0;
    }
}
