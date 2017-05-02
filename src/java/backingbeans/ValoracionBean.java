/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author malex
 */
@ManagedBean(name="valoracionBean")
@RequestScoped
public class ValoracionBean {
    private boolean añadirComentario;

    public boolean isAñadirComentario() {
        return añadirComentario;
    }
    @PostConstruct
    public void init(){
        this.añadirComentario=true;
    }
    public void setAñadirComentario(boolean añadirComentario) {
        this.añadirComentario = añadirComentario;
    }
}
