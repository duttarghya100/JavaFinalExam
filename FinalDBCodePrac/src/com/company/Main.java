package com.company;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
	// write your code here
        Employee ob = new Employee();
        ob.setVisible(true);
        ob.PopulateTable();
        ob.updateTable();
    }
}
