package com.tank.cor;

import com.tank.Bullet;
import com.tank.Explode;
import com.tank.GameObject;
import com.tank.Tank;

/**
 * 子弹和坦克的碰撞器
 */
public class BulletTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {
            Bullet b = (Bullet) o1;
            Tank t = (Tank) o2;
            if (b.group == t.group) return false;
            if (b.rect.intersects(t.rect)) {
                b.die();
                t.die();
                int eX = t.x + Tank.WIDTH / 2 - Explode.WIDTH / 2;
                int eY = t.y + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
                new Explode(eX, eY);
                return false;
            }
        } else if (o1 instanceof Tank && o2 instanceof Bullet) {
            return collide(o2, o1);
        }
        return true;
    }
}
