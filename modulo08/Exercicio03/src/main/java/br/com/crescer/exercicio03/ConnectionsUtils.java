/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.exercicio03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rafael.barreto
 */
public final class ConnectionsUtils {
        
        private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
        private static final String USER = "AULAJAVA";
        private static final String PASS = "AULAJAVA";


    public static Connection getConnection() throws SQLException {        
       return DriverManager.getConnection(URL,USER,PASS);         
    }
}