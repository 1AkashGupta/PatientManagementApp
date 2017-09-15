package com.example.chayannaskar.patientmanagement;

/**
 * Created by chayannaskar on 19/06/17.
 */

public class Patient {
    private String phone;
    private String name;
    private String affliction;
    private String date;
    private int criticalpriorty;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAffliction() {
        return affliction;
    }

    public void setAffliction(String affliction) {
        this.affliction = affliction;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCriticalpriorty() {
        return criticalpriorty;
    }

    public void setCriticalpriorty(int criticalpriorty) {
        this.criticalpriorty = criticalpriorty;
    }

    public Patient() {
    }

    public Patient(String phone, String name, String affliction, String date, int criticalpriorty) {
        this.phone = phone;
        this.name = name;
        this.affliction = affliction;
        this.date = date;
        this.criticalpriorty = criticalpriorty;
    }
}

