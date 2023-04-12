package com.example.share.utils;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class PasswordUtil {

    public String hashPassword(String inputPassword){
        return hashing(inputPassword);
    }

    public boolean checkPassword(String inputPassword, String passwordFromDB){
        return hashing(inputPassword).equals(passwordFromDB);
    }

    private String hashing(String password){
        try{
            MessageDigest msg = MessageDigest.getInstance("MD5");
            byte[] bytes = msg.digest(password.getBytes());
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b: bytes){
                stringBuilder.append(String.format("%02x", b&0xff));
            }

            return stringBuilder.toString();
        }catch (NoSuchAlgorithmException ex){
            return "";
        }
    }
}
