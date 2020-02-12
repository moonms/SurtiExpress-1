/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Planilla;
import Entidades.Zona;
import Facades.PlanillaFacade;
import Facades.ZonaFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author surtiExpress
 */
@Named(value = "zonaControlador")
@SessionScoped
public class zonaControlador implements Serializable {

    /**
     * Creates a new instance of zonaControlador
     */
    public zonaControlador() {
    }
    @EJB
    ZonaFacade zonaFacade;
    Zona zona = new Zona();

    @EJB
    PlanillaFacade planillaFacade;
    Planilla planilla = new Planilla();

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public Planilla getPlanilla() {
        return planilla;
    }

    public void setPlanilla(Planilla planilla) {
        this.planilla = planilla;
    }

    public List<Zona> listarZonas() {
        return zonaFacade.findAll();
    }
    
    

}
