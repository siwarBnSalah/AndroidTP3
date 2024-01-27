package com.example.tp42;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.example.tp42.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding ui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialisation du layout via View Binding
        ui = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(ui.getRoot());
        // Titre de l'activité
        setTitle(getLocalClassName());
        ui.username.setOnEditorActionListener(this::onEditorAction);
    }

    private boolean onEditorAction(TextView textView, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            String username = ui.username.getText().toString();
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
            finish();
            return true;
        } else {
            return false;
        }
    }
}