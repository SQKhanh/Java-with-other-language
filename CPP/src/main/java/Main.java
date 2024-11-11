/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author KhanhDzai - https://www.facebook.com/khanhdepzai.pro/
 */
public class Main {

    static {
        System.setProperty("jna.library.path", "lib");
    }

    public static void main(String[] args) {
        // Gọi hàm printf từ thư viện C
        CLibrary.INSTANCE.printf("Hello from C: %s\n", "Hello JNA");
        MyLib.INSTANCE.helloWorld();
    }
}
