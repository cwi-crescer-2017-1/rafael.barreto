/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crescer.exercicio01;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author usuario
 */
public class CalcularJuros implements Parcelator {

    @Override
    public Map<String, BigDecimal> calcular(BigDecimal valorParcelar, int numeroParcelas, double taxaJuros, Date dataPrimeiroVencimento) {
        Map<String, BigDecimal> parcelas = new HashMap<>();
        Calendar data = new GregorianCalendar();
        data.setTime(dataPrimeiroVencimento);
        
        double valorComJuros = (valorParcelar.doubleValue() * taxaJuros)+valorParcelar.doubleValue();       
        for(int i = 1 ; i <= numeroParcelas ; i++){           
           data.add(data.MONTH,1);
           parcelas.put(Integer.toString(i), new BigDecimal(valorComJuros));
        }         
        return parcelas;
    }
}
