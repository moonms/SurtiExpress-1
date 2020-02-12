/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Estadoplanilla;
import Facades.EstadoplanillaFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author farfa
 */
@Named(value = "estadoplanillaControlador")
@SessionScoped
public class estadoplanillaControlador implements Serializable {

    /**
     * Creates a new instance of estadoplanillaControlador
     */
    public estadoplanillaControlador() {
    }
    @EJB
    EstadoplanillaFacade estadoplanillaFacade;
    Estadoplanilla estadoplanilla = new Estadoplanilla();
    
    public List<Estadoplanilla> listarEstadoplan(){
        return estadoplanillaFacade.findAll();
        
    }
    
}
