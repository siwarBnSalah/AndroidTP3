package com.example.tp42;

import android.app.Application;

public class TP4Application extends Application {
    private int compteur; // Variable globale

    @Override
    public void onCreate() {
        super.onCreate();
        this.compteur = 0; // Initialisation de la variable globale
    }

    public int getCompteur() {
        return compteur;
    }

    public void setCompteur(int compteur) {
        this.compteur = compteur;
    }
}
