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
@Table(name = "estadoproducto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadoproducto.findAll", query = "SELECT e FROM Estadoproducto e")
    , @NamedQuery(name = "Estadoproducto.findByIdEstadoProducto", query = "SELECT e FROM Estadoproducto e WHERE e.idEstadoProducto = :idEstadoProducto")
    , @NamedQuery(name = "Estadoproducto.findByEstadoProducto", query = "SELECT e FROM Estadoproducto e WHERE e.estadoProducto = :estadoProducto")})
public class Estadoproducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_EstadoProducto")
    private Integer idEstadoProducto;
    @Size(max = 45)
    @Column(name = "EstadoProducto")
    private String estadoProducto;
    @OneToMany(mappedBy = "idEstadoProducto", fetch = FetchType.LAZY)
    private List<Producto> productoList;

    public Estadoproducto() {
    }

    public Estadoproducto(Integer idEstadoProducto) {
        this.idEstadoProducto = idEstadoProducto;
    }

    public Integer getIdEstadoProducto() {
        return idEstadoProducto;
    }

    public void setIdEstadoProducto(Integer idEstadoProducto) {
        this.idEstadoProducto = idEstadoProducto;
    }

    public String getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(String estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoProducto != null ? idEstadoProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadoproducto)) {
            return false;
        }
        Estadoproducto other = (Estadoproducto) object;
        if ((this.idEstadoProducto == null && other.idEstadoProducto != null) || (this.idEstadoProducto != null && !this.idEstadoProducto.equals(other.idEstadoProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Estadoproducto[ idEstadoProducto=" + idEstadoProducto + " ]";
    }
    
}
