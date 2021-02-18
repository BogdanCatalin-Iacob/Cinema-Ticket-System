package bogdan.iacob;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import java.util.List;

public class Cinema extends JFrame implements ItemListener {

    private final String cinemaName;
    private double price;
    private static List<Seat> seats = new ArrayList<>();
    private Set<String> selectedSeats = new HashSet<>();

    private JLabel screen = new JLabel("Movie TITLE", JLabel.CENTER);
    private final JLabel selectedSeatLabel = new JLabel("Selected Seats:", JLabel.CENTER);
    private final JTextArea selectedSeatTextArea = new JTextArea("");
    private final JLabel yourSelection = new JLabel("Your Selection", JLabel.CENTER);
    private final int FRAME_WIDTH = 1280;
    private final int FRAME_HEIGHT = 960;
    private final int WIDTH = 20;
//    private final int HEIGHT = 20;
    private final int H_SPACE = 10;
    private final int V_SPACE = 10;
    private final int TOP_X = 20;
    private final int TOP_Y = 20;

    private JPanel panel = new JPanel();
    private static ImageIcon icon;
    private JToggleButton button;
    private JToolTip priceToolTip = new JToolTip();
    int numRows;
    int seatsPerRow;

    public Cinema(String cinemaName, int numRows, int seatsPerRow) {
        super(cinemaName);
        this.cinemaName = cinemaName;
        this.numRows = numRows;
        this.seatsPerRow = seatsPerRow;
//        icon = new ImageIcon("Seat.png");

        panel.setBounds(TOP_X + 300, (TOP_Y + FRAME_HEIGHT / 5 + V_SPACE), 620, 670);
        panel.setLayout(new GridLayout(numRows, seatsPerRow, 5, 5));
        panel.setBackground(Color.CYAN);


        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                if ((row <= 'C') && (seatNum < 3 || seatNum >= 8)) {
                    price = 7;
                } else if ((row <= 'D') && (seatNum > 3 && seatNum < 7)) {
                    price = 10;
                }else if(row > 'D'){
                    price = 14;
                }
                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);

                button = new JToggleButton();
                button.setBorder(BorderFactory.createEmptyBorder());
                button.setText(row + String.format("%02d", seatNum));
                button.setToolTipText("Ticket price is: " + seat.getPrice());
                button.addItemListener(this);
                panel.add(button);
            }
        }

        screen.setBounds(TOP_X, TOP_Y, (FRAME_WIDTH - (3 * WIDTH)), FRAME_HEIGHT / 5);
        screen.setBackground(Color.ORANGE);
        screen.setOpaque(true);
        screen.setForeground(Color.BLACK);

        selectedSeatLabel.setBounds(TOP_X, (screen.getHeight() + TOP_Y + 20), 100, 20 );
        add(selectedSeatLabel);

        selectedSeatTextArea.setBounds(TOP_X, (screen.getHeight() + TOP_Y + 2 * H_SPACE + selectedSeatLabel.getHeight()), 200, 60 );
        selectedSeatTextArea.setLineWrap(true);
        add(selectedSeatTextArea);
        add(yourSelection);
        add(screen);
        add(panel);

//        set frame size and logo
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        ImageIcon logoIcon = new ImageIcon("1.png");
        Image logo = logoIcon.getImage();
        setIconImage(logo);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber, price);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
    }
    public boolean cancelSeat(String seatNumber){
        int foundSeat = Collections.binarySearch(seats,seatNumber, null);
        if(foundSeat >= 0){
            return seats.get(foundSeat).cancel();
        }else{
            System.out.println("The seat is available");
            return true;
        }
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        AbstractButton button = (AbstractButton)e.getSource();
        if(button.isSelected()){
        selectedSeats.add(button.getText());
        reserveSeat(button.getText());
        }else if(!button.isSelected()){
            selectedSeats.remove(button.getText());

        }
//        selectedSeatLabel2.setText(selectedSeatLabel2.getText() + button.getText());
        selectedSeatTextArea.setText(Arrays.toString(selectedSeats.toArray()));
        System.out.println(Arrays.toString(selectedSeats.toArray()));
    }
}

