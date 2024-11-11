// car.h
#ifndef CAR_H
#define CAR_H

#include <string>

class Car {
private:
    std::string make;
    std::string model;
    int year;

public:
    // Constructor
    Car(std::string make, std::string model, int year);

    // Member function
    void displayInfo();
};

#endif
