/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author farfa
 */
@Entity
@Table(name = "pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")
    , @NamedQuery(name = "Pedido.findByIdPedido", query = "SELECT p FROM Pedido p WHERE p.idPedido = :idPedido")
    , @NamedQuery(name = "Pedido.findByFechaCreacion", query = "SELECT p FROM Pedido p WHERE p.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Pedido.findByFechaEntrega", query = "SELECT p FROM Pedido p WHERE p.fechaEntrega = :fechaEntrega")
    , @NamedQuery(name = "Pedido.findBySubtotal", query = "SELECT p FROM Pedido p WHERE p.subtotal = :subtotal")
    , @NamedQuery(name = "Pedido.findByTotal", query = "SELECT p FROM Pedido p WHERE p.total = :total")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Pedido")
    private Integer idPedido;
    @Column(name = "FechaCreacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "FechaEntrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Subtotal")
    private Double subtotal;
    @Column(name = "Total")
    private Double total;
    @ManyToMany(mappedBy = "pedidoList", fetch = FetchType.LAZY)
    private List<Planilla> planillaList;
    @JoinTable(name = "pedido_producto", joinColumns = {
        @JoinColumn(name = "Id_Pedido", referencedColumnName = "Id_Pedido")}, inverseJoinColumns = {
        @JoinColumn(name = "Id_Producto", referencedColumnName = "Id_Producto")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Producto> productoList;
    @OneToMany(mappedBy = "idPedido", fetch = FetchType.LAZY)
    private List<Devolucion> devolucionList;
    @JoinColumn(name = "Id_Usuario", referencedColumnName = "Id_Usuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario idUsuario;
    @JoinColumn(name = "Id_EstadoPedido", referencedColumnName = "Id_EstadoPedido")
    @ManyToOne(fetch = FetchType.LAZY)
    private Estadopedido idEstadoPedido;

    public Pedido() {
    }

    public Pedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @XmlTransient
    public List<Planilla> getPlanillaList() {
        return planillaList;
    }

    public void setPlanillaList(List<Planilla> planillaList) {
        this.planillaList = planillaList;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @XmlTransient
    public List<Devolucion> getDevolucionList() {
        return devolucionList;
    }

    public void setDevolucionList(List<Devolucion> devolucionList) {
        this.devolucionList = devolucionList;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Estadopedido getIdEstadoPedido() {
        return idEstadoPedido;
    }

    public void setIdEstadoPedido(Estadopedido idEstadoPedido) {
        this.idEstadoPedido = idEstadoPedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Pedido[ idPedido=" + idPedido + " ]";
    }
    
}
