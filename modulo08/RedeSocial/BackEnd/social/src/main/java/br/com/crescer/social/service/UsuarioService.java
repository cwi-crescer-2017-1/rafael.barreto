/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.service;

import br.com.crescer.social.entidade.Usuario;
import br.com.crescer.social.repositorio.UsuarioRepositorio;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author rafael.barreto
 */
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepositorio repositorio;

    public Usuario novoUsuario(Usuario u) {
        u.setSenha(new BCryptPasswordEncoder().encode(u.getSenha()));
        return repositorio.save(u);
    }

    public Usuario buscarUsuario(long id) {
        return repositorio.findOne(id);
    }

    public Usuario buscarPorEmail(String email) {
        return repositorio.findOneByEmail(email);
    }

    public List<Usuario> listarUsuario() {
        return (List<Usuario>) repositorio.findAll();
    }

    public Map buscarUsuarioLogado(String email) {
        Usuario u = repositorio.findOneByEmail(email);
        Map<String, Object> map = new HashMap<>();

        map.put("nome", u.getNome());
        map.put("foto", u.getFoto());
        map.put("id", u.getUsuarioIdId());

        return map;
    }
}
