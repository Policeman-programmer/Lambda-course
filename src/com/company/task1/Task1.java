package com.company.task1;

/*
Create several instances of Runnable interface with different behavior using lambda
expressions. Run these lambdas via Thread API.
 */
public class Task1 {

    public void showResult(){
        Runnable writeSomethingToDB = () -> {
            System.out.println("Something was written to DB");
        };

        Runnable informationListener = () -> {
            System.out.println("I'v got some information from another server");
        };

        new Thread(writeSomethingToDB).start();
        new Thread(informationListener).start();
        System.out.println("----------------------------------");
    }
}
