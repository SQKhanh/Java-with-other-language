/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.sun.jna.Structure;

/**
 * 
 * @author KhanhDzai - https://www.facebook.com/khanhdepzai.pro/
 */
public class Human extends Structure {

    public byte[] name = new byte[50]; // Mảng byte cho tên
    public int age;

    @Override
    protected java.util.List<String> getFieldOrder() {
        return java.util.Arrays.asList("name", "age");
    }
}
