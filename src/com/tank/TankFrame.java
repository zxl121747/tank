package com.tank;

import java.awt.*;
import java.awt.event.*;

public class TankFrame extends Frame {

    private int sizex = 800, sizey = 600;
    Tank myTank = new Tank(100, 100, Dir.NULL);

    public TankFrame() {
        this.setResizable(false);
        this.setSize(sizex, sizey);
        this.setTitle("tank war");
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setVisible(true);
        this.addKeyListener(new MyKeyListener());
    }

    @Override
    public void paint(Graphics g) {
        myTank.paint(g);
    }

    class MyKeyListener extends KeyAdapter {
        private boolean tl = false;
        private boolean tr = false;
        private boolean tu = false;
        private boolean td = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    tl = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    tr = true;
                    break;
                case KeyEvent.VK_UP:
                    tu = true;
                    break;
                case KeyEvent.VK_DOWN:
                    td = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    tl = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    tr = false;
                    break;
                case KeyEvent.VK_UP:
                    tu = false;
                    break;
                case KeyEvent.VK_DOWN:
                    td = false;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if (!tl && !tr && !tu && !td) {
                myTank.setMoving(false);
            }else {
                myTank.setMoving(true);
            }
            if (tl) myTank.setDir(Dir.LEFT);
            if (tr) myTank.setDir(Dir.RIGHT);
            if (tu) myTank.setDir(Dir.UP);
            if (td) myTank.setDir(Dir.DOWM);

        }
    }
}


