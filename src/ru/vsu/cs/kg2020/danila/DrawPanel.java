package ru.vsu.cs.kg2020.danila;

import ru.vsu.cs.kg2020.danila.line_drawers.GraphicsLineDrawer;
import ru.vsu.cs.kg2020.danila.utils.DrawUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel implements MouseMotionListener {

    private Point position = new Point(0, 0);

    public DrawPanel() {
        this.addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_BGR);
        Graphics bi_g = bi.createGraphics();
        LineDrawer ld = new GraphicsLineDrawer(bi_g);
        drawAll(ld);
        g.drawImage(bi, 0, 0, null);
        bi_g.dispose();
    }

    private void drawAll (LineDrawer ld) {
        DrawUtils.drawSnowflake(ld,200, 200, 50, 25);
        ld.drawLine(getWidth() / 2, getHeight() / 2, position.x, position.y);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        position = new Point(e.getX(), e.getY());
        repaint();
    }
}