package com.github.wangjin252.commontools.ui;

import com.github.wangjin252.commontools.entity.Pom;

import javax.swing.*;

public class GeneratorForm extends JFrame {

    private Pom pom;

    private JButton generateButton;
    private JPanel mainPanel;
    private JTextField basePackageTextField;
    private JTextField controllerPackageTextField;
    private JTextField servicePackageTextField;
    private JTextField repositoryPackageTextField;
    private JTextField entityPackageTextField;
    private JTextField dbAddressTextField;
    private JTextField dbNameTextField;
    private JTextField dbUserNameTextField;
    private JTextField dbPasswordTextField;
    private JList entityList;
    private JButton parseEntityButton;
    private JTextField textField1;

    public GeneratorForm(Pom pom) {

        this.pom = pom;

        this.setTitle("生成代码");
        this.setSize(400, 400);
        this.setContentPane(mainPanel);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);


        if (pom != null) {
            basePackageTextField.setText(pom.getGroupId() + "." + pom.getArtifactId());
        }


        parseEntityButton.addActionListener((e) -> {

        });

        generateButton.addActionListener((e) -> {
            System.out.println(basePackageTextField.getText());
            System.out.println(controllerPackageTextField.getText());
            System.out.println(servicePackageTextField.getText());
            System.out.println(repositoryPackageTextField.getText());
            System.out.println(entityPackageTextField.getText());


        });


    }

    public JButton getGenerateButton() {
        return generateButton;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JTextField getBasePackageTextField() {
        return basePackageTextField;
    }

    public JTextField getControllerPackageTextField() {
        return controllerPackageTextField;
    }

    public JTextField getServicePackageTextField() {
        return servicePackageTextField;
    }

    public JTextField getRepositoryPackageTextField() {
        return repositoryPackageTextField;
    }

    public JTextField getEntityPackageTextField() {
        return entityPackageTextField;
    }


    public static void main(String[] args) {
        new GeneratorForm(null);
    }
}
