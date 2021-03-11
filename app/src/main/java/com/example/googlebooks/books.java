package com.example.googlebooks;

public class books {

    private String t;
    private String a;
    private String sub;
    private String u;

    public books(String title, String author, String url){
        t = title;
        a = author;
        u = url;
    }

    public books(String title, String author){
        t = title;
        a = author;
    }

    public String getT() {
        return t;
    }

    public String getA() {
        return a;
    }

    public String getSub() {
        return sub;
    }

    public String getU() {
        return u;
    }
}
