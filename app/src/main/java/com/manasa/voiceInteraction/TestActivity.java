package com.manasa.voiceInteraction;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import timber.log.Timber;

import static android.content.Intent.ACTION_CALL;

public class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if (!TextUtils.isEmpty(intent.getAction()) && intent.getAction().equalsIgnoreCase(ACTION_CALL)) {
            Timber.i("Google voice activity triggered");
            Toast.makeText(this, "Intent triggered from GVI action: " + getIntent().getAction(), Toast.LENGTH_LONG).show();

            setContentView(R.layout.test_main);
        } else if (!TextUtils.isEmpty(intent.getAction())){
            Toast.makeText(this, "Intent triggered from GVI action: " + getIntent().getAction(), Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
