/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.controller;

import br.com.crescer.social.entidade.Post;
import br.com.crescer.social.entidade.Usuario;
import br.com.crescer.social.service.PostService;
import br.com.crescer.social.service.UsuarioService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    PostService postService;

    @GetMapping
    public Map<String, Object> listarUsuarios(Authentication authentication) {
        User u = Optional.ofNullable(authentication)
                .map(Authentication::getPrincipal)
                .map(User.class::cast)
                .orElse(null);
        final HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("dados", u);
        return hashMap;
    }
    
    @GetMapping("/{email}")
    public Map usuarioLogado(@PathVariable("email") String email){
        return service.buscarUsuarioLogado(email);
    }

    @PostMapping("/novo")
    public void cadastrar(@RequestBody Usuario u) {
        service.novoUsuario(u);
    }

    @PostMapping("/post")
    public void postar(@RequestBody Post post) {
        postService.postar(post);
    }

    @GetMapping("/buscarpostagens")
    public List buscarPostagem() {
        List<Post> posts = postService.buscarPostagem();
        return posts;
    }
}
