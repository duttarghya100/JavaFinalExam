package com.company;

import java.sql.SQLException;

// github Link
// https://github.com/duttarghya100/JavaFinalExam
public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
	// write your code here
        Savings ob = new Savings();
        ob.setVisible(true);
        ob.updateCustTable();
        ob.PopulateTable();

    }

}
