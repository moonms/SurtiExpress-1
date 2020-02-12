/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Estadotarea;
import Entidades.Planilla;
import Entidades.Tarea;
import Entidades.Usuario;
import Facades.EstadotareaFacade;
import Facades.PlanillaFacade;
import Facades.TareaFacade;
import Facades.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author farfa
 */
@Named(value = "tareaControlador")
@SessionScoped
public class tareaControlador implements Serializable {

    /**
     * Creates a new instance of tareaControlador
     */
    public tareaControlador() {
    }
    @EJB
    TareaFacade tareaFacade;
    Tarea tarea = new Tarea();
    
    @EJB
    PlanillaFacade planillaFacade;
    Planilla planilla = new Planilla();
    
    @EJB
    EstadotareaFacade estadotareaFacade;
    Estadotarea estadotarea = new Estadotarea();
    
    @EJB
    UsuarioFacade usuarioFacade;
    Usuario usuario = new Usuario();

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public Planilla getPlanilla() {
        return planilla;
    }

    public void setPlanilla(Planilla planilla) {
        this.planilla = planilla;
    }

    public Estadotarea getEstadotarea() {
        return estadotarea;
    }

    public void setEstadotarea(Estadotarea estadotarea) {
        this.estadotarea = estadotarea;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void crearTarea (){
        tarea.setIdPlanilla(getPlanilla());
        tarea.setIdEstadoTarea(getEstadotarea());
        tarea.setIdUsuario(getUsuario());
        tareaFacade.create(tarea);
    }
    
}
