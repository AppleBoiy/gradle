package com.example.app;

import java.awt.*;

public class Paddle {
    private int x;
    private final int y, width, height, speed;

    public Paddle(int x, int y, int width, int height, int speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    public void moveLeft() {
        x -= speed;
        if (x < 0) {
            x = 0;
        }
    }

    public void moveRight(int screenWidth) {
        x += speed;
        if (x + width > screenWidth) {
            x = screenWidth - width;
        }
    }

    public void draw(Graphics g) {
        g.fillRect(x, y, width, height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
