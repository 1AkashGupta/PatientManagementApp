package com.example.chayannaskar.patientmanagement;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by chayannaskar on 16/06/17.
 */

public class Tab2Call extends Fragment {

    private ListView lv;
    private ArrayList<CallList> callList, finalclist;
    private PatientDataAccess pda;
    private CallLogAdapter cla;
    private Patient p;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View root =inflater.inflate(R.layout.tab2call, container, false);
        callList = new ArrayList<>();
        finalclist = new ArrayList<>();
        callList = CallLogAccess.getAllCallLogs(getContext().getContentResolver());
        if (callList != null) {
            pda = new PatientDataAccess(getContext(), 1);
            for (int i = 0; i < callList.size(); i++) {
                CallList c = callList.get(i);
                Log.v("calllist ", " : " + c.getNumber());
                p = pda.searchNumber(c.getNumber());
                Log.v("calllist ", " i: ");
                if (p != null) {
                    finalclist.add(c);
                    Log.v("calllist ", " success");

                }


            }

            cla = new CallLogAdapter(getActivity(), finalclist);


            lv = (ListView) root.findViewById(R.id.lv);
            lv.setAdapter(cla);
        }



        return root;
    }
}
