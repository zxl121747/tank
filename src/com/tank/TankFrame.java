package com.tank;

import java.awt.*;
import java.awt.event.*;

public class TankFrame extends Frame {
    private int x = 200;
    private int y = 200;
    private int sizex = 800, sizey = 600;
    private static final int SPEED = 2;
    private Dir dir = Dir.NULL;

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
        g.fillRect(x, y, 50, 50);
        switch (dir) {
            case UP:
                y -= SPEED;
                break;
            case DOWM:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            default:
                break;
        }
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
            if (tl) dir = Dir.LEFT;
            if (tr) dir = Dir.RIGHT;
            if (tu) dir = Dir.UP;
            if (td) dir = Dir.DOWM;
        }
    }
}


