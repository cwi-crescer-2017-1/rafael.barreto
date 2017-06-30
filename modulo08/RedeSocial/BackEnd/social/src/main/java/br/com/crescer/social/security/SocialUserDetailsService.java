package br.com.crescer.social.security;

import br.com.crescer.social.entidade.Usuario;
import br.com.crescer.social.service.UsuarioService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author carloshenrique
 */
@Service
public class SocialUserDetailsService implements UserDetailsService {
    
    @Autowired
    UsuarioService usuarioService;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u = usuarioService.buscarPorEmail(username);
        final List<GrantedAuthority> grants = new ArrayList<>();
        
        if (u == null) {
            throw new UsernameNotFoundException("");
        }
        return new User(u.getEmail(), u.getSenha(),grants);
    }
}
