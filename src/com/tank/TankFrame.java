package com.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    private int x = 200;
    private int y = 200;

    public TankFrame() {
        this.setResizable(false);
        this.setSize(800, 600);
        this.setTitle("tank");
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
    }
}
