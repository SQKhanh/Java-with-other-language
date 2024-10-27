// data/js/main.js

// Yêu cầu các hàm từ util.js
const { hello, getName } = require('./src/util.js'); // Đường dẫn tới tệp util.js

// Gọi hàm hello từ util.js
hello(); // Gọi hàm hello đã được định nghĩa trong util.js


// Kiểm tra xem lớp java.lang.System có khả dụng hay không
function checkJavaSystem() {
    try {
        const systemClass = Java.type('java.lang.System'); // Lấy lớp System
        console.log("Java System class is available.");
        // Bạn có thể thử gọi một phương thức tĩnh từ lớp System
        console.log("Current Time: " + systemClass.currentTimeMillis());
    } catch (error) {
        console.log("Java System class is not available: ", error.message);
    }
}

// Gọi hàm kiểm tra lớp Java
checkJavaSystem();

// Hàm để liệt kê tất cả các lớp trong ngữ cảnh Polyglot
function listJavaClasses() {
    const classes = Polyglot.eval('js', `Object.keys(Java)`); // Lấy tất cả các lớp Java
    console.log("Các lớp Java có sẵn:");
    classes.forEach(className => {
        console.log(className); // In tên lớp
    });
}

// Gọi hàm liệt kê lớp
listJavaClasses();

// Tạo một hàm để gọi phương thức greet của Java
function callJavaGreet() {
    // Kiểm tra xem Polyglot có khả dụng không
    if (typeof Polyglot !== 'undefined') {
        const Check = Polyglot.import('js.Check'); // Lấy lớp Check từ Java
        if (!Check) {
            console.log("Lớp Check không tìm thấy");
            return;
        }
        if (!Check.greet) {
            console.log("Hàm greet không tìm thấy");
            return;
        }
        if (Check && Check.greet) { // Kiểm tra Check và greet có tồn tại không
            Check.greet("Xin chào từ JavaScript!"); // Gọi hàm greet của Java
        } else {
            console.log("Lớp Check hoặc hàm greet không tìm thấy.");
        }
    } else {
        console.log("Polyglot không được định nghĩa");
    }
}

// Xuất hàm getName
module.exports = {
    hello,
    getName,
    callJavaGreet
};
