package com.example.demo.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SniperGame extends JPanel implements MouseMotionListener, MouseListener, ActionListener {

    private int crossX = 250;
    private int crossY = 250;

    private int targetX;
    private int targetY;
    private final int TARGET_SIZE = 40;

    private int score = 0;

    private Timer timer;
    private Random random = new Random();

    public SniperGame() {
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(Color.black);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);

        spawnTarget();
        timer = new Timer(30, this);
        timer.start();
    }

    private void spawnTarget() {
        targetX = random.nextInt(460);
        targetY = random.nextInt(460);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Target
        g.setColor(Color.red);
        g.fillOval(targetX, targetY, TARGET_SIZE, TARGET_SIZE);

        // Crosshair
        g.setColor(Color.green);
        g.drawLine(crossX - 15, crossY, crossX + 15, crossY);
        g.drawLine(crossX, crossY - 15, crossX, crossY + 15);
        g.drawOval(crossX - 10, crossY - 10, 20, 20);

        // Score
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Score: " + score, 10, 20);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        crossX = e.getX();
        crossY = e.getY();
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Rectangle target = new Rectangle(targetX, targetY, TARGET_SIZE, TARGET_SIZE);

        if (target.contains(crossX, crossY)) {
            score += 10;
            spawnTarget();
        } else {
            score -= 5;
        }
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    // Unused methods
    public void mouseDragged(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sniper Game");
        frame.add(new SniperGame());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
