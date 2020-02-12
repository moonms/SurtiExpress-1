/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Tipodocumento;
import Facades.TipodocumentoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author surtiExpress
 */
@Named(value = "tipodocumentoControlador")
@SessionScoped
public class tipodocumentoControlador implements Serializable {

    /**
     * Creates a new instance of tipodocumentoControlador
     */
    public tipodocumentoControlador() {
    }
    @EJB
    TipodocumentoFacade tipodocumentoFacade;
    Tipodocumento tipodocumento = new Tipodocumento();

    public Tipodocumento getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(Tipodocumento tipodocumento) {
        this.tipodocumento = tipodocumento;
    }
    public List<Tipodocumento> listarDocumento(){
        return tipodocumentoFacade.findAll();
    }
}
