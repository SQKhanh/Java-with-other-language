#include <windows.h>
#include <iostream>

// Khai báo hàm từ DLL
typedef void (*HelloWorldFunc)();

int main()
{
    // Tải DLL
    HMODULE hDll = LoadLibrary(TEXT("example.dll"));
    if (hDll != NULL)
    {
        // Lấy địa chỉ của hàm helloWorld
        HelloWorldFunc helloWorld = (HelloWorldFunc)GetProcAddress(hDll, "helloWorld");
        if (helloWorld != NULL)
        {
            // Gọi hàm từ DLL
            helloWorld();
        }
        else
        {
            std::cerr << "Không tìm thấy hàm helloWorld trong DLL!" << std::endl;
        }
        // Giải phóng DLL
        FreeLibrary(hDll);
    }
    else
    {
        std::cerr << "Không thể tải DLL!" << std::endl;
    }
    return 0;
}
