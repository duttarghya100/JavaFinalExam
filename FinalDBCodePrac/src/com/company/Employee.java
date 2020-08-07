/*
 * Created by JFormDesigner on Fri Aug 07 12:49:43 PDT 2020
 */

package com.company;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.*;

/**
 * @author Arghya Dutta
 */
public class Employee extends JFrame {
    public Employee() throws SQLException, ClassNotFoundException {
        initComponents();
    }


//ADD


    private void addbtnActionPerformed(ActionEvent e) throws ClassNotFoundException, SQLException {
        String name=nametxt.getText();
        String empno=empnotxt.getText();
        String type="";
        Double salary=0.0;
        if(part.isSelected())
        {
            type="P";
            salary=1000.00;
        }
        else   if(full.isSelected())
        {
            type="F";
            salary=2000.00;
        }
        Class.forName("com.mysql.jdbc.Driver");
        con1 = DriverManager.getConnection("jdbc:mysql://localhost/employee", "root", "");

        if(e.getSource()==addbtn)
        {

            insert = con1.prepareStatement("Select * from emptable where number= ?");

            insert.setString(1, empno);
            ResultSet rs = insert.executeQuery();
            if(rs.isBeforeFirst()){          //res.isBeforeFirst() is true if the cursor

                JOptionPane.showMessageDialog(null,"The empno. you are trying to enter already exists ");

                nametxt.setText("");
                empnotxt.setText("");
                empnotxt.requestFocus();

                return;
            }
            insert = con1.prepareStatement("insert into emptable values(?,?,?,?)");

            insert.setString(1, name);
            insert.setString(2, empno);
            insert.setString(3, type);
            insert.setString(4, salary.toString());

            insert.executeUpdate();

            JOptionPane.showMessageDialog(null, "Record added");

            nametxt.setText("");
            empnotxt.setText("");
            empnotxt.requestFocus();

            updateTable();

        }



    }
// table row click
    private void emptableMouseClicked(MouseEvent e) {
        DefaultTableModel df = (DefaultTableModel)emptable.getModel();

        int index1 = emptable.getSelectedRow();


        nametxt.setText(df.getValueAt(index1,0).toString());

        catcode2 = nametxt.getText();
        empnotxt.setText(df.getValueAt(index1,1).toString());
    }


// EDIT

    private void editbtnActionPerformed(ActionEvent e) throws ClassNotFoundException, SQLException {
        String name=nametxt.getText();
        String empno=empnotxt.getText();
        String type="";
        Double salary=0.0;
        if(part.isSelected())
        {
            type="P";
            salary=1000.00;
        }
        else   if(full.isSelected())
        {
            type="F";
            salary=2000.00;
        }
        Class.forName("com.mysql.jdbc.Driver");
        con1 = DriverManager.getConnection("jdbc:mysql://localhost/employee", "root", "");





        insert = con1.prepareStatement("update emptable set number=?,Name=?,Type=?,Salary=? where Name =?");

        insert.setString(1, empno);
        insert.setString(2, name);
        insert.setString(3, type);
        insert.setString(4, salary.toString());
        insert.setString(5, catcode2);


        insert.executeUpdate();

        JOptionPane.showMessageDialog(null, "Record edited");

        nametxt.setText("");
        empnotxt.setText("");
        empnotxt.requestFocus();





        updateTable();


    }


// DELETE


