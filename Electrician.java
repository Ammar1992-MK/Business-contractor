package com.company;

public class Electrician extends Worker {

    private double wiringCost;

    public Electrician(String firstName, String lastName, Address address, int idNum, double workedHours, double hourlyRate) {
        super(firstName, lastName, address, idNum, workedHours, hourlyRate);

    }

    @Override
    public String toString() {
        return "Electrician: " + super.toString() + "\n " + doWork();
    }

    @Override
    public double calculatePay() {
        return workedHours * hourlyRate + wiringCost;
    }

    @Override
    public String doWork() {
        return " Install electrical components ";
    }

    public void setWiringCost(double wiringCost) {
        this.wiringCost = wiringCost;
    }
}
