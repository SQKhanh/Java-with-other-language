// dllmain.cpp : Defines the entry point for the DLL application.
#include "pch.h"
#include <iostream>
BOOL APIENTRY DllMain(HMODULE hModule,
	DWORD  ul_reason_for_call,
	LPVOID lpReserved
)
{
	switch (ul_reason_for_call)
	{
	case DLL_PROCESS_ATTACH:
		std::cout << "DLL_PROCESS_ATTACH\n"; break;
	case DLL_THREAD_ATTACH:
		std::cout << "DLL_THREAD_ATTACH\n"; break;
	case DLL_THREAD_DETACH:
		std::cout << "DLL_THREAD_DETACH\n"; break;
	case DLL_PROCESS_DETACH:
		std::cout << "DLL_PROCESS_DETACH\n"; break;
	}
	return TRUE;
}

