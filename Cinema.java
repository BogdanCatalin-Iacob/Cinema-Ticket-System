package com.bogdan.iacob;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cinema {

    private static int numRows;
    private static int seatsPerRow;
    public String cinemaName;
    private static final List<Seat> seats = new ArrayList<>();
    CinemaGUI cinemaGUI;

    public Cinema(String cinemaName, int numRows, int seatsPerRow) {
        this.numRows = numRows;
        this.seatsPerRow = seatsPerRow;
        this.cinemaName = cinemaName;
        double price;
        cinemaGUI = new CinemaGUI(this.cinemaName);


        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                price = 10;

                if ((row < 'D') && (seatNum >= 4 && seatNum <= 9)) {
                    price = 7;
                } else if ((row > 'F') || (seatNum < 4 || seatNum > 9)) {
                    price = 14;
                }

                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
                cinemaGUI.seatsPanel.add(cinemaGUI.button = new JToggleButton(row + String.format("%02d", seatNum)));
                cinemaGUI.button.setBorder(BorderFactory.createEmptyBorder());
                cinemaGUI.button.setToolTipText("" + seat.getPrice());
            }
        }
    }
    public static boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber, 0);
//        int foundSeat = 5;
        int foundSeat = Collections.binarySearch(seats, requestedSeat);
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
    }

    public static int getNumRows() {
        return numRows;
    }

    public static int getSeatsPerRow() {
        return seatsPerRow;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public static List<Seat> getSeats() {
        return seats;
    }
}
