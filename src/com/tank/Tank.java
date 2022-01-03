package com.tank;

import java.awt.*;

public class Tank {
    private int x, y;
    private static final int SPEED = 5;
    private Dir dir = Dir.NULL;
    private boolean moving;
    private Bullet bullet;
    private TankFrame fm;

    public Tank(int x, int y, Dir dir, TankFrame fm) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.fm = fm;
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 50, 50);
        g.setColor(c);
        move();
    }

    private void move() {
        if (!moving) return;
        switch (dir) {
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            default:
                break;
        }
    }

    public void fire() {
        fm.bullet = new Bullet(x, y, dir);
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }
}
