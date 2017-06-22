/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.exercicio02;

import java.io.File;

/**
 *
 * @author usuario
 */
public class main {
    
    public static void main(String[]args){     
        FileUtisImp file = new FileUtisImp();        
        ReaderUtilsImp ler = new ReaderUtilsImp();
        System.out.println(file.ls("c:\\windows\\"));//lista pasta
        System.out.println(file.ls("c:\\windows\\win.ini"));//lista pasta
        file.mk("c:\\downloads\\teste");//cria diretorio
        file.mk("c:\\downloads\\teste.txt");//cria arquivo
        file.mv("c:\\downloads\\teste.txt", "c:\\downloads\\teste");
        System.out.println(ler.read("c:\\downloads\\teste\\teste.txt"));
    }
}
