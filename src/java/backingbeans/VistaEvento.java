/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import jpa.Evento;
import jpa.Publicacion;
import jpa.Usuario;

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
    private Usuario us;
    private String descripcion;
    private String imagen;
    private String sitio;
    private String tag;
    private String video;
    private float precioEntradas;
    private String urlCompraEntrada;
    private int prioridad;
    private List<Publicacion> pub;
    private List<Publicacion> media;

    public VistaEvento(Evento ev) {
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
        this.pub = new ArrayList<>();
        for (int i = 0; i< 5;i++) {
        this.pub.add(new Publicacion());
        this.pub.get(i).setCreador(new Usuario());
        this.pub.get(i).getCreador().setNombre("Mariot");
        this.pub.get(i).setValoracion(5);
        this.pub.get(i).setTexto("Muy bueno");
        }
        this.media = new ArrayList<>();
        for(int i = 0; i<5;i++) {
            this.media.add(new Publicacion());
            this.media.get(i).setTitulo("Titulo "+i);
            this.media.get(i).setMultimedia(VistaEventoGenerico.IMAGEN);
        }
        this.us = ev.getCreador();
        this.prioridad = ev.getPrioridad();
    }

    public Usuario getUs() {
        return us;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public void setUs(Usuario us) {
        this.us = us;
    }

    public List<Publicacion> getMedia() {
        return media;
    }

    public void setMedia(List<Publicacion> media) {
        this.media = media;
    }

    public List<Publicacion> getPub() {
        return pub;
    }

    public void setPub(List<Publicacion> pub) {
        this.pub = pub;
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
