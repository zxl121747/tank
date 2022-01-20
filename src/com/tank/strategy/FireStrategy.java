package com.tank.strategy;

import com.tank.Bullet;
import com.tank.Tank;

public interface FireStrategy {
    default void fire(Tank tank) {
        int bX = tank.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = tank.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tank.gm.gameObjects.add(new Bullet(bX, bY, tank.dir, tank.group, tank.gm));
        //if(this.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }
}