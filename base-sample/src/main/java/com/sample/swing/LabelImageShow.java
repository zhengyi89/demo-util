package com.sample.swing;

import javax.swing.*;
import java.awt.*;

/**
 * @author zhengy
 * @date 18/8/19下午4:03
 */
public class LabelImageShow  extends JTextPane {

        private JLabel labelImg = null; //用来插入图片

        public LabelImageShow() {
            super();
            initialize();
        }
        public void initialize() {
            labelImg = new JLabel(new ImageIcon("/Users/zhengy/Desktop/timg.jpeg"));
            labelImg.setBounds(new Rectangle(365, 140, 292, 376));	//指定插入的位置
            this.setSize(661, 572);
            this.setLayout(null);
            this.add(labelImg,null);
        }


}