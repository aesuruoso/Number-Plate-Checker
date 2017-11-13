package com.example.jibby.licensecheckeronline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Jibby on 23-Jul-17.
 */

public class update extends AppCompatActivity {

    Button btnInsurance, btnTax, btnMOT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);
        btnInsurance = (Button)findViewById(R.id.buttonInsurance);
        btnTax = (Button)findViewById(R.id.buttonTax);
        btnMOT = (Button)findViewById(R.id.buttonMOT);
    }
    public void insurance(View view) {
        startActivity(new Intent(this, updateInsurance.class));
    }
    public void tax(View view) {
        startActivity(new Intent(this, updateTax.class));
    }
    public void mot(View view) {
        startActivity(new Intent(this, updateMOT.class));
    }
    public void home(View view) {
        startActivity(new Intent(this, camera.class));
    }
}
