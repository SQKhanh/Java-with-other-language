/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package js;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

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

    public static String greet(String data) {
        System.out.println("Mã đã được gọi nè: " + data);
        return " Địt nhau auaua ???";
    }

    private static final String PATH = "data/js/"; // Đường dẫn tới thư mục chứa file JavaScript

    public static void main(String[] args) {
        String mainScriptPath = "data/js/main.js";
        // Tạo ngữ cảnh để chạy mã JavaScript
        try (Context context = Context.newBuilder("js")
                .allowIO(true) // Cho phép truy cập IO
                .allowExperimentalOptions(true) // Cho phép sử dụng các tùy chọn thử nghiệm
                .option("js.commonjs-require", "true") // Bật hỗ trợ CommonJS
                .option("js.commonjs-require-cwd", "data/js") // Thư mục gốc cho CommonJS
                .option("engine.WarnInterpreterOnly", "false") // Tắt cảnh báo
                .allowAllAccess(true)
                .out(System.out) // Chuyển hướng đầu ra của JavaScript tới console Java
                .err(System.err) // Chuyển hướng lỗi của JavaScript tới console Java
                .build()) {

            context.getBindings("js").putMember("Check", Check.class); // Xuất lớp Check

            // Tạo nguồn từ file main.js
            Source source = Source.newBuilder("js", new File(mainScriptPath)).build();
            // Thực thi file main.js
            context.eval(source);

            // Gọi hàm getName từ main.js
            Value exports = context.eval("js", "require('./main.js');"); // Lấy exports từ main.js
            Value getNameFunction = exports.getMember("getName"); // Lấy hàm getName
            String result = getNameFunction.execute().asString(); // Gọi hàm và chuyển đổi kết quả về String

            // In ra kết quả
            System.out.println(result); // In ra giá trị trả về từ getName

            // Gọi hàm callJavaGreet từ main.js
            exports = context.eval("js", "require('./main.js');"); // Lấy exports từ main.js
            Value callJavaGreetFunction = exports.getMember("callJavaGreet"); // Lấy hàm callJavaGreet
            callJavaGreetFunction.execute(); // Gọi hàm
        } catch (Exception e) {
            e.printStackTrace(); // In ra lỗi nếu có
        }
    }
}
