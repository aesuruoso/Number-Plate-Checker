package com.example.jibby.licensecheckeronline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Jibby on 23-Jul-17.
 */

public class updateMOT extends AppCompatActivity {
    EditText reg, MOT;
    Button update, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_mot);

        reg = (EditText)findViewById(R.id.enterReg);
        MOT = (EditText)findViewById(R.id.enterMOT);
        update = (Button)findViewById(R.id.updateMOT);
        home = (Button)findViewById(R.id.buttonHome);
    }
    public void updateMOT(View view) {
        String registration_number = reg.getText().toString();
        String mot = MOT.getText().toString();
        String type = "updateMOT";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, registration_number, mot);
    }
    public void home(View view) {
        startActivity(new Intent(this, camera.class));
    }
}



