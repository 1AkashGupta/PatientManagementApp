package com.example.chayannaskar.patientmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by chayannaskar on 16/06/17.
 */

public class Tab3Patlist extends Fragment {

    private ListView listView;
    private PatientDataAccess pda;
    private ArrayList<Patient> pal;
    private PatientListAdapter pla;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View root =inflater.inflate(R.layout.tab3patlist, container, false);



        listView = (ListView) root.findViewById(R.id.lvpatlist);
        pda = new PatientDataAccess(getActivity(), 1);
        pal = pda.getAllPatients();
        if (pal != null) {
            pla = new PatientListAdapter(getActivity(), pal);


            listView.setAdapter(pla);
        }

        return root;
    }
}
