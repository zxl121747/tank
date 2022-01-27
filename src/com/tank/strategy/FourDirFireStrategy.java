package com.tank.strategy;

import com.tank.Bullet;
import com.tank.Dir;
import com.tank.GameModel;
import com.tank.Tank;
import com.tank.decorator.RectDecorator;
import com.tank.decorator.TailDecorator;

public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = t.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;

        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            GameModel.getInstance().gameObjects.add(new RectDecorator(new TailDecorator(new Bullet(t.x, t.y, dir, t.group))));
        }

        //if(t.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }
}
