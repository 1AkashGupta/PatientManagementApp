package com.example.chayannaskar.patientmanagement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by chayannaskar on 20/06/17.
 */

public class CallLogAccess {

    private  PatientDataAccess pda;

    public static ArrayList<CallList> getAllCallLogs(ContentResolver cr){
        String strOrder = CallLog.Calls.DATE + " DESC";
        Uri callUri = Uri.parse("content://call_log/calls");
        Cursor curCallLogs = cr.query(callUri, null, null, null, strOrder);

        ArrayList<CallList> callLists = null;
        if (curCallLogs.moveToFirst()){

            callLists = new ArrayList<>();

            do{
                String number = curCallLogs.getString(curCallLogs.getColumnIndex(CallLog.Calls.NUMBER));
                String name = curCallLogs.getString(curCallLogs.getColumnIndex(CallLog.Calls.CACHED_NAME));
                if(name == null)
                    name = "UNKNOWN";
                String time = curCallLogs.getString(curCallLogs.getColumnIndex(CallLog.Calls.DURATION));
                Log.v("dur","time "+time);
                String date = curCallLogs.getString(curCallLogs.getColumnIndex(CallLog.Calls.DATE));
                SimpleDateFormat formatter = new SimpleDateFormat(
                        "dd-MMM HH:mm");
                String dateString = formatter.format(new Date(Long
                        .parseLong(date)));
                String type = curCallLogs.getString(curCallLogs.getColumnIndex(CallLog.Calls.TYPE));
                String callType = null;

                int dircode = Integer.parseInt(type);

                if (dircode == CallLog.Calls.MISSED_TYPE){
                    callType = "MISSED";
                    CallList cList = new CallList(name, number, time, dateString, callType);
                    callLists.add(cList);
                }

            }while (curCallLogs.moveToNext());
        }

        return callLists;
    }
}
