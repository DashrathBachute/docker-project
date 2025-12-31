package com.example.demo.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BallBounceGame extends JPanel implements ActionListener {

    private int x = 100;
    private int y = 100;
    private int diameter = 30;

    private int dx = 4; // x direction speed
    private int dy = 4; // y direction speed

    private Timer timer;

    public BallBounceGame() {
        this.setPreferredSize(new Dimension(500, 400));
        this.setBackground(Color.BLACK);

        timer = new Timer(20, this); // 50 FPS
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(x, y, diameter, diameter);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        x += dx;
        y += dy;

        // Bounce from left & right walls
        if (x <= 0 || x >= getWidth() - diameter) {
            dx = -dx;
        }

        // Bounce from top & bottom walls
        if (y <= 0 || y >= getHeight() - diameter) {
            dy = -dy;
        }

        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ball Bounce Game");
        frame.add(new BallBounceGame());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
