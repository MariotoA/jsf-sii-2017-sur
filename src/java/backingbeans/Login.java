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
import jpa.Sitio;
import jpa.Usuario;

/**
 *
 * @author malex
 */

@ManagedBean(name = "login")
@SessionScoped
public class Login {
    private final static String ADMINISTRADOR="a";
    public final static String USUARIO="USUARIO";
    public final static String PERIODISTA="PERIODISTA";
    public final static String SUPERUSUARIO="SUPERUSUARIO";
    private List<Usuario> usuarios;
    private String nombreOCorreo;
    private String contrasena;
    private String rol;
    private Usuario cuentaUsuario;
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
        this.cuentaUsuario=us;
        return "eventoGenerico.xhtml";
    
    }

    public Usuario getCuentaUsuario() {
        return cuentaUsuario;
    }

    public void setCuentaUsuario(Usuario cuentaUsuario) {
        this.cuentaUsuario = cuentaUsuario;
    }
    
    public String logout() {
        nombreOCorreo = null;
        contrasena = null;
        rol = null;
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
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
    public boolean puedeEditar(VistaEvento ev) {
        return isLogged() && (rol.equals(PERIODISTA) 
                || 
                nombreOCorreo.equals(ev.getUs().getNombre())
                || 
                nombreOCorreo.equals(ev.getUs().getEmail()));
    }
    public boolean puedeEditar(Sitio sit) {
        return isLogged() && (rol.equals(PERIODISTA) 
                || 
                nombreOCorreo.equals(sit.getCreador().getNombre())
                || 
                nombreOCorreo.equals(sit.getCreador().getEmail()));
    }
    public boolean isPeriodista() {
        return isLogged() && (rol.equals(PERIODISTA) );
    }
    
}
