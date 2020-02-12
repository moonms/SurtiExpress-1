/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Estadotarea;
import Facades.EstadotareaFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author farfa
 */
@Named(value = "estadotareaControlador")
@SessionScoped
public class estadotareaControlador implements Serializable {

    /**
     * Creates a new instance of estadotareaControlador
     */
    public estadotareaControlador() {
    }
    @EJB
    EstadotareaFacade estadotareaFacade;
    Estadotarea estadotarea = new Estadotarea();

    public Estadotarea getEstadotarea() {
        return estadotarea;
    }

    public void setEstadotarea(Estadotarea estadotarea) {
        this.estadotarea = estadotarea;
    }

    public List<Estadotarea> listarEstadoTarea() {
        return estadotareaFacade.findAll();
    }
}
