package com.chamodshehanka.thogaKadeServer.resource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author chamodshehanka on 11/24/2017
 * @project ThogaKadeRMIHibernate
 **/
public class DBConnection {
    public static Connection getConnection()throws ClassNotFoundException,SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost/thogaKade","root","wampwamp");
    }
}
