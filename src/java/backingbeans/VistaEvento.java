/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import jpa.Evento;
import jpa.Sesion;

/**
 *
 * @author malex
 */

@ManagedBean
@ApplicationScoped
public class VistaEvento implements Serializable {
    private Date fechaIn;
    private Date fechaFin;
    private String nombre;
    private String descripcion;
    private String imagen;
    private String sitio;
    private String tag;

    public VistaEvento(Evento ev) {
        this.fechaIn = ev.getSesionesCelebradas().get(0).getFechaInicio();
        this.fechaFin = ev.getSesionesCelebradas().get(0).getFechaFin();
        this.nombre = ev.getNombre();
        this.descripcion = ev.getDescripcion();
        this.imagen = ev.getFoto();
        this.sitio = ev.getLocalizacion().getNombre();
        this.tag = ev.getTag();
    }
    
    
    public Date getFechaIn() {
        return fechaIn;
    }

    public void setFechaIn(Date fechaIn) {
        this.fechaIn = fechaIn;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    
    
}