/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Rol;
import Entidades.Usuario;
import Facades.RolFacade;
import Facades.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author surtiExpress
 */
@Named(value = "loginControlador")
@SessionScoped
public class loginControlador implements Serializable {

    /**
     * Creates a new instance of loginControlador
     */
    public loginControlador() {
    }
    @EJB
    UsuarioFacade usuarioFacade;
    Usuario usuario = new Usuario();
    @EJB
    RolFacade rolFacade;
    Rol rol = new Rol();
    Usuario usuarioCorreo;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    public String login(){
      Usuario u;
       try {
           u = usuarioFacade.login(usuario);//la variable que me almacena el inicio de sesecion
           if (u != null) {
               int ro= u.getIdRol().getIdRol();//me almacena el rol del usuario logueado
               if (ro==1) {
               FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", u);
               return "1";
                   
               }else if(ro==2){
                   FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", u);
               return "2";
               }
           }
       } catch (Exception e) {
           System.out.println(e);
       }
       return "";
   }
    public void verificarSesion(){
       try {
           Usuario u = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
           if (u==null) {
               FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
           }
       } catch (Exception e) {
       }
   }
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login";
    }
    /*public String recuperarContraseña(){
        Usuario us;
        try{
            us = usuarioFacade.recuperarContraseña(usuario);
            String mensaje= us.getContrasena();
            Mailer.send(getUsuario().getCorreo(), "mire su contraseña brut@",us.getContrasena());
        }catch(Exception e){
            System.out.println(e);
        }
       return""; 
    }*/
    
    
}
