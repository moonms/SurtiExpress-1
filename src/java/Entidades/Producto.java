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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author farfa
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto")
    , @NamedQuery(name = "Producto.findByCantidad", query = "SELECT p FROM Producto p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "Producto.findByPrecioBruto", query = "SELECT p FROM Producto p WHERE p.precioBruto = :precioBruto")
    , @NamedQuery(name = "Producto.findByIva", query = "SELECT p FROM Producto p WHERE p.iva = :iva")
    , @NamedQuery(name = "Producto.findByPrecioNeto", query = "SELECT p FROM Producto p WHERE p.precioNeto = :precioNeto")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Producto")
    private Integer idProducto;
    @Lob
    @Size(max = 65535)
    @Column(name = "imagen")
    private String imagen;
    @Lob
    @Size(max = 65535)
    @Column(name = "Nombre")
    private String nombre;
    @Lob
    @Size(max = 65535)
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Cantidad")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PrecioBruto")
    private Double precioBruto;
    @Column(name = "iva")
    private Integer iva;
    @Column(name = "PrecioNeto")
    private Double precioNeto;
    @ManyToMany(mappedBy = "productoList", fetch = FetchType.LAZY)
    private List<Pedido> pedidoList;
    @JoinColumn(name = "Id_EstadoProducto", referencedColumnName = "Id_EstadoProducto")
    @ManyToOne(fetch = FetchType.LAZY)
    private Estadoproducto idEstadoProducto;
    @JoinColumn(name = "Id_Submarca", referencedColumnName = "Id_SubMarca")
    @ManyToOne(fetch = FetchType.LAZY)
    private Submarca idSubmarca;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioBruto() {
        return precioBruto;
    }

    public void setPrecioBruto(Double precioBruto) {
        this.precioBruto = precioBruto;
    }

    public Integer getIva() {
        return iva;
    }

    public void setIva(Integer iva) {
        this.iva = iva;
    }

    public Double getPrecioNeto() {
        return precioNeto;
    }

    public void setPrecioNeto(Double precioNeto) {
        this.precioNeto = precioNeto;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    public Estadoproducto getIdEstadoProducto() {
        return idEstadoProducto;
    }

    public void setIdEstadoProducto(Estadoproducto idEstadoProducto) {
        this.idEstadoProducto = idEstadoProducto;
    }

    public Submarca getIdSubmarca() {
        return idSubmarca;
    }

    public void setIdSubmarca(Submarca idSubmarca) {
        this.idSubmarca = idSubmarca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Producto[ idProducto=" + idProducto + " ]";
    }
    
}
