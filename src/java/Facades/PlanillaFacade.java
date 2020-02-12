/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entidades.Pedido;
import Entidades.Planilla;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author farfa
 */
@Stateless
public class PlanillaFacade extends AbstractFacade<Planilla> {

    @PersistenceContext(unitName = "SurtiExpressV.3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlanillaFacade() {
        super(Planilla.class);
        
    }
    public void crearPlanillaPedidos(List<Pedido> listaPedidos, Planilla planilla){
        for (Pedido pedido:listaPedidos) {
            Query query = em.createNativeQuery("INSERT INTO planilla_pedido (Id_Planilla, Id_Pedido) VALUES (?1, ?2)");
            query.setParameter(1, planilla.getIdPlanilla());
            query.setParameter(2, pedido.getIdPedido());
            query.executeUpdate();
        }
    }
}
