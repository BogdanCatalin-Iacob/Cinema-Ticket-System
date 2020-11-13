package bogdan.iacob;


public class Main {

    public static void main(String[] args) {
        Cinema cinema = new Cinema("NoName Cinema", 10,10);
        cinema.getSeats();
        if(cinema.reserveSeat("H11")){
            System.out.println("Make a payment");
        }else{
            System.out.println("Seat not available");
        }

    }
}
