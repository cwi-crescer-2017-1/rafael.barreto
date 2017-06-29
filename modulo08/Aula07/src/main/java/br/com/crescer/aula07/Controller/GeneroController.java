/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula07.Controller;

import br.com.crescer.aula07.entidades.Genero;
import br.com.crescer.aula07.sevices.GeneroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rafael.barreto
 */

@RestController
@RequestMapping("/genero")
public class GeneroController {
    
    @Autowired
    GeneroService service;
    
    @GetMapping
    public List<Genero> ListarGenero(){
        return service.ListarGenero();
    }    
}
