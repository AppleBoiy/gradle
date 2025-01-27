package com.example.app;

import java.awt.*;

public class Ball {
    private int x, y, xVelocity, yVelocity;
    private final int diameter;

    public Ball(int x, int y, int diameter, int xVelocity, int yVelocity) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }

    public void move() {
        x += xVelocity;
        y += yVelocity;
    }

    public void bounceOffWalls(int width, int height) {
        if (x <= 0 || x + diameter >= width) {
            xVelocity = -xVelocity;
        }
        if (y <= 0 || y + diameter >= height) {
            yVelocity = -yVelocity;
        }
    }

    public void bounceOffPaddle(Paddle paddle) {
        if (x + diameter >= paddle.getX() && x <= paddle.getX() + paddle.getWidth() &&
                y + diameter >= paddle.getY() && y <= paddle.getY() + paddle.getHeight()) {
            yVelocity = -yVelocity;
        }
    }

    public void draw(Graphics g) {
        g.fillOval(x, y, diameter, diameter);
    }
}
