package bogdan.iacob;

import javax.swing.*;

public class Seat extends JToggleButton implements Comparable<Seat> {

    private static String seatNumber;
    private double price;
    private boolean reserved = false;

    public Seat(String seatNumber, double price) {
        this.seatNumber = seatNumber;
        this.price = price;
    }

//    public Seat(int x, int y, int width, int height,String seatNumber, double price) {
//        super(seatNumber);
//        this.price = price;
//        setBounds(x, y, width, height);
//
////        this.gui = gui;
////        this.gui.add(this);
//        addActionListener(this);
//    }

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
            System.out.println("Reservation of seat " + seatNumber + " canceled");
            return true;
        } else {
            return false;
        }
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public int compareTo(Seat seat) {
        return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
    }

}
