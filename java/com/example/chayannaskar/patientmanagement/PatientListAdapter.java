package com.example.chayannaskar.patientmanagement;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by chayannaskar on 19/06/17.
 */

public class PatientListAdapter extends ArrayAdapter<Patient> {

    private Context ctx;
    private ArrayList<Patient> plist;

    public PatientListAdapter(@NonNull Context context, ArrayList<Patient> list) {
        super(context, R.layout.patient_row_layout, list);
        ctx = context;
        plist = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = null;
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(ctx);
            row = inflater.inflate(R.layout.patient_row_layout, parent, false);
        }else{
            row = convertView;
        }



            TextView tvphone = (TextView) row.findViewById(R.id.tvphone);
            TextView tvname = (TextView) row.findViewById(R.id.tvname1);
            TextView tvdate = (TextView) row.findViewById(R.id.tvdate);
            TextView tvaffliction = (TextView) row.findViewById(R.id.tvaffliction);
            TextView tvpriorty = (TextView) row.findViewById(R.id.tvpriorty);

            Patient p = plist.get(position);
            tvphone.setText(p.getPhone());
            tvname.setText(p.getName());
            tvdate.setText(p.getDate());
            tvaffliction.setText(p.getAffliction());
            tvpriorty.setText(String.valueOf(p.getCriticalpriorty()));

            if (p.getCriticalpriorty() == 1) {
                row.setBackgroundResource(R.color.row_critical);
            } else if (p.getCriticalpriorty() == 2) {
                row.setBackgroundResource(R.color.row_moderate);
            } else {
                row.setBackgroundResource(R.color.row_fine);
            }





        return row;
    }
}

