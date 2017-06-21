/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crescer.exercicio01;

import java.util.Date;

/**
 *
 * @author usuario
 */
public class main {
    
   public static void main(String[]args){
        Exercicio01 teste = new Exercicio01();        
        Calendario calendario = new Calendario();
        Date data = new Date();        
        Date data2 = new Date(89,0,04);        
        System.out.println("string vazia : " + teste.isEmpty(""));
        System.out.println("string invertida : " + teste.inverter("rafael"));
        System.out.println("numero de vogais : " + teste.contaVogais("Rafael"));
        System.out.println("e palindromo : " + teste.isPalindromo("rafael"));
        System.out.println("e palindromo : " + teste.isPalindromo("cáác"));
        System.out.println("e palindromo : " + teste.isPalindromo("girafarig"));
        System.out.println("dia semana : "+ calendario.diaSemana(data));
        System.out.println("tempo decorido = "+ calendario.tempoDecorrido(data2));
   }    
}
