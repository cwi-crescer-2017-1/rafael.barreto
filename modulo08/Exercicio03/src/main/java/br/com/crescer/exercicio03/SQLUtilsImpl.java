/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.exercicio03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author usuario
 */
public class SQLUtilsImpl implements SQLUtils {

    @Override
    public void runFile(String filename) {

        try {
            Reader reader = new FileReader(filename);
            BufferedReader bufferReader = new BufferedReader(reader);
            String texto = null;
            StringBuffer buffer = new StringBuffer();

            while ((texto = bufferReader.readLine()) != null) {
                buffer.append(texto);
            }
            System.out.println(buffer.toString());

            try (final Statement statement = ConnectionsUtils.getConnection().createStatement();
                    final ResultSet resultSet = statement.executeQuery(buffer.toString())) {
                System.out.println("comando gravado no banco");
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public String executeQuery(String query) {
        try (final Statement statement = ConnectionsUtils.getConnection().createStatement();
                final ResultSet resultSet = statement.executeQuery(query)) {
            return "comando executado";
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
            return null;
        }
    }

    @Override
    public void importCSV(File file) {

    }

    @Override
    public File importCSV(String query) {

        return null;
    }
}
