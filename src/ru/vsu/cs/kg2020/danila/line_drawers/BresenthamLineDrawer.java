package ru.vsu.cs.kg2020.danila.line_drawers;

import ru.vsu.cs.kg2020.danila.LineDrawer;
import ru.vsu.cs.kg2020.danila.PixelDrawer;

import java.awt.*;

public class BresenthamLineDrawer implements LineDrawer {
    private PixelDrawer pd;

    public BresenthamLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    private int sign(int x) {
        return Integer.compare(x, 0);
        //возвращает 0, если x равен нулю; -1, если x < 0 и 1, если x > 0.
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;      //проекция на x
        int dy = y2 - y1;      //проекция на y

        int incx = sign(dx);   //Определяем, в какую сторону нужно будет сдвигаться. Если dx < 0, т.е. отрезок идёт справа налево по иксу, то incx будет равен -1.
        int incy = sign(dy);   //Рисуем отрезок снизу вверх - отрицательный сдвиг для y (иначе - положительный)

        dx = Math.abs(dx);
        dy = Math.abs(dy);

        int pdx, pdy, es, el;  //Смотрим куда больше проекция - высокий или длинный отрезок и в зависимости от этого рисуем соответственно по y(высокий) или по х(длинный)
        if (dx > dy) {         //Горизонталь
            pdx = incx;
            pdy = 0;
            es = dy;
            el = dx;
        } else {               //Вертикаль
            pdx = 0;
            pdy = incy;
            es = dx;
            el = dy;
        }

        int x = x1;
        int y = y1;
        int err = el / 2;
        pd.setPixel(x, y, Color.BLACK);         //Начальная точка
        for (int t = 0; t < el; t++) {          //Идём по всем точкам, начиная со второй и до последней
            err -= es;
            if (err < 0) {
                err += el;
                x += incx;                      //Сместить вверх или вниз, если цикл идет по x
                y += incy;                      //Сместить влево-вправо, если цикл идет по y
            } else {
                x += pdx;                       //Тянуть прямую дальше (сдвинуть влево или вправо, если цикл идёт по x)
                y += pdy;                       //Сдвинуть вверх или вниз (если по y)
            }
            pd.setPixel(x, y, Color.BLACK);     //Конечная точка
        }
    }
}