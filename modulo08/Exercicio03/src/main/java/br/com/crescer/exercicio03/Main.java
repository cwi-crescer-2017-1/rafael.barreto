/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.exercicio03;

/**
 *
 * @author usuario
 */
public class Main {
    
    public static void main (String [] args){
        SQLUtilsImpl sql = new SQLUtilsImpl();        
        sql.runFile("C:\\downloads\\arquivo.sql");
    }
    
}
