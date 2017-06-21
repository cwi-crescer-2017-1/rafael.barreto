/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crescer.exercicio01;

/**
 *
 * @author usuario
 */
public class Exercicio01 implements StringUtils {

    @Override
    public boolean isEmpty(String string) {
       
        if(string.trim().isEmpty() || string == null){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String inverter(String string) {
    
        StringBuffer buffer = new StringBuffer();        
        buffer.append(string);
        buffer.reverse();
        return buffer.toString();
    }

    @Override
    public int contaVogais(String string) {
        
        String vogais ="aeiou";
        int tamanhoString = string.length();
        int numeroVogais = 0;
        
        for (int i = 0 ; i < tamanhoString ; i++){
            if(vogais.indexOf(string.toCharArray()[i]) >= 0){
                numeroVogais++;
            }
        }        
        return numeroVogais;
    }

    @Override
    public boolean isPalindromo(String string) {       
        String palavraInvertida = inverter(string);
        boolean palindromo = palavraInvertida.equals(string);            
        return palindromo;
    }
    
}
