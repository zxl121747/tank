package com.tank.cor;

import com.tank.GameObject;

/**
 * 碰撞检测的接口
 */
public interface Collider {
    /**
     * @param o1
     * @param o2
     * @return 是否继续执行下一个碰撞器, 因为判断碰撞之后,当前的gameobj 死亡就不需要继续检测
     */
    boolean collide(GameObject o1, GameObject o2);
}
