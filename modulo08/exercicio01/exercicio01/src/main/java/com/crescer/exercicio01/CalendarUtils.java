/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crescer.exercicio01;

import java.util.Date;

/**
 * @author carloshenrique
 */
public interface CalendarUtils {

    public enum DiaSemana {
        DOMINGO,
        SEGUNDA_FEIRA,
        TERCA_FEIRA,
        QUARTA_FEIRA,
        QUINTA_FEIRA,
        SEXTA_FEIRA,
        SABADO;
    }

    DiaSemana diaSemana(Date date);

    String tempoDecorrido(Date date);

}
