
import com.sun.jna.Library;
import com.sun.jna.Native;
import model.Human;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author KhanhDzai - https://www.facebook.com/khanhdepzai.pro/
 */
public interface MyLib extends Library {

    public static final MyLib INSTANCE = Native.load("bin/example.dll", MyLib.class); // Tải thư viện C

    public void helloWorld();

    /**
     * Lưu ý: Object truyền vào phải cùng kiểu dữ liệu với object bên mã C++
     *
     * @param human
     */
    public void handleHuman(Human human);
}
