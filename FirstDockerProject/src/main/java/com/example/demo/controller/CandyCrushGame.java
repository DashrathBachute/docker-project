package com.example.demo.controller;

import java.util.Random;
import java.util.Scanner;

public class CandyCrushGame {

    static int ROWS = 6;
    static int COLS = 6;
    static int TYPES = 5; // candy types 1–5
    static int[][] board = new int[ROWS][COLS];
    static Random random = new Random();
    static int score = 0;

    public static void main(String[] args) {
        initBoard();
        Scanner sc = new Scanner(System.in);

        while (true) {
            printBoard();
            System.out.println("Score: " + score);
            System.out.println("Enter swap (r1 c1 r2 c2) or -1 to exit:");

            int r1 = sc.nextInt();
            if (r1 == -1) break;

            int c1 = sc.nextInt();
            int r2 = sc.nextInt();
            int c2 = sc.nextInt();

            swap(r1, c1, r2, c2);

            if (!crush()) {
                // invalid move
                swap(r1, c1, r2, c2);
                System.out.println("Invalid move!");
            } else {
                dropCandies();
                fillBoard();
            }
        }
        sc.close();
    }

    // Initialize board
    static void initBoard() {
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLS; j++)
                board[i][j] = random.nextInt(TYPES) + 1;
    }

    // Print board
    static void printBoard() {
        for (int[] row : board) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }

    // Swap candies
    static void swap(int r1, int c1, int r2, int c2) {
        int temp = board[r1][c1];
        board[r1][c1] = board[r2][c2];
        board[r2][c2] = temp;
    }

    // Crush matching candies
    static boolean crush() {
        boolean crushed = false;
        boolean[][] mark = new boolean[ROWS][COLS];

        // Horizontal match
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS - 2; j++) {
                int v = board[i][j];
                if (v != 0 && v == board[i][j + 1] && v == board[i][j + 2]) {
                    mark[i][j] = mark[i][j + 1] = mark[i][j + 2] = true;
                    crushed = true;
                }
            }
        }

        // Vertical match
        for (int j = 0; j < COLS; j++) {
            for (int i = 0; i < ROWS - 2; i++) {
                int v = board[i][j];
                if (v != 0 && v == board[i + 1][j] && v == board[i + 2][j]) {
                    mark[i][j] = mark[i + 1][j] = mark[i + 2][j] = true;
                    crushed = true;
                }
            }
        }

        // Remove candies
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (mark[i][j]) {
                    board[i][j] = 0;
                    score += 10;
                }
            }
        }

        return crushed;
    }

    // Drop candies
    static void dropCandies() {
        for (int j = 0; j < COLS; j++) {
            int write = ROWS - 1;
            for (int i = ROWS - 1; i >= 0; i--) {
                if (board[i][j] != 0) {
                    board[write--][j] = board[i][j];
                }
            }
            while (write >= 0) {
                board[write--][j] = 0;
            }
        }
    }

    // Fill empty cells
    static void fillBoard() {
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLS; j++)
                if (board[i][j] == 0)
                    board[i][j] = random.nextInt(TYPES) + 1;
    }
}
