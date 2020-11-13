package bogdan.iacob;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Cinema {


    private final String cinemaName;
    private List<Seat> seats = new ArrayList<>();


    public Cinema(String cinemaName, int numRows, int seatsPerRow) {
        this.cinemaName = cinemaName;



        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                double price = 12.00;
                if((row < 'D') && (seatNum >= 4 && seatNum < 9)) {
                    price = 14.00;
                }else if((row > 'F') || (seatNum < 4 || seatNum > 9)) {
                    price = 7;
                }
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if(foundSeat >= 0){
            return seats.get(foundSeat).reserve();
        }else{
            System.out.println("There is no seat " + seatNumber);
            return false;
        }

//        for (Seat seat : seats) {
//            if (seat.getSeatNumber().equals(seatNumber)) {
//                requestedSeat = seat;
//                break;
//            }
//        }
//        if (requestedSeat == null) {
//            System.out.println("There is no seat " + seatNumber);
//            return false;
//        }
//        return requestedSeat.reserve();
    }

    public Collection<Seat> getSeats() {
        return seats;
        }
    }

