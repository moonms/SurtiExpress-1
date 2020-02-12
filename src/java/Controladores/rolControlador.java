/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Rol;
import Facades.RolFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author surtiExpress
 */
@Named(value = "rolControlador")
@SessionScoped
public class rolControlador implements Serializable {

    /**
     * Creates a new instance of rolControlador
     */
    public rolControlador() {
    }
    @EJB
    RolFacade rolFacade;
    Rol rol = new Rol();

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Rol> listarRoles() {
        return rolFacade.findAll();
    }
}
