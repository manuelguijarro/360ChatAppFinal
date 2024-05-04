package com.example.a360chatapp.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordController {
    public static boolean comprobarPassword(String passwordUsuario) {
        if (!passwordUsuario.isEmpty()){

            String expresionRegex = "^(?=.*[A-Z])(?=.*[!@#$%^&*()-+=<>?]).{8,}$";
            Pattern pattern = Pattern.compile(expresionRegex);
            Matcher matcher = pattern.matcher(passwordUsuario);
            return matcher.matches();

        }else
            return false;

    }
}
