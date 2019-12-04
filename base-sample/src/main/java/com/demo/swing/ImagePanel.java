package com.demo.swing;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ImagePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private Image img;

    int x;
    int y;
    int width;
    int height;

    public ImagePanel(Image img, int x, int y, int width, int height) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        BufferedImage bufferedImage = toBufferedImage(img);
        setSize(bufferedImage.getWidth(), bufferedImage.getHeight());
    }

    public BufferedImage toBufferedImage(Image image) {
        if (image instanceof BufferedImage) {
            return (BufferedImage) image;
        }
        image = new ImageIcon(image).getImage();
        boolean hasAlpha = false;
        BufferedImage bimage = null;
        GraphicsEnvironment ge = GraphicsEnvironment
                .getLocalGraphicsEnvironment();
        try {
            int transparency = Transparency.OPAQUE;
            if (hasAlpha) {
                transparency = Transparency.BITMASK;
            }
            GraphicsDevice gs = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gs.getDefaultConfiguration();
            bimage = gc.createCompatibleImage(image.getWidth(null),
                    image.getHeight(null), transparency);
        } catch (HeadlessException e) {
        }
        if (bimage == null) {
            int type = BufferedImage.TYPE_INT_RGB;
            if (hasAlpha) {
                type = BufferedImage.TYPE_INT_ARGB;
            }
            bimage = new BufferedImage(image.getWidth(null),
                    image.getHeight(null), type);
        }
        Graphics g = bimage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return bimage;
    }

    @Override
    public void paint(Graphics g) {
        if (img != null){
            g.drawImage(img, x, y, width, height, this);
        }
        else{
            g.clearRect(0, 0, getSize().width, getSize().height);
        }
    }

    public static void main(String[] args) {
        JFrame j = new JFrame();
        Image image = null;
        Image image1 = null;
        try {
            image = ImageIO.read(new File("/Users/zhengy/Desktop/timg.jpeg"));
            image1 = ImageIO.read(new File("/Users/zhengy/Desktop/timages/1.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImagePanel i = new ImagePanel(image, 0, 0 , 100, 100);
        ImagePanel i1 = new ImagePanel(image1, 100, 0 , 100, 100);
        j.add(i);
        j.add(i1);

        j.setSize(550, 400);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);

    }
}
