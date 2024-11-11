// car.cpp
#include "car.h"
#include <iostream>

// Constructor
Car::Car(std::string make, std::string model, int year) {
    this->make = make;
    this->model = model;
    this->year = year;
}

// Display function
void Car::displayInfo() {
    std::cout << "Car make: " << make << ", model: " << model << ", year: " << year << std::endl;
}
