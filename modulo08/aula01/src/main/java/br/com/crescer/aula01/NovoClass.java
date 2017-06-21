package br.com.crescer.aula01;


import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author rafael.barreto
 */
public class NovoClass {
    public static void main(String[] args) {
        
        ArrayList<String> listaEstados = new ArrayList<>();
        
        for(Estados estado : Estados.values()){
           listaEstados.add(estado.getNome());
        }        
        
        Collections.sort(listaEstados);
        StringBuffer buffer = new StringBuffer();
        
        for(String estado : listaEstados){
           buffer.append(estado + ",");
        }         
        buffer.deleteCharAt(buffer.toString().length() -1 );        
        System.out.println(buffer);
    }
}
