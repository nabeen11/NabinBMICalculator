package com.example.bmicalculatornabin;

public class BMINabin {

    private float height,weight;
    private  float bmi;
    private float meter;

    public BMINabin(float height, float weight) {
        this.height = height;
        this.weight = weight;
    }

    public float Calculate() {
        meter = (height/100);
        bmi = weight/(meter*meter);
        return bmi;
    }
}
