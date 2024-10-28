/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package js;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

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
        long st = System.currentTimeMillis();
        // Tạo môi trường Lua
        Globals globals = JsePlatform.standardGlobals();
        System.out.println("time tạo môi trường %s ms".formatted(System.currentTimeMillis() - st));
        
        
        // Đọc nội dung file Lua
        StringBuilder luaCode = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("data/lua/main.lua"))) {
            String line;
            while ((line = br.readLine()) != null) {
                luaCode.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Nạp và chạy nội dung file Lua
        LuaValue luaScript = globals.load(luaCode.toString()); 
        
        st =System.currentTimeMillis();
        luaScript.call();
        System.out.println("time chạy code %s ms".formatted(System.currentTimeMillis() - st));

//        // Hoặc có thể truyền biến từ Java vào Lua và thực thi
//        globals.set("javaNumber", LuaValue.valueOf(10));
//        LuaValue luaScriptWithJavaValue = globals.load("print('Giá trị từ Java:', javaNumber)");
//        luaScriptWithJavaValue.call();
    }
}
