package ru.vsu.cs.kg2020.danila;

import ru.vsu.cs.kg2020.danila.line_drawers.*;
import ru.vsu.cs.kg2020.danila.pixel_drawers.GraphicsPixelDrawer;
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
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics bi_g = bi.createGraphics();
        bi_g.setColor(Color.WHITE);
        bi_g.fillRect(0, 0, getWidth(), getHeight());
        bi_g.setColor(Color.BLACK);

        PixelDrawer pd = new GraphicsPixelDrawer(bi_g);
        LineDrawer ld = new DDALineDrawer(pd);                  //DDA
        LineDrawer ld2 = new BresenthamLineDrawer(pd);          //Bresentham
        LineDrawer ld3 = new WuLineDrawer(pd);                  //Wuuuuuu
        drawAll(ld3);

        g.drawImage(bi, 0, 0, null);
        bi_g.dispose();
    }

    private void drawAll (LineDrawer ld) {
        DrawUtils.drawSnowflake(ld,200, 300, 70, 64);
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