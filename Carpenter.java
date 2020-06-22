package com.company;

public class Carpenter extends Worker {

    private double lumberCost;

    public Carpenter(String firstName, String lastName, Address address, int idNum, double workedHours, double hourlyRate) {
        super(firstName, lastName, address, idNum, workedHours, hourlyRate);

    }

    @Override
    public String toString() {
        return "Carpenter: " +super.toString() + "\n" + doWork();
    }

    @Override
    public double calculatePay() {
        return workedHours * hourlyRate + lumberCost;
    }

    @Override
    public String doWork() {
        return " Complete carpentry work";
    }

    public void setLumberCost(double lumberCost) {
        this.lumberCost = lumberCost;
    }
}
