/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.exercicio03;

import java.io.File;

/**
 * @author carloshenrique
 */
public interface SQLUtils {

    void runFile(String filename);

    String executeQuery(String query);
    
    void importCSV(File file);
    
    File importCSV(String query);

}