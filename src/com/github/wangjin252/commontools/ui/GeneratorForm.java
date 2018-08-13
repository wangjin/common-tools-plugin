package com.github.wangjin252.commontools.ui;

import javax.swing.*;

public class GeneratorForm extends JFrame {
    private JButton generateButton;
    private JPanel mainPanel;
    private JButton button1;
    private JTextField textField1;
    private JTextField controllerTextField;
    private JTextField serviceTextField;
    private JTextField domainTextField;
    private JTextField domainTextField1;
    private JTextField basePackageTextField;
    private JTextField controllerPackageTextField;
    private JTextField servicePackageTextField;
    private JTextField repositoryPackageTextField;
    private JTextField entityPackageTextField;

    public GeneratorForm() {

        this.setTitle("生成代码");
        this.setSize(400, 400);
        this.setContentPane(mainPanel);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

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
}
