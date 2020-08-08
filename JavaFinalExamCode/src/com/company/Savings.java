/*
 * Created by JFormDesigner on Sat Aug 08 09:18:52 PDT 2020
 */

package com.company;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.intellij.uiDesigner.core.*;

/**
 * @author Arghya Dutta
 */
public class Savings extends JFrame {
    public Savings() {
        initComponents();
    }
    Connection con1;
    PreparedStatement insert;
    String[] type={"Savings-Regular","Savings-Deluxe"};
    public String catcode2; // for saving the row clicked in the table




    // ADD customer event


    private void addbtnActionPerformed(ActionEvent e) throws SQLException,ClassNotFoundException {

        String custno=noTxt.getText();
        String name = nameTxt.getText();
        double deposit=Double.parseDouble(depTxt.getText());
        int years=Integer.parseInt(yearsTxt.getText());
        String type=(String)typeGroup.getSelectedItem();
        con1 = DriverManager.getConnection("jdbc:mysql://localhost/savings", "root", "");
        insert = con1.prepareStatement("Select * from savingstable");

        if(e.getSource()==addbtn){


            insert = con1.prepareStatement("Select * from savingstable where Number= ?");
            insert.setString(1, custno);
            ResultSet rs = insert.executeQuery();
            if(rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null,"The empno. you are trying to enter already exists ");
                noTxt.setText("");
                nameTxt.setText("");
                noTxt.requestFocus();
                return;
            }
            insert = con1.prepareStatement("insert into savingstable values(?,?,?,?,?)");

            insert.setString(1, custno);
            insert.setString(2, name);
            insert.setString(3,String.valueOf(deposit));
            insert.setString(4, String.valueOf(years));
            insert.setString(5, type);

            insert.executeUpdate();

            JOptionPane.showMessageDialog(null, "Record added");

            noTxt.setText("");
            nameTxt.setText("");
            noTxt.requestFocus();
            yearsTxt.setText("");
            depTxt.setText("");
            updateCustTable();

            }


    }
// EDIT customer
    private void editbtnActionPerformed(ActionEvent e) throws SQLException, ClassNotFoundException {
        String custno=noTxt.getText();
        String name = nameTxt.getText();
        double deposit=Double.parseDouble(depTxt.getText());
        int years=Integer.parseInt(yearsTxt.getText());
        String type=(String)typeGroup.getSelectedItem();
        con1 = DriverManager.getConnection("jdbc:mysql://localhost/savings", "root", "");

        insert = con1.prepareStatement("update savingstable set Number=?,Name=?,Deposit=?,Years=?,Type of Savings=? where Number =?");

        insert.setString(1, custno);
        insert.setString(2, name);
        insert.setString(3, String.valueOf(deposit));
        insert.setString(4, String.valueOf(years));
        insert.setString(5, type);
        insert.setString(6, catcode2);


        insert.executeUpdate();
        JOptionPane.showMessageDialog(null, "Record edited");

        noTxt.setText("");
        nameTxt.setText("");
        yearsTxt.setText("");
        depTxt.setText("");
        noTxt.requestFocus();





        updateCustTable();
    }
