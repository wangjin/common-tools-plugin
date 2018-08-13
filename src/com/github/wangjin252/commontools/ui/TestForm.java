package com.github.wangjin252.commontools.ui;

import javax.swing.*;

public class TestForm extends JFrame {
    private JButton confirmButton;
    private JPanel panel;
    private JButton cancelButton;

    public TestForm() {

        this.setSize(400, 400);
        this.setContentPane(panel);
        this.setLocationRelativeTo(null);


        confirmButton.addActionListener(e -> {
            System.out.println("点击了确定按钮");
        });


        cancelButton.addActionListener(e -> {
            System.out.println("点击了取消按钮");
        });
    }
}
