/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Estadopedido;
import Facades.EstadopedidoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author farfa
 */
@Named(value = "estadoPedidoControlador")
@SessionScoped
public class estadoPedidoControlador implements Serializable {

    /**
     * Creates a new instance of estadoPedidoControlador
     */
    public estadoPedidoControlador() {
    }
    
    @EJB
    EstadopedidoFacade estadopedidoFacade;
    Estadopedido estadopedido = new Estadopedido();

    public Estadopedido getEstadopedido() {
        return estadopedido;
    }

    public void setEstadopedido(Estadopedido estadopedido) {
        this.estadopedido = estadopedido;
    }

   public List<Estadopedido> listarEstadoPedido(){ 
    return estadopedidoFacade.findAll();
} 
    
     
    
}
