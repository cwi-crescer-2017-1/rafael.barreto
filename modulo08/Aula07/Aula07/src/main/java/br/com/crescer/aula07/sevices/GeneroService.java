/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula07.sevices;

import br.com.crescer.aula07.entidades.Genero;
import br.com.crescer.aula07.interfaces.IGenero;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author rafael.barreto
 */

@Service
public class GeneroService {

    @Autowired            
    IGenero igenero;

    public List<Genero> ListarGenero() {
        return (List<Genero>) igenero.findAll();
    }
}
