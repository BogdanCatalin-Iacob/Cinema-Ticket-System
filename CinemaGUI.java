package com.bogdan.iacob;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CinemaGUI extends JFrame implements ItemListener {

    private final int FRAME_WIDTH = 1280;
    private final int FRAME_HEIGHT = 960;
    private final int PANEL_HEIGHT = 600;
    private final int PANEL_WIDTH = 700;

    private final JFrame frame = new JFrame();
    public JPanel seatsPanel = new JPanel();
    public JToggleButton button;

    private final JLabel totalPriceLabel = new JLabel("Total price:");
    private JLabel priceLabel = new JLabel("£");

    private Font font = new Font("Arial",Font.PLAIN,26);

    public CinemaGUI(String cinemaName) {
        super(cinemaName); //I must check why value is null

        totalPriceLabel.setForeground(Color.BLACK);
        totalPriceLabel.setFont(font);
        totalPriceLabel.setBackground(Color.cyan);
        totalPriceLabel.setOpaque(true);
        totalPriceLabel.setBounds(50,250,200,30);
        frame.add(totalPriceLabel);

        priceLabel.setForeground(Color.BLACK);
        priceLabel.setFont(font);
        priceLabel.setBackground(Color.cyan);
        priceLabel.setOpaque(true);
        priceLabel.setBounds(50,290,200,30);
        frame.add(priceLabel);

        //set seatsPanel size and layout
        seatsPanel.setBounds((FRAME_WIDTH / 2) - (PANEL_WIDTH /2),250, PANEL_WIDTH, PANEL_HEIGHT);
        seatsPanel.setLayout(new GridLayout(Cinema.getNumRows(),Cinema.getSeatsPerRow(),2,2));
        seatsPanel.setBackground(Color.CYAN);
        frame.add(seatsPanel);

        //set frame size and logo
        ImageIcon logoIcon = new ImageIcon(); // I must add an image
        Image logo = logoIcon.getImage();
        frame.setLayout(null);
        frame.setIconImage(logo);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}
