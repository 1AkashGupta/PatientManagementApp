package com.example.chayannaskar.patientmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private PatientDataAccess pda;
    private TextView tvname, tvphone, tvafflication, tvdate, tvpriorty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        Log.v("resultact","name : "+name);
        pda = new PatientDataAccess(getApplicationContext(), 1);
        Patient patient = pda.searchPatient(name);

        tvname = (TextView) findViewById(R.id.tvname1);
        tvphone = (TextView) findViewById(R.id.tvphone1);
        tvafflication = (TextView) findViewById(R.id.tvafflication1);
        tvdate = (TextView) findViewById(R.id.tvdate1);
        tvpriorty = (TextView) findViewById(R.id.tvpriorty1);

        tvname.setText("Name : "+ patient.getName());
        tvafflication.setText("Afflication : "+ patient.getAffliction());
        tvphone.setText("Phone No. : "+ patient.getPhone());
        tvdate.setText("Date Of Last Admission : "+ patient.getDate());
        tvpriorty.setText("Critical Priorty : "+ String.valueOf(patient.getCriticalpriorty()));
    }
}
