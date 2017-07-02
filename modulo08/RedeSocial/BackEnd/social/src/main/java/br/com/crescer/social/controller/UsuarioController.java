/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.entidade.Post;
import br.com.crescer.social.entidade.Usuario;
import br.com.crescer.social.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rafael.barreto
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    UsuarioService service;
    
    @GetMapping
    public List<Usuario> listarUsuario(){
        return service.listarUsuario();
    }

    @PostMapping("/novo")
    public void cadastrar(@RequestBody Usuario u) {
        service.novoUsuario(u);
    }
    
    @PostMapping("/post")
    public void postar(@RequestBody Post post){
        service.novaPostagem(post);
    }
}