// Deleting record
    private void delbtnActionPerformed(ActionEvent e) throws SQLException, ClassNotFoundException {
        String custno=noTxt.getText();
        String name = nameTxt.getText();
       // double deposit=Double.parseDouble(depTxt.getText());
      //  int years=Integer.parseInt(yearsTxt.getText());
       // String type=(String)typeGroup.getSelectedItem();
        con1 = DriverManager.getConnection("jdbc:mysql://localhost/savings", "root", "");

        int result = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete?", "Delete",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION){

            insert = con1.prepareStatement("delete from savingstable where Number =?");

            insert.setString(1, catcode2);
            insert.execute();

            JOptionPane.showMessageDialog(null, "Record deleted");
            noTxt.setText("");
            nameTxt.setText("");
            yearsTxt.setText("");
            depTxt.setText("");
            noTxt.requestFocus();
        updateCustTable();


        }




    }

    private void scrollPane1MouseClicked(MouseEvent e) {
        // TODO add your code here
    }
    // Table item click method
    private void savingstableMouseClicked(MouseEvent e) {
        DefaultTableModel df = (DefaultTableModel)savingstable.getModel();

        int index1 = savingstable.getSelectedRow();



        noTxt.setText(df.getValueAt(index1,0).toString());

        catcode2 = noTxt.getText();
        nameTxt.setText(df.getValueAt(index1,1).toString());
        depTxt.setText(df.getValueAt(index1,2).toString());
        yearsTxt.setText(df.getValueAt(index1,3).toString());
        String type=(String)typeGroup.getSelectedItem();
        if(type.equals("Savings-Regular")) {
            typeGroup.setSelectedIndex(0);
            Regular ob=new Regular();
            ob.compute();
        }
        else {
            typeGroup.setSelectedIndex(1);
            Deluxe ob=new Deluxe();
            ob.compute();
        }

    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Arghya Dutta
        label1 = new JLabel();
        noTxt = new JTextField();
        label2 = new JLabel();
        nameTxt = new JTextField();
        label3 = new JLabel();
        depTxt = new JTextField();
        label4 = new JLabel();
        yearsTxt = new JTextField();
        label5 = new JLabel();
        //String[] type={"Savings-Regular","Savings-Deliuxe"} ;
        String[] type={"Savings-Regular","Savings-Deliuxe"} ;
        typeGroup = new JComboBox(type);
        scrollPane1 = new JScrollPane();
        savingstable = new JTable();
        scrollPane2 = new JScrollPane();
        interesttable = new JTable();
        addbtn = new JButton();
        editbtn = new JButton();
        delbtn = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new GridLayoutManager(10, 2, new Insets(0, 0, 0, 0), -1, -1));

        //---- label1 ----
        label1.setText("Enter Customer Number");
        contentPane.add(label1, new GridConstraints(0, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- noTxt ----
        noTxt.setColumns(20);
        contentPane.add(noTxt, new GridConstraints(0, 1, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- label2 ----
        label2.setText("Enter the Customer Name");
        contentPane.add(label2, new GridConstraints(1, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- nameTxt ----
        nameTxt.setColumns(20);
        contentPane.add(nameTxt, new GridConstraints(1, 1, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- label3 ----
        label3.setText("Enter the Initial Deposit");
        contentPane.add(label3, new GridConstraints(2, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- depTxt ----
        depTxt.setColumns(20);
        contentPane.add(depTxt, new GridConstraints(2, 1, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- label4 ----
        label4.setText("Enter the number of years");
        contentPane.add(label4, new GridConstraints(3, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- yearsTxt ----
        yearsTxt.setColumns(20);
        contentPane.add(yearsTxt, new GridConstraints(3, 1, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- label5 ----
        label5.setText("Chose the type of savings");
        contentPane.add(label5, new GridConstraints(4, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));
        contentPane.add(typeGroup, new GridConstraints(4, 1, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //======== scrollPane1 ========
        {
            scrollPane1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    scrollPane1MouseClicked(e);
                    scrollPane1MouseClicked(e);
                }
            });

            //---- savingstable ----
            savingstable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    savingstableMouseClicked(e);
                }
            });
            scrollPane1.setViewportView(savingstable);
        }
        contentPane.add(scrollPane1, new GridConstraints(5, 0, 2, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(interesttable);
        }
        contentPane.add(scrollPane2, new GridConstraints(5, 1, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- addbtn ----
        addbtn.setText("add");
        addbtn.addActionListener(e -> {
            try {
                addbtnActionPerformed(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        });
        contentPane.add(addbtn, new GridConstraints(7, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- editbtn ----
        editbtn.setText("edit");
        editbtn.addActionListener(e -> {
            try {
                editbtnActionPerformed(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        });
        contentPane.add(editbtn, new GridConstraints(8, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- delbtn ----
        delbtn.setText("delete");
        delbtn.addActionListener(e -> {
            try {
                delbtnActionPerformed(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        });
        contentPane.add(delbtn, new GridConstraints(8, 1, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Arghya Dutta
    private JLabel label1;
    private JTextField noTxt;
    private JLabel label2;
    private JTextField nameTxt;
    private JLabel label3;
    public JTextField depTxt;
    private JLabel label4;
    public JTextField yearsTxt;
    private JLabel label5;
    private JComboBox typeGroup;
    private JScrollPane scrollPane1;
    private JTable savingstable;
    public JScrollPane scrollPane2;
    public JTable interesttable;
    private JButton addbtn;
    private JButton editbtn;
    private JButton delbtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public void updateCustTable() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con1 = DriverManager.getConnection("jdbc:mysql://localhost/savings", "root", "");
        insert = con1.prepareStatement("Select * from savingstable");
        ResultSet rs = insert.executeQuery();

        int count;

        ResultSetMetaData res = rs.getMetaData();
        count = res.getColumnCount();

        DefaultTableModel df = (DefaultTableModel) savingstable.getModel();

        df.setRowCount(0);

        while (rs.next()) {
            Vector v2 = new Vector();

            for (int a = 1; a <= count; a++) {
                v2.add(rs.getObject(a));


            }

            df.addRow(v2);


        }
    }

    public void PopulateTable(){


        String[] cols = {"Number", "Name","Deposit","Years","Type of Savings"};
        String[][] data = {{"d1", "d1.1","d1.2","d1.3","d1.4","d1.5"},{"d2", "d2.1","d2.2","d2.3","d2.4","d2.5"},
                {"d3", "d3.1","d3.2","d3.3","d3.4","d3.5"},{"d4", "d4.1","d4.2","d4.3","d4.4","d4.5"},{"d5", "d5.1","d5.2","d5.3","d5.4","d5.5"}};
        DefaultTableModel model = new DefaultTableModel(data, cols);
        savingstable.setModel(model);


    }





}
