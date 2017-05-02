/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import jpa.Sitio;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author malex
 */
@ManagedBean(name="creacionEvento")
@RequestScoped
public class CreacionEvento {
    private String nombreEvento;
    private String imagenEvento;
    private Sitio sitio;
    private String urlVideo;
    private String urlVentaEntradas;
    private String tag;
    private String precio;
    private String descripcion;
    private Date fecha;
    private List<Date> fechas;
    
    
    @PostConstruct
    public void init() {
        fechas = new ArrayList<>();
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getImagenEvento() {
        return imagenEvento;
    }

    public void setImagenEvento(String imagenEvento) {
        this.imagenEvento = imagenEvento;
    }

    public Sitio getSitio() {
        return sitio;
    }

    public void setSitio(Sitio sitio) {
        this.sitio = sitio;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public String getUrlVentaEntradas() {
        return urlVentaEntradas;
    }

    public void setUrlVentaEntradas(String urlVentaEntradas) {
        this.urlVentaEntradas = urlVentaEntradas;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public void cambioFecha(SelectEvent ev) {
        Date fecha = (Date) ev.getObject();
        this.setFecha(fecha);
    }
    
    public void incluyeFecha(){
        this.fechas.add(fecha);
    }

    public Date getFecha() {
        return fecha;
    }

    public List<Date> getFechas() {
        return fechas;
    }

    
    
}
