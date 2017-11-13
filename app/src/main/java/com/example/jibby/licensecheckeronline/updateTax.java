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

public class updateTax extends AppCompatActivity {
    EditText reg, Tax;
    Button update, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_tax);

        reg = (EditText)findViewById(R.id.enterReg);
        Tax = (EditText)findViewById(R.id.enterInsurance);
        update = (Button)findViewById(R.id.updateInsurance);
        home = (Button)findViewById(R.id.buttonHome);
    }
    public void updateTax(View view) {
        String registration_number = reg.getText().toString();
        String tax = Tax.getText().toString();
        String type = "updateTax";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, registration_number, tax);
    }
    public void home(View view) {
        startActivity(new Intent(this, camera.class));
    }
}


