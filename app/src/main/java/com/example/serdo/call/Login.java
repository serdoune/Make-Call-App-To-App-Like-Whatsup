package com.example.serdo.call;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        if (ContextCompat.checkSelfPermission(Login.this,
                android.Manifest.permission.RECORD_AUDIO) !=
                PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission
                (Login.this, android.Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED ) {
            ActivityCompat.requestPermissions(Login.this,
                    new String[]{android.Manifest.permission.RECORD_AUDIO, Manifest.permission.READ_PHONE_STATE},
                    1);
        }

        findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Call2.class);
                intent.putExtra("callerId", ((TextView) findViewById(R.id.callerId)).getText().toString());
                intent.putExtra("recipientId", ((TextView) findViewById(R.id.recipientId)).getText().toString());
                startActivity(intent);
            }
        });
    }

}
