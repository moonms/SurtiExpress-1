/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author farfa
 */
@Entity
@Table(name = "estadoplanilla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadoplanilla.findAll", query = "SELECT e FROM Estadoplanilla e")
    , @NamedQuery(name = "Estadoplanilla.findByIdEstadoPlanilla", query = "SELECT e FROM Estadoplanilla e WHERE e.idEstadoPlanilla = :idEstadoPlanilla")
    , @NamedQuery(name = "Estadoplanilla.findByEstadoPlanilla", query = "SELECT e FROM Estadoplanilla e WHERE e.estadoPlanilla = :estadoPlanilla")})
public class Estadoplanilla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_EstadoPlanilla")
    private Integer idEstadoPlanilla;
    @Size(max = 45)
    @Column(name = "EstadoPlanilla")
    private String estadoPlanilla;
    @OneToMany(mappedBy = "idEstadoPlanilla", fetch = FetchType.LAZY)
    private List<Planilla> planillaList;

    public Estadoplanilla() {
    }

    public Estadoplanilla(Integer idEstadoPlanilla) {
        this.idEstadoPlanilla = idEstadoPlanilla;
    }

    public Integer getIdEstadoPlanilla() {
        return idEstadoPlanilla;
    }

    public void setIdEstadoPlanilla(Integer idEstadoPlanilla) {
        this.idEstadoPlanilla = idEstadoPlanilla;
    }

    public String getEstadoPlanilla() {
        return estadoPlanilla;
    }

    public void setEstadoPlanilla(String estadoPlanilla) {
        this.estadoPlanilla = estadoPlanilla;
    }

    @XmlTransient
    public List<Planilla> getPlanillaList() {
        return planillaList;
    }

    public void setPlanillaList(List<Planilla> planillaList) {
        this.planillaList = planillaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoPlanilla != null ? idEstadoPlanilla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadoplanilla)) {
            return false;
        }
        Estadoplanilla other = (Estadoplanilla) object;
        if ((this.idEstadoPlanilla == null && other.idEstadoPlanilla != null) || (this.idEstadoPlanilla != null && !this.idEstadoPlanilla.equals(other.idEstadoPlanilla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Estadoplanilla[ idEstadoPlanilla=" + idEstadoPlanilla + " ]";
    }
    
}
