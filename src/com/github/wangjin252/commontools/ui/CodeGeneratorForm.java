/*
 * Created by JFormDesigner on Wed Aug 15 17:48:23 CST 2018
 */

package com.github.wangjin252.commontools.ui;

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author WangJin
 */
public class CodeGeneratorForm extends JPanel {
    public CodeGeneratorForm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label3 = new JLabel();
        textField1 = new JTextField();
        label5 = new JLabel();
        textField2 = new JTextField();
        label6 = new JLabel();
        textField3 = new JTextField();
        label7 = new JLabel();
        textField4 = new JTextField();
        label1 = new JLabel();
        textField5 = new JTextField();

        //======== this ========
        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label3 ----
        label3.setText("\u4e3b\u5305");
        add(label3, "cell 0 1");
        add(textField1, "cell 1 1 3 1");

        //---- label5 ----
        label5.setText("Controller");
        add(label5, "cell 0 2");

        //---- textField2 ----
        textField2.setMinimumSize(new Dimension(100, 27));
        add(textField2, "cell 1 2");

        //---- label6 ----
        label6.setText("Service");
        add(label6, "cell 2 2");

        //---- textField3 ----
        textField3.setMinimumSize(new Dimension(100, 27));
        add(textField3, "cell 3 2");

        //---- label7 ----
        label7.setText("Repository");
        add(label7, "cell 0 3");
        add(textField4, "cell 1 3");

        //---- label1 ----
        label1.setText("Entity");
        add(label1, "cell 2 3");
        add(textField5, "cell 3 3");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label3;
    private JTextField textField1;
    private JLabel label5;
    private JTextField textField2;
    private JLabel label6;
    private JTextField textField3;
    private JLabel label7;
    private JTextField textField4;
    private JLabel label1;
    private JTextField textField5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
