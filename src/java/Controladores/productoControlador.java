/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Estadoproducto;
import Entidades.Marca;
import Entidades.Producto;
import Entidades.Submarca;
import Entidades.Usuario;
import Facades.EstadoproductoFacade;
import Facades.MarcaFacade;
import Facades.ProductoFacade;
import Facades.SubmarcaFacade;
import Facades.UsuarioFacade;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

/**
 *
 * @author surtiExpress
 */
@Named(value = "productoControlador")
@SessionScoped
public class productoControlador implements Serializable {

    /**
     * Creates a new instance of productoControlador
     */
    public productoControlador() {
    }
    @EJB
    ProductoFacade productoFacade;
    Producto producto = new Producto();
    List<Producto> listaProductos;
    List<Producto> carrito = new ArrayList();
    @EJB
    SubmarcaFacade submarcaFacade;
    Submarca submarca = new Submarca();
    @EJB
    MarcaFacade marcaFacade;
    Marca marca = new Marca();
    @EJB
    EstadoproductoFacade estadoproductoFacade;
    Estadoproducto estadoproducto = new Estadoproducto();
    @EJB
    UsuarioFacade usuarioFacade;
    Usuario usuario = new Usuario();
    private Part file;
    private String nombre;
    private String pathReal;

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public List<Producto> getCarrito() {
        return carrito;
    }

    public void setCarrito(List<Producto> carrito) {
        this.carrito = carrito;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPathReal() {
        return pathReal;
    }

    public void setPathReal(String pathReal) {
        this.pathReal = pathReal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Submarca getSubmarca() {
        return submarca;
    }

    public void setSubmarca(Submarca submarca) {
        this.submarca = submarca;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Estadoproducto getEstadoproducto() {
        return estadoproducto;
    }

    public void setEstadoproducto(Estadoproducto estadoproducto) {
        this.estadoproducto = estadoproducto;
    }

    @PostConstruct
    public void init() {
        marca = new Marca();
        submarca = new Submarca();
        producto = new Producto();
        estadoproducto = new Estadoproducto();
    }

    public String agregarCarrito(Producto p) {
        carrito.add(p);
        System.out.println(carrito);
        return "carrito";//retorna a la pagina 
    }

    public void removerCarrito(Producto p) {
        carrito.remove(p);
        System.out.println(carrito);
    }

    public void crearProducto() {
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("IMGCatalogo");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\IMGCatalogo\\";
        try {
            this.nombre = file.getSubmittedFileName();
            pathReal = "/SurtiExpressV.3/IMGCatalogo/" + nombre;
            path = path + this.nombre;
            InputStream in = file.getInputStream();

            byte[] data = new byte[in.available()];
            in.read(data);
            FileOutputStream out = new FileOutputStream(new File(path));
            out.write(data);
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.producto.setImagen(pathReal);
        producto.setIdSubmarca(submarcaFacade.find(submarca.getIdSubMarca()));
        producto.setIdEstadoProducto(estadoproductoFacade.find(estadoproducto.getIdEstadoProducto()));
        productoFacade.create(producto);
    }

    public List<Producto> listarInventario() {
        return productoFacade.findAll();
    }

    public String preEditar(Producto producto) {
        this.producto = producto;
        this.estadoproducto = producto.getIdEstadoProducto();
        this.submarca = producto.getIdSubmarca();
        return "editarProducto";
    }

    public String editarProducto() {
        producto.setIdSubmarca(submarcaFacade.find(submarca.getIdSubMarca()));
        producto.setIdEstadoProducto(estadoproductoFacade.find(estadoproducto.getIdEstadoProducto()));
        productoFacade.edit(producto);
        return "";
    }

    public void editarEstado(Producto producto) {
        this.producto = producto;
        this.submarca = producto.getIdSubmarca();
        producto.setIdSubmarca(submarcaFacade.find(submarca.getIdSubMarca()));
        producto.setIdEstadoProducto(estadoproductoFacade.find(estadoproducto.getIdEstadoProducto()));
        productoFacade.edit(producto);
    }

    public void eliminarProducto(Producto producto) {
        productoFacade.remove(producto);
    }

    public List<Producto> avisarAdmin() throws UnsupportedEncodingException {
        List<Producto> canti = productoFacade.findAll();
        List<Producto> listaAuxiliar = new ArrayList();
        for (Producto producto : canti) {
            if (producto.getCantidad() <= 20) {
                listaAuxiliar.add(producto);
                List<Usuario> listaUsuarios = usuarioFacade.findAll();
                for (Usuario usuario : listaUsuarios) {
                    if (usuario.getIdRol().getIdRol() == 1) {
                        String correos = usuario.getCorreo();
                        Mailer.send(correos, "comprar nuevas cosas", producto.getNombre());
                    }

                }
            }
        }
        canti.removeAll(listaAuxiliar);
        return canti;
    }

}
