package com.sample.swing;

import javax.swing.*;
import java.awt.*;

/**
 * @author zhengy
 * @date 18/8/20上午11:25
 */
public class JpanelShow {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Frame With Panel");
        Container contentPane = frame.getContentPane();
        contentPane.setBackground(Color.CYAN); // 将JFrame实例背景设置为蓝绿色
        JPanel panel = new JPanel(); // 创建一个JPanel的实例
        panel.setBackground(Color.yellow); // 将JPanel的实例背景设置为黄色
        JButton button = new JButton("Press me");
        panel.add(button); // 将JButton实例添加到JPanel中

        contentPane.add(panel, BorderLayout.SOUTH); // 将JPanel实例添加到JFrame的南侧
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

}