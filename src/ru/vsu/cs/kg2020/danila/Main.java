package ru.vsu.cs.kg2020.danila;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Dimension sSize = Toolkit.getDefaultToolkit ().getScreenSize ();
        mainWindow.setSize (sSize);
    }
}
