package com.example.collapsingtoolbar;

public class Employee_Model {


    String eNAme;
    String eNumber;


    public Employee_Model(String eNAme, String eNumber) {
        this.eNAme = eNAme;
        this.eNumber = eNumber;
    }


    public String geteNAme() {
        return eNAme;
    }

    public void seteNAme(String eNAme) {
        this.eNAme = eNAme;
    }

    public String geteNumber() {
        return eNumber;
    }

    public void seteNumber(String eNumber) {
        this.eNumber = eNumber;
    }
}


