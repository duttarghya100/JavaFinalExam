package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Thu Aug 06 16:18:05 PDT 2020
 */



/**
 * @author Arghya Dutta
 */
public class practice extends JFrame {
    public practice() {
        initComponents();
    }

    private void m1ItemStateChanged(ItemEvent e) {
        if(e.getSource() == m1)
        {
            imageLabel.setIcon(new ImageIcon(new ImageIcon("c1.jpg").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
        }
        else if(e.getSource() == m2)
        {
            imageLabel.setIcon(new ImageIcon(new ImageIcon("c2.jpg").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
        }
        else if(e.getSource() == m3)
        {
            imageLabel.setIcon(new ImageIcon(new ImageIcon("c3.jpg").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
        }
    }

    private void compBtnActionPerformed(ActionEvent e) {
        int days = Integer.parseInt(daysTxt.getText());
        double total=0;
        if (m1.isSelected())
        {
            total=14*days;
        }
        else if(m2.isSelected())
        {
            total=12*days;
        }
        else
            total=10*days;
       /* if (days>=6 && days>=10)
            total=total*0.92;
        else if(days>10)
            total*=0.85;

        */
        totallbl.setText(String.valueOf(total));
       // totallbl.setText(String.format("%2.f",total));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Arghya Dutta
        custName = new JLabel();
        custTxt = new JTextField();
        days = new JLabel();
        daysTxt = new JTextField();
        label1 = new JLabel();
        imageLabel = new JLabel();
        pic = new JLabel();
        m1 = new JRadioButton();
        m2 = new JRadioButton();
        m3 = new JRadioButton();
        sCitizen = new JRadioButton();
        mem = new JRadioButton();
        totallbl = new JLabel();
        compBtn = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
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
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- custName ----
        custName.setText("Customer Name:");
        custName.setFont(custName.getFont().deriveFont(custName.getFont().getStyle() | Font.BOLD));
        contentPane.add(custName, "cell 0 0");

        //---- custTxt ----
        custTxt.setColumns(20);
        contentPane.add(custTxt, "cell 2 0");

        //---- days ----
        days.setText("No. of DAys:");
        days.setFont(days.getFont().deriveFont(days.getFont().getStyle() | Font.BOLD));
        contentPane.add(days, "cell 0 1");

        //---- daysTxt ----
        daysTxt.setColumns(20);
        contentPane.add(daysTxt, "cell 2 1");
        contentPane.add(label1, "cell 0 2");
        contentPane.add(imageLabel, "cell 0 2");
        contentPane.add(pic, "cell 0 3");

        //---- m1 ----
        m1.setText("Model1");
        m1.addItemListener(e -> m1ItemStateChanged(e));
        contentPane.add(m1, "cell 2 3");

        //---- m2 ----
        m2.setText("Model2");
        m2.addItemListener(e -> m1ItemStateChanged(e));
        contentPane.add(m2, "cell 2 3");

        //---- m3 ----
        m3.setText("Model3");
        m3.addItemListener(e -> m1ItemStateChanged(e));
        contentPane.add(m3, "cell 3 3");

        //---- sCitizen ----
        sCitizen.setText("Senior Citizen");
        contentPane.add(sCitizen, "cell 2 5");

        //---- mem ----
        mem.setText("Membership");
        contentPane.add(mem, "cell 2 5");

        //---- totallbl ----
        totallbl.setText("Total");
        contentPane.add(totallbl, "cell 0 8");

        //---- compBtn ----
        compBtn.setText("Compute");
        compBtn.addActionListener(e -> compBtnActionPerformed(e));
        contentPane.add(compBtn, "cell 3 8 3 1");
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(m1);
        buttonGroup1.add(m2);
        buttonGroup1.add(m3);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Arghya Dutta
    private JLabel custName;
    private JTextField custTxt;
    private JLabel days;
    private JTextField daysTxt;
    private JLabel label1;
    private JLabel imageLabel;
    private JLabel pic;
    private JRadioButton m1;
    private JRadioButton m2;
    private JRadioButton m3;
    private JRadioButton sCitizen;
    private JRadioButton mem;
    private JLabel totallbl;
    private JButton compBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
