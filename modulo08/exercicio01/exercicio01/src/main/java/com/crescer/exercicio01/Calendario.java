/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crescer.exercicio01;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author usuario
 */
public class Calendario implements CalendarUtils{

    @Override
    public DiaSemana diaSemana(Date date) {
        
        Calendar calendario = new GregorianCalendar();        
        calendario.setTime(date);
        DiaSemana diaSemana = null; 
        int dia = calendario.get(calendario.DAY_OF_WEEK);
        switch(dia){
          case Calendar.SUNDAY: diaSemana = DiaSemana.DOMINGO;
          case Calendar.MONDAY: diaSemana = DiaSemana.SEGUNDA_FEIRA;break;
          case Calendar.TUESDAY: diaSemana = DiaSemana.TERCA_FEIRA;break;
          case Calendar.WEDNESDAY: diaSemana = DiaSemana.QUARTA_FEIRA;break;
          case Calendar.THURSDAY: diaSemana = DiaSemana.QUINTA_FEIRA;break;
          case Calendar.FRIDAY: diaSemana = DiaSemana.SEXTA_FEIRA;break;
          case Calendar.SATURDAY: diaSemana = DiaSemana.SABADO;break;
        }
        return diaSemana;
    }

    @Override
    public String tempoDecorrido(Date date) {         
        Calendar calendario = new GregorianCalendar();
        Calendar calendarioAtual = new GregorianCalendar();
        calendarioAtual.setTime(date);
        calendario.setTime(new Date());
        
        int dia = calendario.get(calendario.DAY_OF_MONTH) - calendarioAtual.get(calendarioAtual.DAY_OF_MONTH);
        int mes = calendario.get(calendario.MONTH) - calendarioAtual.get(calendarioAtual.MONTH);
        int ano = calendario.get(calendario.YEAR) - calendarioAtual.get(calendarioAtual.YEAR);
        String tempo = (dia+" dias "+mes+" meses "+ano+" anos ");        
        return tempo; 
    }
    
}
