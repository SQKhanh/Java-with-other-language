
import com.sun.jna.Library;
import com.sun.jna.Native;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author KhanhDzai - https://www.facebook.com/khanhdepzai.pro/
 */
public interface MyLib2 extends Library {

    public static final MyLib INSTANCE = Native.load("x64/Debug/lib2.dll", MyLib.class); // Tải thư viện C

}
