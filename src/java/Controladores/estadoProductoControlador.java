/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Estadoproducto;
import Facades.EstadoproductoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author surtiExpress
 */
@Named(value = "estadoProductoControlador")
@SessionScoped
public class estadoProductoControlador implements Serializable {

    /**
     * Creates a new instance of estadoProductoControlador
     */
    public estadoProductoControlador() {
    }
    @EJB
    EstadoproductoFacade estadoproductoFacade;
    Estadoproducto estadoproducto = new Estadoproducto();

    public Estadoproducto getEstadoproducto() {
        return estadoproducto;
    }

    public void setEstadoproducto(Estadoproducto estadoproducto) {
        this.estadoproducto = estadoproducto;
    }

    public List<Estadoproducto> listarEstadoProducto() {
        return estadoproductoFacade.findAll();
    }

}
