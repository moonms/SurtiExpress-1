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
import javax.persistence.ManyToOne;
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
@Table(name = "submarca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Submarca.findAll", query = "SELECT s FROM Submarca s")
    , @NamedQuery(name = "Submarca.findByIdSubMarca", query = "SELECT s FROM Submarca s WHERE s.idSubMarca = :idSubMarca")
    , @NamedQuery(name = "Submarca.findBySubMarca", query = "SELECT s FROM Submarca s WHERE s.subMarca = :subMarca")})
public class Submarca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_SubMarca")
    private Integer idSubMarca;
    @Size(max = 45)
    @Column(name = "SubMarca")
    private String subMarca;
    @OneToMany(mappedBy = "idSubmarca", fetch = FetchType.LAZY)
    private List<Producto> productoList;
    @JoinColumn(name = "Id_Marca", referencedColumnName = "Id_Marca")
    @ManyToOne(fetch = FetchType.LAZY)
    private Marca idMarca;

    public Submarca() {
    }

    public Submarca(Integer idSubMarca) {
        this.idSubMarca = idSubMarca;
    }

    public Integer getIdSubMarca() {
        return idSubMarca;
    }

    public void setIdSubMarca(Integer idSubMarca) {
        this.idSubMarca = idSubMarca;
    }

    public String getSubMarca() {
        return subMarca;
    }

    public void setSubMarca(String subMarca) {
        this.subMarca = subMarca;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    public Marca getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marca idMarca) {
        this.idMarca = idMarca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubMarca != null ? idSubMarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Submarca)) {
            return false;
        }
        Submarca other = (Submarca) object;
        if ((this.idSubMarca == null && other.idSubMarca != null) || (this.idSubMarca != null && !this.idSubMarca.equals(other.idSubMarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Submarca[ idSubMarca=" + idSubMarca + " ]";
    }
    
}
