package org.example;

import org.example.view.MainJFrame;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException, ClassNotFoundException {
        MainJFrame.createGUI();
    }
}
