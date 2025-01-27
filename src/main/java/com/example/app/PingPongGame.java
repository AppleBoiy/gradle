package com.example.app;

import javax.swing.*;

public class PingPongGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ping Pong Game");
                GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setResizable(false);

        while (true) {
            gamePanel.move();
            gamePanel.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
