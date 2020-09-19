package ru.vsu.cs.kg2020.danila.pixel_drawers;

import ru.vsu.cs.kg2020.danila.PixelDrawer;

import java.awt.*;

public class GraphicsPixelDrawer implements PixelDrawer {
    private Graphics gr;

    public GraphicsPixelDrawer(Graphics gr) {
        this.gr = gr;
    }

    @Override
    public void setPixel(int x, int y, Color c) {
        gr.setColor(c);
        gr.fillRect(x, y,1, 1);
    }
}