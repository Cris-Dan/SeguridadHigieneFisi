/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.singleton;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cristian
 */
public class DBAccess implements Serializable {
    //implementacion de Bill Pugh y luego serializable

    private static final long serialVersionUID = -7604766932017737115L;

    private DBAccess() {
    }

    private static class SingletonHelper {

        private static final DBAccess INSTANCE = new DBAccess();
    };

    public static DBAccess getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public Connection getConnection() {

        Connection cn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/seguridadhigienefisi", "root", "");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.out.println(e);
        }
        return cn;
    }

    protected Object readResolve() {
        return getInstance();
    }
}
