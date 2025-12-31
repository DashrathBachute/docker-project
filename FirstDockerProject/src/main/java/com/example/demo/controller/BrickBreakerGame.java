package com.example.demo.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BrickBreakerGame extends JPanel implements ActionListener, KeyListener {

    private Timer timer;
    private boolean play = true;

    private int score = 0;

    private int ballX = 120;
    private int ballY = 350;
    private int ballXDir = -1;
    private int ballYDir = -2;

    private int paddleX = 310;

    private final int paddleWidth = 100;
    private final int paddleHeight = 10;

    private final int brickRows = 3;
    private final int brickCols = 7;
    private int brickWidth = 80;
    private int brickHeight = 30;
    private int[][] bricks = new int[brickRows][brickCols];

    public BrickBreakerGame() {
        initBricks();

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        timer = new Timer(8, this);
        timer.start();
    }

    private void initBricks() {
        for (int i = 0; i < brickRows; i++) {
            for (int j = 0; j < brickCols; j++) {
                bricks[i][j] = 1;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Background
        g.setColor(Color.black);
        g.fillRect(1, 1, 700, 600);

        // Draw bricks
        for (int i = 0; i < brickRows; i++) {
            for (int j = 0; j < brickCols; j++) {
                if (bricks[i][j] > 0) {
                    g.setColor(Color.orange);
                    g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);

                    g.setColor(Color.black);
                    g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                }
            }
        }

        // Borders
        g.setColor(Color.yellow);
        g.fillRect(0, 0, 3, 600);
        g.fillRect(0, 0, 700, 3);
        g.fillRect(697, 0, 3, 600);

        // Paddle
        g.setColor(Color.green);
        g.fillRect(paddleX, 550, paddleWidth, paddleHeight);

        // Ball
        g.setColor(Color.red);
        g.fillOval(ballX, ballY, 20, 20);

        // Score
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("Score: " + score, 550, 30);

        // Game Over
        if (ballY > 570) {
            play = false;
            ballXDir = 0;
            ballYDir = 0;

            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Game Over", 260, 300);
        }

        // Win
        if (score == brickRows * brickCols * 5) {
            play = false;
            g.setColor(Color.green);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("You Win!", 270, 300);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();

        if (play) {
            ballX += ballXDir;
            ballY += ballYDir;

            // Paddle collision
            if (new Rectangle(ballX, ballY, 20, 20)
                    .intersects(new Rectangle(paddleX, 550, paddleWidth, paddleHeight))) {
                ballYDir = -ballYDir;
            }

            // Brick collision
            for (int i = 0; i < brickRows; i++) {
                for (int j = 0; j < brickCols; j++) {
                    if (bricks[i][j] > 0) {
                        Rectangle brickRect = new Rectangle(
                                j * brickWidth + 80,
                                i * brickHeight + 50,
                                brickWidth,
                                brickHeight
                        );
                        Rectangle ballRect = new Rectangle(ballX, ballY, 20, 20);

                        if (ballRect.intersects(brickRect)) {
                            bricks[i][j] = 0;
                            score += 5;

                            if (ballX + 19 <= brickRect.x || ballX + 1 >= brickRect.x + brickRect.width) {
                                ballXDir = -ballXDir;
                            } else {
                                ballYDir = -ballYDir;
                            }
                            break;
                        }
                    }
                }
            }

            // Wall collision
            if (ballX < 0) ballXDir = -ballXDir;
            if (ballY < 0) ballYDir = -ballYDir;
            if (ballX > 670) ballXDir = -ballXDir;
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (paddleX >= 600) {
                paddleX = 600;
            } else {
                paddleX += 20;
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (paddleX <= 0) {
                paddleX = 0;
            } else {
                paddleX -= 20;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Brick Breaker Game");
        BrickBreakerGame game = new BrickBreakerGame();

        frame.setBounds(10, 10, 700, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.setVisible(true);
    }
}
