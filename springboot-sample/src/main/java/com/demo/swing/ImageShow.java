package com.demo.swing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author zhengy
 * @date 18/8/19下午2:37
 */
public class ImageShow extends JFrame {



    public ImageShow() {
        Image image  = null;
        try {
            image = ImageIO.read(new File("/Users/zhengy/Desktop/timg.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        MyPanel mp = new MyPanel(image, 0, 0, 100, 100);
        this.add(mp);
        MyPanel mp2 = new MyPanel(image, 0, 100, 100, 100);
        MyPanel mp3 = new MyPanel(image, 0, 200, 100, 100);

        this.add(mp2);
        this.add(mp3);
        this.setSize(550, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ImageShow();
    }
}








class MyPanel extends JPanel {
    int x;
    int y;
    int width;
    int height;
    private Image img;

    MyPanel(Image img, int x, int y, int width, int height){
        System.out.println("init "+x+y);
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void paint(Graphics g) {
        try {
            System.out.println("begin draw"+x+y);
            g.drawImage(img, x, y, width, height, null);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}