package com.example.chayannaskar.patientmanagement;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * A placeholder fragment containing a simple view.
 */
public class SearchActivityFragment extends Fragment {

    public SearchActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_search, container, false);
        root.findViewById(R.id.btnsearch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etname = (EditText) root.findViewById(R.id.etname);
                String name = etname.getText().toString().trim();
                Intent intent = new Intent(getContext(), ResultActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });
        return root;
    }
}
