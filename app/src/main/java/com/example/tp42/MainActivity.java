package com.example.tp42;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.tp42.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity  {

    private static final String TAG = "TP4";
    private ActivityMainBinding ui; // Utilisation du View Binding pour accéder aux vues
    private int compteur = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ui = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(ui.getRoot());
        setTitle(getLocalClassName());
        Log.i(TAG, "dans " + getLocalClassName() + ".onCreate");

        // Écouteurs pour les boutons
        ui.bouton1.setOnClickListener(this::onBouton1Click);
        ui.bouton3.setOnClickListener(this::onBouton3Click);
        ui.bouton5.setOnClickListener(this::onBouton5Click);
        ui.bouton6.setOnClickListener(this::onBouton6Click);

        // Écouteur pour le bouton2
        ui.bouton2.setOnClickListener(view -> {
            compteur += 2;
            ui.texte.setText("compteur = " + compteur);
        });

        // Récupération de l'intent qui a déclenché cette activité
        Intent intent = getIntent();
        if (intent.hasExtra("username")) {
            // Récupération de l'username depuis l'extra de l'intent
            String username = intent.getStringExtra("username");

            // Affichage du message de bienvenue
            TextView greetingTextView = findViewById(R.id.greetingTextView);
            greetingTextView.setText("Bonjour " + username);
        }
    }

    public void onBouton1Click(View view) {
        compteur += 1;
        ui.texte.setText("compteur = " + compteur);
    }

    private void onBouton3Click(View view) {
        compteur *= 2;
        ui.texte.setText("compteur = " + compteur);
    }

    public void onBouton5Click(View view) {
        // Lancer InfosActivity sans fermer MainActivity
        Intent intent = new Intent(this, InfosActivity.class);
        startActivity(intent);
    }

    public void onBouton6Click(View view) {
        // Lancer InfosActivity et fermer MainActivity
        Intent intent = new Intent(this, InfosActivity.class);
        startActivity(intent);
        finish(); // Ferme MainActivity
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "dans " + getLocalClassName() + ".onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "dans " + getLocalClassName() + ".onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "dans " + getLocalClassName() + ".onResume");
    }
}
