/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import jpa.Usuario;

/**
 *
 * @author malex
 */

@ManagedBean(name = "login")
@SessionScoped
public class Login {
    private final static String ADMINISTRADOR="a";
    private final static String USUARIO="u";
    private final static String PERIODISTA="p";
    private final static String SUPERUSUARIO="s";
    private List<Usuario> usuarios;
    private String nombreOCorreo;
    private String contrasena;
    private String rol;
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
    
    public String autenticar() {
        Usuario us = usuarios.stream().filter(u-> 
                (u.getNombre().equals(nombreOCorreo) || u.getEmail().equals(nombreOCorreo))&&
                        u.getContraseña().equals(contrasena)).findFirst().orElse(null);
        rol = us!=null? us.getRol() : null;
        return "eventoGenerico.xhtml";
    
    }
    public String logout() {
        nombreOCorreo = null;
        contrasena = null;
        rol = null;
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        System.out.println("A");
        return "eventoGenerico.xhtml";
    
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getNombreOCorreo() {
        return nombreOCorreo;
    }

    public void setNombreOCorreo(String nombreOCorreo) {
        this.nombreOCorreo = nombreOCorreo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public boolean isLogged() {
        return rol!=null;
    }
    
}
