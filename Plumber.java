package com.company;

public class Plumber extends Worker {

    private double plumbingCost;

    public Plumber(String firstName, String lastName, Address address, int idNum, double workedHours, double hourlyRate) {
        super(firstName, lastName, address, idNum, workedHours, hourlyRate);

    }

    @Override
    public String toString() {
        return "Plumber" + super.toString() + "\n "+ doWork() + "\n";
    }

    @Override
    public double calculatePay() {
        return workedHours * hourlyRate + plumbingCost;
    }

    @Override
    public String doWork() {
        return " Complete plumbing work";
    }

    public void setPlumbingCost(double plumbingCost) {
        this.plumbingCost = plumbingCost;
    }
}
