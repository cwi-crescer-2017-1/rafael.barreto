/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.exercicio02;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author usuario
 */
public class WriterUtilsImp implements WriterUtils {

    @Override
    public void write(String file, String conteudo) {
        File arquivo = new File(file);        
        BufferedWriter buffer = null;
        
        if(file.contains(".txt")){
            try{
                buffer = new BufferedWriter(new FileWriter(arquivo));
                buffer.write(conteudo);
                buffer.flush();
                buffer.close();
                System.out.println("gravado");
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
}
