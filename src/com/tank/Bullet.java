package com.tank;

import java.awt.*;

/**
 * 子弹
 */
public class Bullet {
    private int x, y;
    private static final int SPEED = 10;
    private Dir dir = Dir.NULL;
    private static int WIDTH = 10;
    private static int HEIGHT = 10;
    private boolean live = true;
    private TankFrame fm;

    public Bullet(int x, int y, Dir dir,TankFrame fm) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.fm = fm;
    }

    public void paint(Graphics g) {
        if (!live){
            fm.bullets.remove(this);
        }
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(c);
        move();
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
        if ( x<0 || x> TankFrame.GAME_WIDTH || y<0 || y> TankFrame.GAME_HEIGHT) live = false;
    }
}
