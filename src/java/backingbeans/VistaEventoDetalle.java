/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import java.util.Date;
import jpa.Evento;

/**
 *
 * @author malex
 */
public class VistaEventoDetalle {
    private Date fechaIn;
    private Date fechaFin;
    private String nombre;
    private String descripcion;
    private String imagen;
    private String sitio;
    private String tag;
    private String video;
    private float precioEntradas;
    private String urlCompraEntrada;
    

    public VistaEventoDetalle(Evento ev) {
        this.fechaIn = ev.getSesionesCelebradas().get(0).getFechaInicio();
        this.fechaFin = ev.getSesionesCelebradas().get(0).getFechaFin();
        this.nombre = ev.getNombre();
        this.descripcion = ev.getDescripcion();
        this.imagen = ev.getFoto();
        this.sitio = ev.getLocalizacion().getNombre();
        this.tag = ev.getTag();
        this.video = ev.getVideo();
        this.precioEntradas = ev.getSesionesCelebradas().get(0).getPrecio();
        this.urlCompraEntrada = ev.getSesionesCelebradas().get(0).getUrlCompraEntrada();
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

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public float getPrecioEntradas() {
        return precioEntradas;
    }

    public void setPrecioEntradas(float precioEntradas) {
        this.precioEntradas = precioEntradas;
    }

    public String getUrlCompraEntrada() {
        return urlCompraEntrada;
    }

    public void setUrlCompraEntrada(String urlCompraEntrada) {
        this.urlCompraEntrada = urlCompraEntrada;
    }
    
}
