package com.tank;

import java.awt.*;

public class Tank {
    private int x,y;
    private static final int SPEED = 2;
    private Dir dir = Dir.NULL;

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
    public void paint(Graphics g){
        g.fillRect(x, y, 50, 50);
        switch (getDir()) {
            case UP:
                y -= SPEED;
                break;
            case DOWM:
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

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }
}
