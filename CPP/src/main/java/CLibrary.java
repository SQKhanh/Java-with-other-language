
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
public interface CLibrary extends Library {

    public static final CLibrary INSTANCE = Native.load("msvcrt", CLibrary.class); // Tải thư viện C

    // Khai báo hàm printf mà bạn muốn gọi
    public void printf(String format, Object... args);

}
