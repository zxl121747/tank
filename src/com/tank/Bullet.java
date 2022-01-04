package com.tank;

import java.awt.*;

/**
 * 子弹
 */
public class Bullet {
    private int x, y;
    private static final int SPEED = 10;
    private Dir dir = Dir.NULL;
    private boolean live = true;
    private TankFrame fm;
    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();

    public Bullet(int x, int y, Dir dir, TankFrame fm) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.fm = fm;
    }

    public void paint(Graphics g) {
        if (!live) {
            fm.bullets.remove(this);
        }
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
        }
        g.drawImage(ResourceMgr.bulletL, x, y, null);
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
        if (x < 0 || x > TankFrame.GAME_WIDTH || y < 0 || y > TankFrame.GAME_HEIGHT) live = false;
    }
}
