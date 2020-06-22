package com.company;

public class Worker {

    public String firstName;
    public String lastName;
    public Address address;
    public int idNum;
    public double workedHours;
    public double hourlyRate;

    public Worker(String firstName, String lastName, Address address, int idNum, double workedHours, double hourlyRate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.idNum = idNum;
        this.workedHours = workedHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + "\n " +
                "compensation : $ " + calculatePay();
    }

    public String doWork(){

        return "Worker";
    }

    public void setWorkedHours(double workedHours) {
        this.workedHours = workedHours;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double calculatePay(){

        return workedHours * hourlyRate;
    }
}
