#include <windows.h>
#include <iostream>
#include "src/model/car.cpp"
#include <cstdint>  // Để sử dụng int32_t

// Dùng __declspec(dllexport) để xuất khẩu các hàm
extern "C"
{
    __declspec(dllexport) void helloWorld()
    {
        std::cout << "Hello from C++ DLL!" << std::endl;

        // Tạo đối tượng car từ lớp Car
        Car myCar("Toyota", "Camry", 2022);

        // Gọi phương thức displayInfo để in thông tin xe
        myCar.displayInfo();
    }

    // Định nghĩa struct Human thay vì class để tương thích tốt hơn với JNA
    struct Human
    {
        char name[50]; // Sử dụng mảng char cố định cho tên
        int32_t age;
    };

    // Export hàm handleHuman để gọi từ Java
    __declspec(dllexport) void handleHuman(Human person)
    {
        std::cout << "Start handle human from java" << std::endl;
        std::cout << "Human name: " << person.name << std::endl;
        std::cout << "Human age: " << person.age << std::endl;
    }
}