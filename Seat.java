package com.bogdan.iacob;

import java.util.List;

public class Seat implements Comparable<Seat> {
    private static double price;
    private final String seatNumber;
    private boolean reserved = false;

    public Seat(String seatNumber, double price) {
        this.seatNumber = seatNumber;
        this.price = price;
    }

    @Override
    public int compareTo(Seat seat) {
        return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
    }

    public boolean reserve() {
        if (!this.reserved) {
            this.reserved = true;
            System.out.println("Seat " + seatNumber + " reserved");
            return true;
        } else {
            return false;
        }
    }

    public boolean cancel() {
        if (this.reserved) {
            this.reserved = false;
            System.out.println("Reservation of seat " + seatNumber + " cancelled");
            return true;
        } else {
            return false;
        }
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public static double getPrice() {
        return price;
    }

    public boolean isReserved() {
        return reserved;
    }

    // delete after I set prices on areas
    public static void printList(List<Seat> list) {
        for (Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber() + " £" + seat.getPrice());
        }
    }
}

