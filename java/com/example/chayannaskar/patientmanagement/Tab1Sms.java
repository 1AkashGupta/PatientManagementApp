package com.example.chayannaskar.patientmanagement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by chayannaskar on 16/06/17.
 */

public class Tab1Sms extends Fragment {

    private ListView listview;
    private ArrayList<String> smslog;
    private ArrayAdapter<String> aa;
    private PatientDataAccess pda;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View root =inflater.inflate(R.layout.tab1sms, container, false);
        ContentResolver cr = getContext().getContentResolver();
        listview = (ListView) root.findViewById(R.id.listviewsms);
        Cursor smsInboxCursor = cr.query(Uri.parse("content://sms/inbox"), null, null, null, null);
        int indexBody = smsInboxCursor.getColumnIndex("body");
        int indexAddress = smsInboxCursor.getColumnIndex("address");
        pda = new PatientDataAccess(getContext(), 1);

        if (indexBody < 0 || !smsInboxCursor.moveToFirst()) return null;

        smslog = new ArrayList<>();
            do {
                String str = "SMS From: " + smsInboxCursor.getString(indexAddress) +
                        "\n" + smsInboxCursor.getString(indexBody) + "\n";
                Log.v("Tab1","Str : "+smsInboxCursor.getString(indexAddress));
                Patient p = pda.searchNumber(smsInboxCursor.getString(indexAddress));
                if(p != null)
                    smslog.add(str);

            } while (smsInboxCursor.moveToNext());

        if (smslog != null) {

            aa = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, smslog);
            listview.setAdapter(aa);
        }


        return root;
    }
}
