/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import org.python.util.PythonInterpreter;
/**
 *
 * @author KhanhDzai - https://www.facebook.com/khanhdepzai.pro/
 */
public class Main {

    public static void main(String[] args) {
        long st = System.currentTimeMillis();
        // Tạo PythonInterpreter để chạy mã Python
        PythonInterpreter interpreter = new PythonInterpreter();

         System.out.println("time prepare: " + (System.currentTimeMillis() -st) + " ms");
        
        // Chạy mã Python trực tiếp
        interpreter.exec("print('Hello from Python!')");

        // Sử dụng mã Python phức tạp hơn, ví dụ tính toán
        interpreter.exec("def add(a, b): return a + b");

        // Gọi hàm Python từ Java và lấy kết quả
        interpreter.set("x", 5);
        interpreter.set("y", 10);
        interpreter.exec("result = add(x, y)");

        // Lấy kết quả trả về từ Python
        int result = interpreter.get("result", Integer.class);
        System.out.println("Result from Python: " + result);

        // Đóng interpreter khi hoàn thành
        interpreter.close();
    }
}
