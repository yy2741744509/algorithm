package 弹窗;/*
 *author：yangyu
 *creation time：2023/9/22 23:06
 */

import javax.swing.*;
import java.awt.*;

public class PopupWindow extends JFrame {
    public PopupWindow() {
        // 设置弹窗的大小
        setSize(300, 100);

        setLocation((int)(Math.random()*1619), (int)(Math.random()*979+1));

        // 设置弹窗的关闭操作
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 在弹窗中添加一些内容

        JLabel label = new JLabel("我想你了", JLabel.CENTER);
        label.setFont(new Font("微软雅黑", Font.BOLD, 20));
        add(label);


        // 显示弹窗
        setVisible(true);
    }

    public PopupWindow(String text){

        // 设置弹窗的大小
        setSize(1200, 700);

        setLocationRelativeTo(null);

        // 设置弹窗的关闭操作
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 在弹窗中添加一些内容
        JLabel label = new JLabel(text, JLabel.CENTER);
        Font font = new Font("微软雅黑", Font.BOLD, 35);

        label.setFont(font);
        label.setForeground(Color.red);

        add(label);

        // 显示弹窗
        setVisible(true);
    }
}
