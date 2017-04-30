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
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import jpa.*;
/**
 *
 * @author malex
 */
@ManagedBean
@ViewScoped
public class VistaEventoGenerico implements Serializable {
    private final static String imagen = "imagen-cachorro-comprimir.jpg";
    private final static String video = "https://www.youtube.com/watch?v=6hgVihWjK2c";
    private List<Evento> eventos;
    private List<Sitio> sitios;
    @PostConstruct
    public void init() {
        Evento ev;
        Sitio sit;
        List<Sesion> ses;
        eventos = new ArrayList<>();
        sitios = new ArrayList<>();
        for (int i = 1; i < 31; i++) {
            sit = creaSitio(i);
            ev = creaEvento(sit,i);
            ses = creaSesiones(ev,i);
            sitios.add(sit);
            eventos.add(ev);
        }
    }

    public List<Sitio> getSitios() {
        return sitios;
    }

    public void setSitios(List<Sitio> sitios) {
        this.sitios = sitios;
    }

    private Sitio creaSitio(int i) {
        Sitio sit = new Sitio();
        sit.setNombre("nombreSitio"+i);
        sit.setPais("España");
        sit.setFoto(imagen);
        sit.setCiudad("Malaga");
        sit.setProvincia("Málaga");
        sit.setUrl("http://www.uma.es/");
        sit.setDireccion("Direccion"+i);
        sit.setDescripcion("Descripción genérica");
        sit.setComunidadAutonoma("Andalucia");
        return sit;
    }

    private Evento creaEvento(Sitio sit, int i) {
        Evento ev=new Evento();
        ev.setLocalizacion(sit);
        ev.setNombre("Titulo evento");
        ev.setDescripcion("Esta es la descripcion de un evento."+ i);
        ev.setFoto(imagen);
        ev.setTag("TAG: "+i);
        ev.setVideo(video);
        sit.setEventosCelebrados(eventos);
        return ev;
    }
    
   

    private List<Sesion> creaSesiones(Evento ev, int i) {
        List<Sesion> ses = new ArrayList<>();
        Sesion sesi= new Sesion();
        sesi.setEventoCelebrado(ev);
        Date fechaInicio = new Date();
        sesi.setFechaInicio(fechaInicio);
        Date fechaFin = fechaInicio;
        sesi.setFechaFin(fechaFin);
        sesi.setUrlCompraEntrada("www.uma.es");
        sesi.setPrecio(i);
        ses.add(sesi);        
        return ses;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    
}
