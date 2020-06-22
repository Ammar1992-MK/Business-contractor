package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Address client1 = new Address("Bjerkebakken 3d","Oslo","Østlandet","1002");
        Address client2 = new Address("Torshovveien 30","Oslo","Østlandet","3020");

        LocalDate start1 = LocalDate.parse("2019-05-14");
        LocalDate end1 =  LocalDate.parse("2019-06-04");

        Project project1 = new Project("House","Per Pedersen",client1,start1,end1);

        LocalDate start2 = LocalDate.parse("2020-01-03");
        LocalDate end2 = LocalDate.parse("2020-01-14");

        Project project2 = new Project("Lighting motion","Tina Halvorsen",client2,start2,end2);

        Address electricianAddress = new Address("Grunerløkkaveien34","Oslo","Østlandet","4032");
        Address carpenterAddress = new Address("Borgveien 3","Oslo","Østlandet","2045");
        Address plumberAddress = new Address ("Karljohansgate2","H0223","Oslo","Østlandet","4406");

            Worker electrician = new Electrician("Ahmed","Razeq",electricianAddress,101,35,200);
        Worker carpenter = new Carpenter ("Nils","Hoffman",carpenterAddress,102,29,185);
        Worker plumber = new Plumber("Hans","Randi",plumberAddress,103,25,200);

        ArrayList<Worker> workers = new ArrayList<>();

        workers.add(electrician);
        workers.add(carpenter);
        workers.add(plumber);

        ((Carpenter)carpenter).setLumberCost(2000);
        ((Electrician)electrician).setWiringCost(3200);
        ((Plumber)plumber).setPlumbingCost(2750);

        project1.addWorker(workers);
        project1.setOverheadPercent(.16);

        System.out.printf(project1.toString(), project1.getProjectName(), project1.getTotalCost() , project1.getOverHead());

        System.out.println("*************************************************\n");

        workers.remove(plumber);
        workers.remove(carpenter);

        ((Electrician)electrician).setWiringCost(150);

        workers.get(0).setWorkedHours(15);

        project2.addWorker(workers);

        System.out.printf(project2.toString(), project2.getProjectName(),
                project2.getTotalCost(), project2.getOverHead());

        if(project2.compareTo(project1) < 0){

            System.out.println("\n the " +project2.getProjectName()+" project is scheduled before "+project1.getProjectName());
        } else {

            System.out.println("\n the "+project1.getProjectName()+" project is prior to "+project2.getProjectName());
        }

        System.out.println("\n");

        project1.printPayroll();
        project2.printPayroll();

    }
}
