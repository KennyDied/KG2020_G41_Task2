package ru.vsu.cs.kg2020.danila;

import javax.swing.*;

public class MainWindow extends JFrame {
    private DrawPanel dp;

    public MainWindow() {
        DrawPanel dp = new DrawPanel();
        this.add(dp);
    }

}
