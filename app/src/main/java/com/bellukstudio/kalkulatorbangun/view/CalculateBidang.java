package com.bellukstudio.kalkulatorbangun.view;

import android.util.Log;

public class CalculateBidang implements Bidang {
    private double luas;
    private double keliling;
    private double volume;
    private String namaBidang;


    @Override
    public double getLuas() {
        return this.luas;
    }

    @Override
    public double getKeliling() {
        return this.keliling;
    }

    @Override
    public String getNamaBidang() {
        return this.namaBidang;
    }

    @Override
    public void setLuas(double luas) {
        this.luas = luas;
    }

    @Override
    public void setKeliling(double keliling) {
        this.keliling = keliling;
    }

    @Override
    public void setNamaBidang(String namaBidang) {
        this.namaBidang = namaBidang;
    }

    @Override
    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public double getVolume() {
        return this.volume;
    }


}
