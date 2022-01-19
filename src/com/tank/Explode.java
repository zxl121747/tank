package com.tank;

import com.sun.org.apache.bcel.internal.generic.FMUL;

import java.awt.*;

public class Explode {
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
    private int x, y;
    private boolean living = true;
    GameModel gm = null;
    private int step = 0;

    public Explode(int x, int y, GameModel tf) {
        this.x = x;
        this.y = y;
        this.gm = tf;
        //new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        if (step >= ResourceMgr.explodes.length)
            gm.explodes.remove(this);
    }
}
