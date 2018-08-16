/*
 * Created by JFormDesigner on Wed Aug 15 17:48:23 CST 2018
 */

package com.github.wangjin252.commontools.ui;

import com.github.wangjin252.commontools.entity.Pom;
import com.github.wangjin252.commontools.entity.Table;
import com.github.wangjin252.commontools.util.PomUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Vector;

/**
 * @author WangJin
 */
public class CodeGeneratorForm extends JPanel {
    public CodeGeneratorForm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        entityTable = new JTable();
        panel3 = new JPanel();
        label7 = new JLabel();
        basePackage = new JTextField();
        label8 = new JLabel();
        controllerPackage = new JTextField();
        servicePackage = new JTextField();
        label9 = new JLabel();
        label10 = new JLabel();
        repositoryPackage = new JTextField();
        label11 = new JLabel();
        entityPackage = new JTextField();

        //======== this ========

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(entityTable);
        }

        //======== panel3 ========
        {

            //---- label7 ----
            label7.setText("\u4e3b\u5305");
            label7.setHorizontalAlignment(SwingConstants.RIGHT);

            //---- label8 ----
            label8.setText("Controller");
            label8.setHorizontalAlignment(SwingConstants.RIGHT);

            //---- controllerPackage ----
            controllerPackage.setText("web");

            //---- servicePackage ----
            servicePackage.setText("service");

            //---- label9 ----
            label9.setText("Service");
            label9.setHorizontalAlignment(SwingConstants.RIGHT);

            //---- label10 ----
            label10.setText("Repository");
            label10.setHorizontalAlignment(SwingConstants.RIGHT);

            //---- repositoryPackage ----
            repositoryPackage.setText("domain");

            //---- label11 ----
            label11.setText("Entity");
            label11.setHorizontalAlignment(SwingConstants.RIGHT);

            //---- entityPackage ----
            entityPackage.setText("domain");

            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel3Layout.createParallelGroup()
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addComponent(label10, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(repositoryPackage, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(label11, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(entityPackage, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGroup(panel3Layout.createParallelGroup()
                                    .addComponent(label8, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label7, GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel3Layout.createParallelGroup()
                                    .addComponent(basePackage, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addComponent(controllerPackage, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                        .addComponent(label9, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(servicePackage, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())
            );
            panel3Layout.setVerticalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(basePackage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label7))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label8)
                            .addComponent(servicePackage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label9)
                            .addComponent(controllerPackage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label10)
                            .addComponent(label11)
                            .addComponent(entityPackage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(repositoryPackage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11))
            );
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup()
                        .addComponent(scrollPane1)
                        .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable entityTable;
    private JPanel panel3;
    private JLabel label7;
    private JTextField basePackage;
    private JLabel label8;
    private JTextField controllerPackage;
    private JTextField servicePackage;
    private JLabel label9;
    private JLabel label10;
    private JTextField repositoryPackage;
    private JLabel label11;
    private JTextField entityPackage;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public void initBasePackage(String basePath) {

        Pom pom = null;
        try {
            pom = PomUtil.parse(basePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (pom != null) {
            this.basePackage.setText(pom.getGroupId() + "." + pom.getArtifactId().replaceAll("-",""));
        }

    }

    public void initTable(List<Table> tableList) {

        Vector<String> columnVector = new Vector<>();
        columnVector.add("选择");
        columnVector.add("表名");

        Vector<Vector<String>> dataVector = new Vector<>();

        for (Table table : tableList) {
            Vector<String> tableVector = new Vector<>();
            tableVector.add("");
            tableVector.add(table.getName());
            dataVector.add(tableVector);
        }


        DefaultTableModel defaultTableModel = new DefaultTableModel(dataVector, columnVector);

        this.entityTable.setModel(defaultTableModel);
    }
}
