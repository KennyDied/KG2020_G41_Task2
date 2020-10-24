package ru.vsu.cs.kg2020.danila.line_drawers;

import ru.vsu.cs.kg2020.danila.LineDrawer;
import ru.vsu.cs.kg2020.danila.PixelDrawer;

import java.awt.*;

public class WuLineDrawer implements LineDrawer {
    private PixelDrawer pd;

    public WuLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    //делим число в пропорциях. Удаленность ои идеала
    double relationOfFirstPoint(double x) { return 1 - relationOfSecondPoint(x); }

    double relationOfSecondPoint(double x) {
        if (x > 0) { return x - (int)(x); }
        else if (x == 0){ return x; }
        else { return x - (int)((x) + 1); }
    }

    void drawPixel(int x, int y, double brightness) {
        int c = (int)(255 * (1 - brightness));
        pd.setPixel(x, y, new Color(0, 0, 0, c));
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        //Похоже на DDA, определяем крутизну - откуда рисовать (определяем какие линни рисовать - вертикальные(steep = true) или горизонтальные(false))
        boolean steep = Math.abs(y2 - y1) > Math.abs(x2 - x1);
        if (steep){
            int tmp = x1; x1 = y1; y1 = tmp;
            tmp = x2; x2 = y2; y2 = tmp;
        }
        if (x1 > x2){
            int tmp = x1; x1 = x2; x2 = tmp;
            tmp = y1; y1 = y2; y2 = tmp;
        }

        int dx = x2 - x1;
        int dy = y2 - y1;
        double gradient = (double)dy / (double)dx;

        int pixelX1 = x1;
        int pixelX2 = x2;
        double intersectY = y1;     //реальный y

//рисуем саму линию
        if (steep) {  //вертикально
            for (int x = pixelX1 ; x <= pixelX2 ; x++) {
                drawPixel((int)(intersectY) + 1, x, relationOfFirstPoint(intersectY));
                drawPixel((int)(intersectY), x, relationOfSecondPoint(intersectY));
                intersectY += gradient;
            }
        } else {   //горизонтально
            for (int x = pixelX1; x <= pixelX2; x++) {
                drawPixel(x, (int)(intersectY) + 1, relationOfFirstPoint(intersectY));
                drawPixel(x, (int)(intersectY), relationOfSecondPoint(intersectY));
                intersectY += gradient;
            }
        }
    }
}