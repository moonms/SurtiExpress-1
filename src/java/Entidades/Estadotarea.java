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
@Table(name = "estadotarea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadotarea.findAll", query = "SELECT e FROM Estadotarea e")
    , @NamedQuery(name = "Estadotarea.findByIdEstadoTarea", query = "SELECT e FROM Estadotarea e WHERE e.idEstadoTarea = :idEstadoTarea")
    , @NamedQuery(name = "Estadotarea.findByEstadoTarea", query = "SELECT e FROM Estadotarea e WHERE e.estadoTarea = :estadoTarea")})
public class Estadotarea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_EstadoTarea")
    private Integer idEstadoTarea;
    @Size(max = 45)
    @Column(name = "EstadoTarea")
    private String estadoTarea;
    @OneToMany(mappedBy = "idEstadoTarea", fetch = FetchType.LAZY)
    private List<Tarea> tareaList;

    public Estadotarea() {
    }

    public Estadotarea(Integer idEstadoTarea) {
        this.idEstadoTarea = idEstadoTarea;
    }

    public Integer getIdEstadoTarea() {
        return idEstadoTarea;
    }

    public void setIdEstadoTarea(Integer idEstadoTarea) {
        this.idEstadoTarea = idEstadoTarea;
    }

    public String getEstadoTarea() {
        return estadoTarea;
    }

    public void setEstadoTarea(String estadoTarea) {
        this.estadoTarea = estadoTarea;
    }

    @XmlTransient
    public List<Tarea> getTareaList() {
        return tareaList;
    }

    public void setTareaList(List<Tarea> tareaList) {
        this.tareaList = tareaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoTarea != null ? idEstadoTarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadotarea)) {
            return false;
        }
        Estadotarea other = (Estadotarea) object;
        if ((this.idEstadoTarea == null && other.idEstadoTarea != null) || (this.idEstadoTarea != null && !this.idEstadoTarea.equals(other.idEstadoTarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Estadotarea[ idEstadoTarea=" + idEstadoTarea + " ]";
    }
    
}
