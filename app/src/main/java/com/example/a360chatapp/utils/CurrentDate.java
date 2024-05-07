package com.example.a360chatapp.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class CurrentDate {

    public static String getFechaActual(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return dateFormat.format(new java.util.Date());
    }
    public static String getHoraActual(){
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        return timeFormat.format(new java.util.Date());
    }
}
