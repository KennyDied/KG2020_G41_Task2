package ru.vsu.cs.kg2020.danila.line_drawers;

import ru.vsu.cs.kg2020.danila.LineDrawer;

public class BresenthamLineDrawer implements LineDrawer {
    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        double k = dy / dx;
        //double y = (x - x1) * dy / dx + y1;
        //y - y1 / y2 -y1 = x - x1 / x2 - x1;
        //F(x, y0 = (x - x1) * dy - (y - y1) * dx = 0
        // 
    }
}
