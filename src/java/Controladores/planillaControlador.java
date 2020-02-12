/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Estadoplanilla;
import Entidades.Pedido;
import Entidades.Planilla;
import Entidades.Usuario;
import Facades.EstadoplanillaFacade;
import Facades.PedidoFacade;
import Facades.PlanillaFacade;
import Facades.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author farfa
 */
@Named(value = "planillaControlador")
@SessionScoped
public class planillaControlador implements Serializable {

    /**
     * Creates a new instance of planillaControlador
     */
    public planillaControlador() {
    }
    @EJB
    PlanillaFacade planillaFacade;
    Planilla planilla = new Planilla();
    @EJB
    EstadoplanillaFacade estadoplanillaFacade;
    Estadoplanilla estadoplanilla = new Estadoplanilla();
    @EJB
    UsuarioFacade estadoFacade;
    Usuario usuario = new Usuario();
    @EJB
    PedidoFacade pedidoFacade;
    Pedido pedido = new Pedido();
    List<Planilla> listaPlanilla;
    List<Pedido> listaPedidos= new ArrayList();

    public PlanillaFacade getPlanillaFacade() {
        return planillaFacade;
    }

    public void setPlanillaFacade(PlanillaFacade planillaFacade) {
        this.planillaFacade = planillaFacade;
    }

    public Planilla getPlanilla() {
        return planilla;
    }

    public void setPlanilla(Planilla planilla) {
        this.planilla = planilla;
    }

    public EstadoplanillaFacade getEstadoplanillaFacade() {
        return estadoplanillaFacade;
    }

    public void setEstadoplanillaFacade(EstadoplanillaFacade estadoplanillaFacade) {
        this.estadoplanillaFacade = estadoplanillaFacade;
    }

    public Estadoplanilla getEstadoplanilla() {
        return estadoplanilla;
    }

    public void setEstadoplanilla(Estadoplanilla estadoplanilla) {
        this.estadoplanilla = estadoplanilla;
    }

    public UsuarioFacade getEstadoFacade() {
        return estadoFacade;
    }

    public void setEstadoFacade(UsuarioFacade estadoFacade) {
        this.estadoFacade = estadoFacade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public PedidoFacade getPedidoFacade() {
        return pedidoFacade;
    }

    public void setPedidoFacade(PedidoFacade pedidoFacade) {
        this.pedidoFacade = pedidoFacade;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Planilla> getListaPlanilla() {
        return listaPlanilla;
    }

    public void setListaPlanilla(List<Planilla> listaPlanilla) {
        this.listaPlanilla = listaPlanilla;
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }
    public void agregarPedidoPlanilla(Pedido pe){
        listaPedidos.add(pe);
        System.out.println(listaPedidos);
    }
    public void removerPedidoPlanilla(Pedido pe){
        listaPedidos.remove(pe);
        System.out.println(listaPedidos);
    }
    public void crearPlanilla(){
        planilla.setIdEstadoPlanilla(getEstadoplanilla());
        planilla.setIdUsuario(getUsuario());
        planillaFacade.create(planilla);
        planillaFacade.crearPlanillaPedidos(listaPedidos, planilla);
    }
    public List<Planilla> listarPlanillas(){
        return planillaFacade.findAll();
    }
}
