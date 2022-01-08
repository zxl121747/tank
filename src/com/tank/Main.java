package com.tank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();

        for(int i=0; i<1; i++) {
            tankFrame.tanks.add(new Tank(50 + i*80, 200, Dir.DOWN, tankFrame,Group.BAD));
        }

        while (true){
            Thread.sleep(25);
            tankFrame.repaint();
            //System.out.println(tankFrame.bullets.size());
        }
    }
}
