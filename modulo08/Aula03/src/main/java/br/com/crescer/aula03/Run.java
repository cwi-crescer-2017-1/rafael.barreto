/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rafael.barreto
 */
public class Run {

    public static void main(String[] args) {
        // Oracle Thin 
        // jdbc:oracle:thin:@<HOST>:<PORT>:<SID>
        // oracle.jdbc.driver.OracleDriver

        final String url = "jdbc:oracle:thin:@localhost:1521:xe";
        final String user = "AULAJAVA";
        final String pass = "AULAJAVA";
        final String query = "SELECT * FROM PAIS";
        
        try (final Connection connection = DriverManager.getConnection(url, user, pass);
             final Statement statement = connection.createStatement();
             final ResultSet resultSet = statement.executeQuery(query)){
            
            System.out.println(!connection.isClosed());
            
            while(resultSet.next()){
                System.out.println(resultSet.getString("sigla"));
            }
            
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);            
        }
    }
}
