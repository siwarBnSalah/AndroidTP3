package com.example.tp42;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos);

        // Trouver le bouton de retour par son ID
        Button retourButton = findViewById(R.id.bouton1);

        // Ajouter un écouteur de clic au bouton de retour
        retourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cela ramènera à MainActivity s'il est encore vivant, sinon au bureau.
                finish();
            }
        });
    }
}