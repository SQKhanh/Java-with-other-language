// data/js/src/util.js

function hello() {
    console.log("Hello từ util.js!");
}

function getName() {
    return "getName trả về từ util nè hehe";
}
 

// Xuất các hàm sử dụng CommonJS
module.exports = {
    hello,
    getName
};
