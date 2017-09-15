package com.example.chayannaskar.patientmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by chayannaskar on 19/06/17.
 */

public class PatientDataAccess extends SQLiteOpenHelper {
    public PatientDataAccess(Context context, int version) {
        super(context, "mydb", null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table Patients (phoneno text PRIMARY KEY, name text, affliction text, lastcheckup text, criticalpriorty int)");
        //db.execSQL("insert into Patients (phoneno, name, affliction, lastcheckup, criticalpriorty) values ('+918584038798','Chayan Naskar','Fever','22-02-2017',1)");

        Log.v("Creation successful","insert success");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ArrayList<Patient> getAllPatients(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select phoneno, name, affliction, lastcheckup, criticalpriorty from Patients", null);
        c.moveToFirst();
        ArrayList<Patient> plist = null;
        if (c.moveToFirst()){
            plist = new ArrayList<>();
            do{
                //String phone, String name, String affliction, String date, int criticalpriorty
                Patient patient = new Patient(c.getString(0),c.getString(1),c.getString(2),c.getString(3),c.getInt(4));
                plist.add(patient);

            }while (c.moveToNext());
        }
        db.close();
        return plist;
    }

    public void createNewPatient(Patient p){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("phoneno", p.getPhone());
        cv.put("name", p.getName());
        cv.put("affliction", p.getAffliction());
        cv.put("lastcheckup", p.getDate());
        cv.put("criticalpriorty", p.getCriticalpriorty());
        db.insert("Patients", null, cv);
        db.close();

    }

    public Patient searchPatient(String name){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select phoneno, name, affliction, lastcheckup, criticalpriorty from Patients where name=?", new String[] {name});
        if (c.moveToFirst()) {
            Patient patient = new Patient(c.getString(0), c.getString(1), c.getString(2), c.getString(3), c.getInt(4));

            db.close();
            return patient;
        }else{
            return null;
        }
    }

    public Patient searchNumber(String number){
        Log.v("pda"," number: "+number);
        SQLiteDatabase db = getReadableDatabase();
        Patient p = null;
        Cursor c = db.rawQuery("select phoneno, name, affliction, lastcheckup, criticalpriorty from Patients where phoneno=?", new String[] {number});
        if (c.moveToFirst()) {
            Log.v("pda","entered");
            p = new Patient(c.getString(0), c.getString(1), c.getString(2), c.getString(3), c.getInt(4));
            db.close();

        }
            return p;

    }
}
