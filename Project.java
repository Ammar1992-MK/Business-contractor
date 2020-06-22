package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import java.time.LocalDate;
import java.util.ArrayList;

    public class Project implements Comparable{

        public ArrayList<Worker> workers = new ArrayList<>();

        private String projectName;
        private String customerName;
        private Address address;
        private double overheadPercent = .10;
        private double overheadAmount;
        private LocalDate startDate;
        private LocalDate endDate;

        public Project(String projectName, String customerName, Address address, LocalDate startDate, LocalDate endDate) {
            this.projectName = projectName;
            this.customerName = customerName;
            this.address = address;

            this.startDate = startDate;
            this.endDate = endDate;
        }

        public Project(String projectName, String customerName, Address address) {
            this.projectName = projectName;
            this.customerName = customerName;
            this.address = address;

        }


        public double getTotalCost(){

            return calculateProjectCost();
        }
    public void addWorker (ArrayList<Worker> workers){

            this.workers = workers;
    }

    public double calculateProjectCost(){
            double totalCost = 0;

            for( Worker w:workers){

                totalCost += w.calculatePay();
            }

            overheadAmount = totalCost * overheadPercent;
            totalCost += overheadAmount;

            return totalCost;

    }

    public double getOverHead(){

            return overheadAmount;
    }

        public String getProjectName() {
            return projectName;
        }

        public double getOverheadAmount() {
            return overheadAmount;
        }

        public void setOverheadPercent(double overheadPercent) {
            this.overheadPercent = overheadPercent;
        }

        @Override
        public int compareTo(Object o) {
            if( o instanceof Project){
                if(((Project) o).startDate.isAfter(this.startDate)){
                    return -1;
                }


            }
            return 1;
        }

        @Override
        public String toString() {
            String projectDetails;

            projectDetails = "Project name: %s" + "\nStart date: " + startDate + "\nCustomer: "+
                    customerName + "\nAddress: " + address.toString()+ "\n" +

                    "====================================\n";
           for(Worker w:workers){
               projectDetails += w.toString() + "\n\n";

           }

           projectDetails += "Project Total : $%.2f\n";
           projectDetails += "Contractor Overhead : $%.2f\n";

           return projectDetails;

        }

        public void printPayroll(){

            System.out.println("Payroll Report for project "+ getProjectName());
            System.out.println("(Salary only)");

            for(Worker w:workers){

                if( w instanceof Plumber){

                    System.out.println("Plumber :");
                } else if (w instanceof Electrician){
                    System.out.println("Electrician: ");
                } else if (w instanceof  Carpenter){
                    System.out.println("Carpenter: ");
                }
                System.out.println(w.firstName + " "+w.lastName + "\n" +
                        "ID number: " + w.idNum + "\n" +
                        w.address.toString()+ " \n " + "Hourly rate: "+ w.hourlyRate + " \n"+
                       "Worked hours: "+ w.workedHours+ " \n "+
                        "Total compensation "+ w.calculatePay() + "\n****************************\n");
            }
        }
    }

