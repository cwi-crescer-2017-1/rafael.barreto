/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.exercicio02;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author usuario
 */
public class ReaderUtilsImp implements ReaderUtils {

    @Override
    public String read(String string) {
        StringBuilder texto = new StringBuilder();
        String linhaAtual;
        BufferedReader buffer = null;
        FileReader file = null;
        
        if(string.contains(".txt")){
            try{
                file = new FileReader(string);
                buffer = new BufferedReader(file);                
                
                while((linhaAtual = buffer.readLine()) != null){
                    texto.append(linhaAtual+"\n");
                }
                buffer.close();
                file.close();
            }catch(Exception e){
                System.out.println(e);
            }
        }
        return texto.toString();
    }    
}
