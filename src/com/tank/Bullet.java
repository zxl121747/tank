package com.tank;

import java.awt.*;

/**
 * 子弹
 */
public class Bullet extends GameObject{
    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();
    Rectangle rect = new Rectangle();
    private static final int SPEED = 6;
    private Dir dir = Dir.UP;
    private boolean living = true;
    GameModel gm = null;
    Group group = Group.BAD;

    public Bullet(int x, int y, Dir dir, Group group, GameModel fm) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.gm = fm;
        this.group = group;
        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
    }
    @Override
    public void paint(Graphics g) {
        if (!living) {
            gm.bullets.remove(this);
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
        rect.x = this.x;
        rect.y = this.y;
        if (x < 0 || x > TankFrame.GAME_WIDTH || y < 0 || y > TankFrame.GAME_HEIGHT) living = false;
    }

    public void collideWith(Tank tank) {
        if (this.group == tank.group) return;
        if (rect.intersects(tank.rect)) {
            this.die();
            tank.die();
            int eX = tank.x + Tank.WIDTH / 2 - Explode.WIDTH / 2;
            int eY = tank.y + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
            gm.explodes.add(new Explode(eX, eY, gm));
        }
    }

    private void die() {
        this.living = false;
    }
}
