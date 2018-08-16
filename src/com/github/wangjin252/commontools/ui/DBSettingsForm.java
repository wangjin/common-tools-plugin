/*
 * Created by JFormDesigner on Wed Aug 15 16:25:53 CST 2018
 */

package com.github.wangjin252.commontools.ui;

import com.github.wangjin252.commontools.entity.DBInfo;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

/**
 * @author WangJin
 */
public class DBSettingsForm extends JPanel {
    public DBSettingsForm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        dbTypeCcomboBox = new JComboBox<>();
        label2 = new JLabel();
        ipTextField = new JTextField();
        label3 = new JLabel();
        portTextField = new JTextField();
        label6 = new JLabel();
        dbNameTextField = new JTextField();
        label4 = new JLabel();
        userNameTextField = new JTextField();
        label5 = new JLabel();
        passwordTextField = new JTextField();

        //======== this ========
        setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                        "[fill]" +
                        "[fill]",
                // rows
                "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]"));

        //---- label1 ----
        label1.setText("\u7c7b\u578b");
        add(label1, "cell 0 0,alignx right,growx 0");

        //---- dbTypeCcomboBox ----
        dbTypeCcomboBox.setModel(new DefaultComboBoxModel<>(new String[]{
                "MySQL",
                "Oracle"
        }));
        add(dbTypeCcomboBox, "cell 1 0");

        //---- label2 ----
        label2.setText("IP\u5730\u5740");
        add(label2, "cell 0 1,alignx right,growx 0");

        //---- ipTextField ----
        ipTextField.setMinimumSize(new Dimension(200, 27));
        add(ipTextField, "cell 1 1");

        //---- label3 ----
        label3.setText("\u7aef\u53e3");
        add(label3, "cell 0 2,alignx right,growx 0");
        add(portTextField, "cell 1 2");

        //---- label6 ----
        label6.setText("\u6570\u636e\u5e93\u540d");
        add(label6, "cell 0 3,alignx right,growx 0");
        add(dbNameTextField, "cell 1 3");

        //---- label4 ----
        label4.setText("\u7528\u6237\u540d");
        add(label4, "cell 0 4,alignx right,growx 0");
        add(userNameTextField, "cell 1 4");

        //---- label5 ----
        label5.setText("\u5bc6\u7801");
        add(label5, "cell 0 5,alignx right,growx 0");
        add(passwordTextField, "cell 1 5");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JComboBox<String> dbTypeCcomboBox;
    private JLabel label2;
    private JTextField ipTextField;
    private JLabel label3;
    private JTextField portTextField;
    private JLabel label6;
    private JTextField dbNameTextField;
    private JLabel label4;
    private JTextField userNameTextField;
    private JLabel label5;
    private JTextField passwordTextField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public void initValues(DBInfo dbInfo) {
        this.dbTypeCcomboBox.setSelectedItem(dbInfo.getType());
        this.ipTextField.setText(dbInfo.getIp());
        this.portTextField.setText(String.valueOf(dbInfo.getPort()));
        this.dbNameTextField.setText(dbInfo.getDbName());
        this.userNameTextField.setText(dbInfo.getUserName());
        this.passwordTextField.setText(dbInfo.getPassword());
    }

    public DBInfo getInputDBInfo() {
        DBInfo dbInfo = new DBInfo();
        dbInfo.setType(this.dbTypeCcomboBox.getSelectedItem().toString());
        dbInfo.setIp(this.ipTextField.getText());
        dbInfo.setPort(this.portTextField.getText());
        dbInfo.setDbName(this.dbNameTextField.getText());
        dbInfo.setUserName(this.userNameTextField.getText());
        dbInfo.setPassword(this.passwordTextField.getText());

        return dbInfo;
    }

}
