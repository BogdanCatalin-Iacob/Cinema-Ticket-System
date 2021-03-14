package com.bogdan.iacob;

public class Main {

    public static void main(String[] args) {
        Cinema cinema = new Cinema("No Name", 10, 10);

        if (cinema.reserveSeat("D10")) {
            System.out.println("Please pay for D10");
        } else {
            System.out.println("Seat already reserved");

        }

        if (cinema.reserveSeat("D10")) {
            System.out.println("Please pay for D10");
        } else {
            System.out.println("Seat already reserved");
        }

        if (cinema.reserveSeat("B10")) {
            System.out.println("Please pay for B10");
        } else {
            System.out.println("Seat already reserved");
        }


    }

}
