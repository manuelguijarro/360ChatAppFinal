package com.example.a360chatapp.utils;

import com.google.firebase.Timestamp;

import java.text.SimpleDateFormat;

public class GeneralUtil {

    public static String timestampToString(Timestamp timestamp){
        return new SimpleDateFormat("HH:MM").format(timestamp.toDate());
    }
}
