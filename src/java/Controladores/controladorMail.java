package Controladores;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Entidades.Producto;
import Entidades.Usuario;
import Facades.ProductoFacade;
import Facades.UsuarioFacade;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class controladorMail {

    /**
     * Creates a new instance of controladorMail
     */
    public controladorMail() {
    }

    @EJB
    ProductoFacade productoFacade;
    private Producto producto;
    @EJB
    UsuarioFacade usuarioFacade;
    private Usuario usuario;
    String asunto = "correo prueba Xd";
    String destinatario = "";
    String mensaje = "";

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String enviarCorreo() throws UnsupportedEncodingException {
        Mailer.send(destinatario, asunto, mensaje);
        return "Usuarios";
    }

    public String mensajeConEstilo() {
        return "<h1 style=\"font-size: 20px; color:#0C0; font-weight: bold; text-transform: uppercase ; \">Contraseña Effective Orders" + "</h1>" + mensaje + "<br>\n"
                + "<p style=\"text-align: center; color: #307EDF\">\n"
                + "</p> \n"
                + "<br>\n"
                + "<p style=\"color:#0C0;font-weight: bold;\" > Gracias por formar parte de nuestra comunidad </p> ";

    }

    public String enviarCorreoCli() throws UnsupportedEncodingException {

        List<Usuario> listaUsuarios = usuarioFacade.findAll();
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getIdRol().getIdRol() == 1) {
                destinatario = "";
                destinatario = usuario.getCorreo();
                Mailer.send(destinatario, asunto, mensajeConEstilo());
            }

        }

        return "";
    }

    public String enviarCorreoBog() throws UnsupportedEncodingException {

        List<Usuario> listaUsuarios = usuarioFacade.findAll();
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getIdRol().getIdRol() == 3) {
                destinatario = usuario.getCorreo();
                Mailer.send(destinatario, asunto, mensajeConEstilo());
            }

        }
        return "";
    }

    public String enviarCorreoTra() throws UnsupportedEncodingException {

        List<Usuario> listaUsuarios = usuarioFacade.findAll();
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getIdRol().getIdRol() == 2) {
                destinatario = usuario.getCorreo();
                Mailer.send(destinatario, asunto, mensajeConEstilo());
            }

        }
        return "";
    }
}