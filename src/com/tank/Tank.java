package com.tank;

import java.awt.*;
import com.tank.ResourceMgr;

public class Tank {
    private int x, y;
    private static final int SPEED = 5;
    private Dir dir = Dir.NULL;
    private boolean moving;
    private Bullet bullet;
    private TankFrame fm;
    public static int WIDTH = ResourceMgr.tankU.getWidth();
    public static int HEIGHT = ResourceMgr.tankU.getHeight();

    public Tank(int x, int y, Dir dir, TankFrame fm) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.fm = fm;
    }

    public void paint(Graphics g) {
        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.tankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD,x,y,null);
                break;
        }
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
        int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        fm.bullets.add(new Bullet(bX, bY, dir,fm));
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
