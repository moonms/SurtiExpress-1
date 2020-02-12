/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Rol;
import Entidades.Tipodocumento;
import Entidades.Usuario;
import Entidades.Vehiculo;
import Entidades.Zona;
import Facades.RolFacade;
import Facades.TipodocumentoFacade;
import Facades.UsuarioFacade;
import Facades.VehiculoFacade;
import Facades.ZonaFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author surtiExpress
 */
@Named(value = "usuarioControlador")
@SessionScoped
public class usuarioControlador implements Serializable {

    /**
     * Creates a new instance of usuarioControlador
     */
    public usuarioControlador() {
    }
    //Importar EJB y Endidades
    @EJB
    UsuarioFacade usuarioFacade;
    Usuario usuario = new Usuario();
    @EJB
    TipodocumentoFacade tipodocumentoFacade;
    Tipodocumento tipodocumento = new Tipodocumento();
    @EJB
    RolFacade rolFacade;
    Rol rol = new Rol();
    @EJB
    ZonaFacade zonaFacade;
    Zona zona = new Zona();
    @EJB
    VehiculoFacade vehiculoFacade;
    Vehiculo vehiculo = new Vehiculo();
    
    
    //GET y SET

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tipodocumento getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(Tipodocumento tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    //PostConstruct

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        vehiculo = new Vehiculo();
        tipodocumento = new Tipodocumento();
        zona = new Zona();
        rol = new Rol();
    }

    //METODOS
    public void registrarUsuarioCliente() throws UnsupportedEncodingException{
        usuario.setIdRol(rolFacade.find(rol.getIdRol()));
        usuario.setIdTipoDocumento(tipodocumentoFacade.find(tipodocumento.getIdTipoDocumento()));
        usuario.setIdZona(zonaFacade.find(zona.getIdZona()));
        String mensaje="Su usuario es el siguiente:" + usuario.getCorreo() +"Su contraseña es:"+ usuario.getContrasena();
        usuarioFacade.create(usuario);
        Mailer.send(usuario.getCorreo(),"Usted se A registrado satisfactoriamente en SurtiExpress", mensaje);
        usuario = new Usuario();
        vehiculo = new Vehiculo();
        tipodocumento = new Tipodocumento();
        zona = new Zona();
        rol = new Rol();
    }

    public void registrarUsuarioEmpleado() {
        usuario.setIdRol(rolFacade.find(rol.getIdRol()));
        usuario.setIdTipoDocumento(tipodocumentoFacade.find(tipodocumento.getIdTipoDocumento()));
        usuarioFacade.create(usuario);
        usuario = new Usuario();
        vehiculo = new Vehiculo();
        tipodocumento = new Tipodocumento();
        zona = new Zona();
        rol = new Rol();
    }

    public void registrarUsuarioTransportador() {
        usuario.setIdRol(rolFacade.find(rol.getIdRol()));
        usuario.setIdTipoDocumento(tipodocumentoFacade.find(tipodocumento.getIdTipoDocumento()));
        vehiculoFacade.create(vehiculo);
        usuario.setIdVehiculo(vehiculoFacade.find(vehiculo.getIdVehiculo()));
        usuarioFacade.create(usuario);
        usuario = new Usuario();
        vehiculo = new Vehiculo();
        tipodocumento = new Tipodocumento();
        zona = new Zona();
        rol = new Rol();
    }

    public List<Usuario> listarClientes() {
        List<Usuario> listarUsuarios = usuarioFacade.findAll();
        List<Usuario> listaAuxiliar = new ArrayList();
        for (Usuario usuario : listarUsuarios) {
            if (usuario.getIdRol().getIdRol() != 2) {
                listaAuxiliar.add(usuario);
            }
        }
        listarUsuarios.removeAll(listaAuxiliar);
        return listarUsuarios;
    }

    public List<Usuario> listarTransportadores() {
        List<Usuario> listarUsuarios = usuarioFacade.findAll();
        List<Usuario> listaAuxiliar = new ArrayList();
        for (Usuario usuario : listarUsuarios) {
            if (usuario.getIdRol().getIdRol() != 3) {
                listaAuxiliar.add(usuario);
            }
        }
        listarUsuarios.removeAll(listaAuxiliar);
        return listarUsuarios;
    }

    public List<Usuario> listarEmpleadosBodeguista() {
        List<Usuario> listarUsuarios = usuarioFacade.findAll();
        List<Usuario> listaAuxiliar = new ArrayList();
        for (Usuario usuario : listarUsuarios) {
            if (usuario.getIdRol().getIdRol() != 4) {
                listaAuxiliar.add(usuario);
            }
        }
        listarUsuarios.removeAll(listaAuxiliar);
        return listarUsuarios;
    }

    public List<Usuario> listarEmpleadosAuxiliar() {
        List<Usuario> listarUsuarios = usuarioFacade.findAll();
        List<Usuario> listaAuxiliar = new ArrayList();
        for (Usuario usuario : listarUsuarios) {
            if (usuario.getIdRol().getIdRol() != 5) {
                listaAuxiliar.add(usuario);
            }
        }
        listarUsuarios.removeAll(listaAuxiliar);
        return listarUsuarios;
    }
    
    public List<Usuario> listarUsuarios(){
        return usuarioFacade.findAll();
    }

    public String preEditarUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.rol = usuario.getIdRol();
        this.tipodocumento = usuario.getIdTipoDocumento();
        this.zona = usuario.getIdZona();
        this.vehiculo = usuario.getIdVehiculo();
        return "editarUsuario";
    }

    public String editarUsuarioCliente() {
        usuario.setIdRol(rolFacade.find(rol.getIdRol()));
        usuario.setIdTipoDocumento(tipodocumentoFacade.find(tipodocumento.getIdTipoDocumento()));
        usuario.setIdZona(zonaFacade.find(zona.getIdZona()));
        usuarioFacade.edit(usuario);
        return "usuarioPage";
    }
    public String editarUsuarioTransportador() {
        usuario.setIdRol(rolFacade.find(rol.getIdRol()));
        usuario.setIdTipoDocumento(tipodocumentoFacade.find(tipodocumento.getIdTipoDocumento()));
        usuario.setIdZona(zonaFacade.find(zona.getIdZona()));
        vehiculoFacade.edit(vehiculo);
        usuario.setIdVehiculo(vehiculoFacade.find(vehiculo.getIdVehiculo()));
        usuarioFacade.edit(usuario);
        return "usuarioPage";
    }
    public String editarUsuarioempleado() {
        usuario.setIdRol(rolFacade.find(rol.getIdRol()));
        usuario.setIdTipoDocumento(tipodocumentoFacade.find(tipodocumento.getIdTipoDocumento()));
        usuarioFacade.edit(usuario);
        return "usuarioPage";
    }

    public void eliminarUsuarios(Usuario usuario) {
        usuarioFacade.remove(usuario);
    }
    
    
}
