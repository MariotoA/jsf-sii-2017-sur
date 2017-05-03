/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import jpa.Publicacion;
import jpa.Sitio;
import jpa.Usuario;

/**
 *
 * @author malex
 */
@ManagedBean
@ApplicationScoped
public class SitioClicado {
    private Sitio sit;
    private List<Publicacion> media;
    
    public Sitio getSit() {
        return sit;
    }

    private void setSit(Sitio sit) {
        this.sit = sit;
    }
    @PostConstruct
    void init() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Mariot");
        usuario.setContraseña("12345678");
        usuario.setEmail("miCo@gmail.com");
        this.media=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            this.media.add(new Publicacion());
            this.media.get(i).setCreador(usuario);
            this.media.get(i).setTitulo("Hola "+i);
            this.media.get(i).setMultimedia(VistaEventoGenerico.IMAGEN);
        }
    }
    public String clicaYEnvia(Sitio sit) {
        this.setSit(sit);
        return "sitioDetalle.xhtml";
    }

    public List<Publicacion> getMedia() {
        return media;
    }

    public void setMedia(List<Publicacion> media) {
        this.media = media;
    }
    
    public String getEventosCelebrados() {
        return sit==null? null : sit.getEventosCelebrados().get(0).getNombre()
                + " " + 
                sit.getEventosCelebrados().get(0)
                        .getSesionesCelebradas().get(0).getFechaInicio();
    }
}
