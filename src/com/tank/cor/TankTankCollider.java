package com.tank.cor;

import com.tank.GameObject;
import com.tank.Tank;

public class TankTankCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        System.out.println(o1.getClass() +" "+o2.getClass());
        if(o1 instanceof Tank && o2 instanceof Tank) {
            System.out.println("1111");
            Tank t1 = (Tank)o1;
            Tank t2 = (Tank)o2;
            if(t1.rect.intersects(t2.rect)) {
                //TODO 先不处理,麻烦
                //t1.stop();
                System.out.println("stop");
            }

        }

        return true;

    }
}
