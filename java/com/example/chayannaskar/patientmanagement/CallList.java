package com.example.chayannaskar.patientmanagement;

/**
 * Created by chayannaskar on 20/06/17.
 */

public class CallList {
    private String name;
    private String number;
    private String time;
    private String date;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CallList(String name, String number, String time, String date, String type) {
        this.name = name;
        this.number = number;
        this.time = time;
        this.date = date;
        this.type = type;
    }

    public CallList() {
    }
}

