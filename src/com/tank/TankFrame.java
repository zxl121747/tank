package com.tank;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {

    public static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;
    Tank myTank = new Tank(100, 100, Dir.NULL, this);
    //Bullet bullet = new Bullet(300, 300, Dir.DOWN);
    List<Bullet> bullets = new ArrayList<Bullet>();

    public TankFrame() {
        this.setResizable(false);
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
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
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }
    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
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
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
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
            } else {
                myTank.setMoving(true);
            }
            if (tl) myTank.setDir(Dir.LEFT);
            if (tr) myTank.setDir(Dir.RIGHT);
            if (tu) myTank.setDir(Dir.UP);
            if (td) myTank.setDir(Dir.DOWN);

        }
    }
}


