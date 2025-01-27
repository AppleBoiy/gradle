package com.example.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
    private final Ball ball;
    private final Paddle paddle;
    private boolean moveLeft, moveRight;

    public GamePanel() {
        ball = new Ball(400, 300, 15, 1, 1);
        paddle = new Paddle(375, 550, 100, 10, 5);
        addKeyListener(this);
        setFocusable(true);
        Timer timer = new Timer(10, this); // Timer to trigger paddle movement
        timer.start();
    }

    public void move() {
        ball.move();
        ball.bounceOffWalls(getWidth(), getHeight());
        ball.bounceOffPaddle(paddle);

        if (moveLeft) {
            paddle.moveLeft();
        }
        if (moveRight) {
            paddle.moveRight(getWidth());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.draw(g);
        paddle.draw(g);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            moveLeft = true;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moveRight = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            moveLeft = false;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moveRight = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }
}
