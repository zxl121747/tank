package com.tank;

import java.awt.*;
import java.util.Random;

import com.tank.ResourceMgr;

public class Tank {
    public static int WIDTH = ResourceMgr.tankU.getWidth();
    public static int HEIGHT = ResourceMgr.tankU.getHeight();
    public int x, y;
    private static final int SPEED = 2;
    private Dir dir = Dir.NULL;
    private boolean moving = true;
    private Bullet bullet;
    private TankFrame fm;
    private boolean living = true;
    Group group;
    Random random = new Random();

    public Tank(int x, int y, Dir dir, TankFrame fm,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.fm = fm;
        this.group = group;
    }

    public void paint(Graphics g) {
        if (!living){
            fm.tanks.remove(this);
        }
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
        if (this.group == Group.BAD){
            if(random.nextInt(10) > 10) this.fire();
        }
    }

    public void fire() {
        System.out.println(this.group);
        int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        fm.bullets.add(new Bullet(bX, bY, dir,fm,this.group));
        if(this.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
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

    public void die() {
        this.living = false;
    }
}
