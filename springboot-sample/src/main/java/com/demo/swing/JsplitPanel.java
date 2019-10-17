package com.demo.swing;

        import javax.swing.*;

/**
 * swing 实战窗口拆分
 * Created by admin on 2017/7/10.
 */
public class JsplitPanel extends JFrame {
    private JSplitPane jSplitPane;
    private JLabel jLabel;
    private JList jList;

    public static void main(String[] args) {
        JsplitPanel jsplitPane = new JsplitPanel();
    }

    public JsplitPanel() {
        String[] words = {"Java", "Python", "Golang"};
        jLabel = new JLabel(new ImageIcon("/Users/zhengy/Desktop/timg.jpeg"));
        jLabel.setBounds(0, 0, 100, 100);
        JPanel panel = new JPanel();
//        panel.
        panel.add(jLabel);
        jList = new JList(words);
// JSplitPane 拆分窗格，垂直拆分方式
        jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jList, jLabel);
        this.add(jSplitPane);
//设置JFrame属性
        this.setTitle("工程");
        this.setLocation(500, 250);
        this.setSize(100, 100);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}