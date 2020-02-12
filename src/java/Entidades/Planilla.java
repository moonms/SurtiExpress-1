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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author farfa
 */
@Entity
@Table(name = "planilla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Planilla.findAll", query = "SELECT p FROM Planilla p")
    , @NamedQuery(name = "Planilla.findByIdPlanilla", query = "SELECT p FROM Planilla p WHERE p.idPlanilla = :idPlanilla")})
public class Planilla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Planilla")
    private Integer idPlanilla;
    @ManyToMany(mappedBy = "planillaList", fetch = FetchType.LAZY)
    private List<Zona> zonaList;
    @JoinTable(name = "planilla_pedido", joinColumns = {
        @JoinColumn(name = "Id_Planilla", referencedColumnName = "Id_Planilla")}, inverseJoinColumns = {
        @JoinColumn(name = "Id_Pedido", referencedColumnName = "Id_Pedido")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Pedido> pedidoList;
    @JoinColumn(name = "Id_EstadoPlanilla", referencedColumnName = "Id_EstadoPlanilla")
    @ManyToOne(fetch = FetchType.LAZY)
    private Estadoplanilla idEstadoPlanilla;
    @JoinColumn(name = "Id_Usuario", referencedColumnName = "Id_Usuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario idUsuario;
    @OneToMany(mappedBy = "idPlanilla", fetch = FetchType.LAZY)
    private List<Tarea> tareaList;

    public Planilla() {
    }

    public Planilla(Integer idPlanilla) {
        this.idPlanilla = idPlanilla;
    }

    public Integer getIdPlanilla() {
        return idPlanilla;
    }

    public void setIdPlanilla(Integer idPlanilla) {
        this.idPlanilla = idPlanilla;
    }

    @XmlTransient
    public List<Zona> getZonaList() {
        return zonaList;
    }

    public void setZonaList(List<Zona> zonaList) {
        this.zonaList = zonaList;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    public Estadoplanilla getIdEstadoPlanilla() {
        return idEstadoPlanilla;
    }

    public void setIdEstadoPlanilla(Estadoplanilla idEstadoPlanilla) {
        this.idEstadoPlanilla = idEstadoPlanilla;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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
        hash += (idPlanilla != null ? idPlanilla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planilla)) {
            return false;
        }
        Planilla other = (Planilla) object;
        if ((this.idPlanilla == null && other.idPlanilla != null) || (this.idPlanilla != null && !this.idPlanilla.equals(other.idPlanilla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Planilla[ idPlanilla=" + idPlanilla + " ]";
    }
    
}
