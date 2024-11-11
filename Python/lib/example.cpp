#include <windows.h>
#include <iostream>

// Dùng __declspec(dllexport) để xuất khẩu các hàm
extern "C"
{
    __declspec(dllexport) void helloWorld()
    {
        std::cout << "Hello from C++ DLL!" << std::endl;
    }
}