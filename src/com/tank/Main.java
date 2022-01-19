package com.tank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();

        while (true) {
            Thread.sleep(25);
            tankFrame.repaint();
            //System.out.println(tankFrame.bullets.size());
        }
    }
}
