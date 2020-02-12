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
@Table(name = "estadopedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadopedido.findAll", query = "SELECT e FROM Estadopedido e")
    , @NamedQuery(name = "Estadopedido.findByIdEstadoPedido", query = "SELECT e FROM Estadopedido e WHERE e.idEstadoPedido = :idEstadoPedido")
    , @NamedQuery(name = "Estadopedido.findByEstadoPedido", query = "SELECT e FROM Estadopedido e WHERE e.estadoPedido = :estadoPedido")})
public class Estadopedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_EstadoPedido")
    private Integer idEstadoPedido;
    @Size(max = 45)
    @Column(name = "EstadoPedido")
    private String estadoPedido;
    @OneToMany(mappedBy = "idEstadoPedido", fetch = FetchType.LAZY)
    private List<Pedido> pedidoList;

    public Estadopedido() {
    }

    public Estadopedido(Integer idEstadoPedido) {
        this.idEstadoPedido = idEstadoPedido;
    }

    public Integer getIdEstadoPedido() {
        return idEstadoPedido;
    }

    public void setIdEstadoPedido(Integer idEstadoPedido) {
        this.idEstadoPedido = idEstadoPedido;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoPedido != null ? idEstadoPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadopedido)) {
            return false;
        }
        Estadopedido other = (Estadopedido) object;
        if ((this.idEstadoPedido == null && other.idEstadoPedido != null) || (this.idEstadoPedido != null && !this.idEstadoPedido.equals(other.idEstadoPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Estadopedido[ idEstadoPedido=" + idEstadoPedido + " ]";
    }
    
}
