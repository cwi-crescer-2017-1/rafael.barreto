/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.exercicio02;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 *
 * @author usuario
 */
public class FileUtisImp implements FileUtis {

    @Override
    public boolean mk(String string) {
        if(string.contains(".")){
            try{
               new File(string).createNewFile();
               System.out.println("arquivo criado");
            }catch(Exception e){
                System.out.println(e);             
            }
            return true;
        }else{
            new File(string).mkdir();            
            System.out.println("diretorio criado");
            return false;
        }
    }

    @Override
    public boolean rm(String string) {
        File arquivo = new File(string);
        if(arquivo.isDirectory()){
            System.out.println("Diretorio nao pode ser removido");
            return false;
        }else{
            arquivo.delete();
            return true;
        }        
    }

    @Override
    public String ls(String string) {
        StringBuilder lista = new StringBuilder();
        File arquivo = new File(string);      
        File[] files = arquivo.listFiles();
        
        if(arquivo.isDirectory()){
            for(File file : files){
                lista.append(file.getName()+"\n");
            }
            return lista.toString();
        }else{
            return arquivo.getAbsolutePath();
        }       
    }
    

    @Override
    public boolean mv(String in, String out) {
        File arquivo = new File(in);
        
        if(arquivo.isDirectory()){
            System.out.println("diretorio nao pode ser movido");
            return true;
        }else{
            try{
                Files.move(arquivo.toPath(),Paths.get(out, arquivo.getName()), REPLACE_EXISTING);
                return false;
            }catch(Exception e){
                System.out.println("e");
                return false;
            }
        }                
    }    
}
