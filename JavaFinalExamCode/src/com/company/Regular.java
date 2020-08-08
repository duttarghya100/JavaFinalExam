package com.company;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.intellij.uiDesigner.core.*;

public class Regular extends Savings{
    String[] cols = {"Year", "Starting","Interest","Ending Value"};
    String[][] data = {{"d1", "d1.1","d1.2","d1.3","d1.4"},{"d2", "d2.1","d2.2","d2.3","d2.4"},
            {"d3", "d3.1","d3.2","d3.3","d3.4"},{"d4", "d4.1","d4.2","d4.3","d4.4"},{"d5", "d5.1","d5.2","d5.3","d5.4"}};
    DefaultTableModel model = new DefaultTableModel(data, cols);
    int years= Integer.parseInt(yearsTxt.getText());
    double deposit= Double.parseDouble(depTxt.getText());
    String [][] Display=new String[10][4];
    double start=deposit;
    public void compute()
    {
        for (int i=0;i<years;i++)
        {
            double interest=0.10*start;

                Display[i][0]=String.valueOf(i);
                Display[i][1]=String.valueOf(start);
                Display[i][2]=String.valueOf(interest);
            Display[i][2]=String.valueOf(interest+start);
            start=interest+start;

        }
    }
       // interesttable.setModel(model);
}
