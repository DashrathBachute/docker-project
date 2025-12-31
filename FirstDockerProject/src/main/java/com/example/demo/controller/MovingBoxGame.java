package com.example.demo.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MovingBoxGame extends JPanel implements ActionListener, KeyListener {

    private int x = 200;
    private int y = 200;
    private final int BOX_SIZE = 40;
    private final int SPEED = 5;

    private Timer timer;

    public MovingBoxGame() {
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(this);

        timer = new Timer(20, this); // game loop
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillRect(x, y, BOX_SIZE, BOX_SIZE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // repaint continuously
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (y > 0) y -= SPEED;
                break;
            case KeyEvent.VK_DOWN:
                if (y < getHeight() - BOX_SIZE) y += SPEED;
                break;
            case KeyEvent.VK_LEFT:
                if (x > 0) x -= SPEED;
                break;
            case KeyEvent.VK_RIGHT:
                if (x < getWidth() - BOX_SIZE) x += SPEED;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Moving Box Game");
        frame.add(new MovingBoxGame());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
