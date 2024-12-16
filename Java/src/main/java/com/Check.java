/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 *
 * @author KhanhDzai - https://www.facebook.com/khanhdepzai.pro/
 */
public class Check {

    static {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
            System.setErr(new PrintStream(System.err, true, "UTF-8"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        load("/data/", "sayHello");
        load("/data2/", "DauBuoi");
    }

    static void load(String folder, String methodz) {
        try {
            String classPath = System.getProperty("user.dir") + folder;

            // Tên của class cần load (bao gồm cả package nếu có)
            String className = "com.DynamicClass";

            // Tạo đối tượng URLClassLoader
            File file = new File(classPath); // Thư mục chứa file .class
            URL[] urls = {file.toURI().toURL()};
            URLClassLoader classLoader = new URLClassLoader(urls);

            // Load class bằng tên
            Class<?> loadedClass = classLoader.loadClass(className);

            // Tạo instance của class (nếu cần)
            Object instance = loadedClass.getDeclaredConstructor().newInstance();

            // Gọi một phương thức trong class đó (ví dụ: method "sayHello")
            Method method = loadedClass.getMethod(methodz);
            method.invoke(instance); // Gọi phương thức sayHello()

            // Đóng class loader (nếu cần thiết)
            classLoader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
