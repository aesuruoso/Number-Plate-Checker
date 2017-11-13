package com.example.jibby.licensecheckeronline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText textReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textReg = (EditText) findViewById(R.id.enterReg);
    }

    public void OnLogin(View view) {
        String registration_number = textReg.getText().toString();
        String type = "login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, registration_number);
    }
    public void ViewAll(View view) {
        String type = "ViewAll";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type);
    }

    public void OpenReg(View view) {
        startActivity(new Intent(this, Upload.class));
    }

    public void OnDelete(View view) {
        String registration_number = textReg.getText().toString();
        String type = "delete";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, registration_number);
    }
    public void OnUpdate(View view) {
        startActivity(new Intent(this, update.class));
    }
    public void home(View view) {
        startActivity(new Intent(this, camera.class));
    }
}