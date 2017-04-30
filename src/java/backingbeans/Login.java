/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import java.util.ArrayList;
import java.util.List;
import jpa.Usuario;

/**
 *
 * @author malex
 */
public class Login {
    private final static String ADMINISTRADOR="a";
    private final static String USUARIO="u";
    private final static String PERIODISTA="p";
    private final static String SUPERUSUARIO="s";
    List<Usuario> usuarios;
    public Login() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Mariot");
        usuario.setContraseña("12345678");
        usuario.setEmail("miCo@gmail.com");
        usuario.setRol(USUARIO);
        Usuario periodista = new Usuario();
        periodista.setNombre("Ernesti");
        periodista.setContraseña("12345678");
        periodista.setEmail("periodista@diariosur.es");
        periodista.setRol(PERIODISTA);
        Usuario superusuariu = new Usuario();
        superusuariu.setNombre("Cris");
        superusuariu.setContraseña("12345678");
        superusuariu.setEmail("crisalidaelfr@todopo.es");
        superusuariu.setRol(SUPERUSUARIO);
        usuarios = new ArrayList<>();
        usuarios.add(usuario);
        usuarios.add(periodista);
        usuarios.add(superusuariu);

    }
}
