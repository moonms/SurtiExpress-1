/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entidades.Usuario;
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
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "SurtiExpressV.3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public Usuario login(Usuario user) {
        Usuario u = null;
        Query query;
        try {
            query = em.createQuery("SELECT u FROM Usuario u WHERE u.correo ?1 AND u.contrasena?2");
            query.setParameter(1, user.getCorreo());
            query.setParameter(2, user.getContrasena());
            List<Usuario> listUser = query.getResultList();
            if (!listUser.isEmpty()) {
                u = listUser.get(0);
                return u;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return u;
    }

}
