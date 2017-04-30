/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 *  @author Andriy Dachuck, Mario Alejandro Rueda Castro
 */
@Entity
public class Sesion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private float precio;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    private String urlCompraEntrada;
    
 
    /*Relaciones con Evento*/
    @ManyToOne
    @JoinColumn(nullable = false)
    private Evento eventoCelebrado;
     /*Relaciones con Interes*/
    @OneToMany(mappedBy="sesionReferida")
    private List<Interes> sesionesAlasQueSeRefiere;

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    
    
    
    
    
    

    public Evento getEventoCelebrado() {
        return eventoCelebrado;
    }

    public void setEventoCelebrado(Evento eventoCelebrado) {
        this.eventoCelebrado = eventoCelebrado;
    }

    public List<Interes> getSesionesAlasQueSeRefiere() {
        return sesionesAlasQueSeRefiere;
    }

    public void setSesionesAlasQueSeRefiere(List<Interes> sesionesAlasQueSeRefiere) {
        this.sesionesAlasQueSeRefiere = sesionesAlasQueSeRefiere;
    }
    
    
    

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

   

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

   

    public void setFechaFin(Timestamp fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getUrlCompraEntrada() {
        return urlCompraEntrada;
    }

    public void setUrlCompraEntrada(String urlCompraEntrada) {
        this.urlCompraEntrada = urlCompraEntrada;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sesion)) {
            return false;
        }
        Sesion other = (Sesion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "practicasii.Sesion[ id=" + id + " ]";
    }
    
}
