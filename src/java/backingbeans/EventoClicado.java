/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import jpa.Evento;

/**
 *
 * @author malex
 */
@ManagedBean
@ApplicationScoped
public class EventoClicado {
    private VistaEvento eventoClicado;

    public VistaEvento getEventoClicado() {
        return eventoClicado;
    }
    public boolean isClicado(){
        return eventoClicado!=null;
    }
    private void setEventoClicado(VistaEvento eventoClicado) {
        this.eventoClicado = eventoClicado;
    }
    
    public String clicaYEnvia(VistaEvento eventoClicado) {
        this.setEventoClicado(eventoClicado);
        return "eventoDetalle.xhtml";
    }
}