    private void delbtnActionPerformed(ActionEvent e) throws ClassNotFoundException, SQLException {
        String name=nametxt.getText();
        String empno=empnotxt.getText();
        String type="";
        Double salary=0.0;
        if(part.isSelected())
        {
            type="P";
            salary=1000.00;
        }
        else   if(full.isSelected())
        {
            type="F";
            salary=2000.00;
        }
        Class.forName("com.mysql.jdbc.Driver");
        con1 = DriverManager.getConnection("jdbc:mysql://localhost/employee", "root", "");
        int result = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete?", "Delete",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION){

            insert = con1.prepareStatement("delete from emptable where name =?");

            insert.setString(1, catcode2);
            insert.execute();

            JOptionPane.showMessageDialog(null, "Record deleted");

            nametxt.setText("");
            empnotxt.setText("");
            empnotxt.requestFocus();

            updateTable();

        }


    }
    Connection con1;
    PreparedStatement insert;
    public String catcode2;

    private void initComponents(){
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Arghya Dutta
        name = new JLabel();
        nametxt = new JTextField();
        no = new JLabel();
        empnotxt = new JTextField();
        type = new JLabel();
        part = new JRadioButton();
        full = new JRadioButton();
        scrollPane1 = new JScrollPane();
        emptable = new JTable();
        addbtn = new JButton();
        editbtn = new JButton();
        delbtn = new JButton();

        //======== this ========
        setTitle("Employee");
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
            "[]"));

        //---- name ----
        name.setText("Enter Emp name:");
        contentPane.add(name, "cell 0 0");

        //---- nametxt ----
        nametxt.setMinimumSize(new Dimension(60, 30));
        nametxt.setColumns(20);
        contentPane.add(nametxt, "cell 2 0 4 1");

        //---- no ----
        no.setText("Enter Emp No.");
        contentPane.add(no, "cell 0 1");
        contentPane.add(empnotxt, "cell 2 1 4 1");

        //---- type ----
        type.setText("Enter Emp Type");
        contentPane.add(type, "cell 0 2");

        //---- part ----
        part.setText("Part-Time");
        contentPane.add(part, "cell 2 2");

        //---- full ----
        full.setText("Full-Time");
        contentPane.add(full, "cell 4 2");

        //======== scrollPane1 ========
        {

            //---- emptable ----
            emptable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    emptableMouseClicked(e);
                }
            });
            scrollPane1.setViewportView(emptable);
        }
        contentPane.add(scrollPane1, "cell 0 4 8 1");

        //---- addbtn ----
        addbtn.setText("ADD");
        addbtn.addActionListener(e -> {
            try {
                addbtnActionPerformed(e);
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        contentPane.add(addbtn, "cell 0 5");

        //---- editbtn ----
        editbtn.setText("EDIT");
        editbtn.addActionListener(e -> {
            try {
                editbtnActionPerformed(e);
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        contentPane.add(editbtn, "cell 1 5");

        //---- delbtn ----
        delbtn.setText("DELETE");
        delbtn.addActionListener(e -> {
            try {
                delbtnActionPerformed(e);
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        contentPane.add(delbtn, "cell 2 5");
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(part);
        buttonGroup1.add(full);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Arghya Dutta
    private JLabel name;
    private JTextField nametxt;
    private JLabel no;
    private JTextField empnotxt;
    private JLabel type;
    private JRadioButton part;
    private JRadioButton full;
    private JScrollPane scrollPane1;
    private JTable emptable;
    private JButton addbtn;
    private JButton editbtn;
    private JButton delbtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public void updateTable() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con1 = DriverManager.getConnection("jdbc:mysql://localhost/employee", "root", "");
        insert = con1.prepareStatement("Select * from emptable");
        ResultSet rs = insert.executeQuery();

        int count;

        ResultSetMetaData res = rs.getMetaData();
        count = res.getColumnCount();

        DefaultTableModel df = (DefaultTableModel) emptable.getModel();

        df.setRowCount(0);

        while (rs.next()) {
            Vector v2 = new Vector();

            for (int a = 1; a <= count; a++) {
//                v2.add(rs.getString("catcode"));
//                v2.add(rs.getString("catdesc"));
                v2.add(rs.getObject(a));


            }

            df.addRow(v2);


        }
    }
    public void PopulateTable(){


        String[] cols = {"Name", "EMP Number","Type","Salary"};
        String[][] data = {{"d1", "d1.1","d1.2","d1.3"},{"d2", "d2.1","d1.2","d1.3"},{"d3", "d3.1","d1.2","d1.3"},{"d4", "d4.1","d1.2","d1.3"}};
        DefaultTableModel model = new DefaultTableModel(data, cols);
        emptable.setModel(model);


    }
}
