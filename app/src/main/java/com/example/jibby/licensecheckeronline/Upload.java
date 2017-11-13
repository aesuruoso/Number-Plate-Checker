package com.example.jibby.licensecheckeronline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Jibby on 22-Jul-17.
 */

public class Upload extends AppCompatActivity {

    EditText registration_number, make, model, vehicle_type, colour, insurance, tax, mot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        registration_number = (EditText)findViewById(R.id.uploadReg);
        make = (EditText)findViewById(R.id.uploadMake);
        model = (EditText)findViewById(R.id.uploadModel);
        vehicle_type = (EditText)findViewById(R.id.uploadType);
        colour = (EditText)findViewById(R.id.uploadColour);
        insurance = (EditText)findViewById(R.id.uploadInsurance);
        tax = (EditText)findViewById(R.id.uploadTax);
        mot = (EditText)findViewById(R.id.uploadMOT);
        registration_number.requestFocus();
    }
    public void OnReg(View view) {
        String str_registration_number = registration_number.getText().toString();
        String str_make = make.getText().toString();
        String str_model = model.getText().toString();
        String str_vehicle_type = vehicle_type.getText().toString();
        String str_colour = colour.getText().toString();
        String str_insurance = insurance.getText().toString();
        String str_tax = tax.getText().toString();
        String str_mot = mot.getText().toString();
        String type = "register";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, str_registration_number, str_make, str_model, str_vehicle_type, str_colour, str_insurance, str_tax, str_mot);
    }
    public void home(View view) {
        startActivity(new Intent(this, camera.class));
    }
}


