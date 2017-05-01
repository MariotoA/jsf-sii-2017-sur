/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import jpa.Sitio;

/**
 *
 * @author malex
 */
@ManagedBean
@ApplicationScoped
public class SitioClicado {
    private Sitio sit;

    public Sitio getSit() {
        return sit;
    }

    private void setSit(Sitio sit) {
        this.sit = sit;
    }
    
    public String clicaYEnvia(Sitio sit) {
        this.setSit(sit);
        return "sitioDetalle.xhtml";
    }
    
    public String getEventosCelebrados() {
        return sit==null? null : sit.getEventosCelebrados().get(0).getNombre()
                + " " + 
                sit.getEventosCelebrados().get(0)
                        .getSesionesCelebradas().get(0).getFechaInicio();
    }
}
