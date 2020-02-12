/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Estadopedido;
import Entidades.Pedido;
import Entidades.Producto;
import Entidades.Usuario;
import Facades.EstadopedidoFacade;
import Facades.PedidoFacade;
import Facades.ProductoFacade;
import Facades.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author farfa
 */
@Named(value = "pedidoControlador")
@SessionScoped
public class pedidoControlador implements Serializable {

    /**
     * Creates a new instance of pedidoControlador
     */
    public pedidoControlador() {
    }

    @EJB
    PedidoFacade pedidoFacade;
    Pedido pedido = new Pedido();

    @EJB
    EstadopedidoFacade estadopedidoFacade;
    Estadopedido estadoPedido = new Estadopedido();
    @EJB
    UsuarioFacade usuariofacade;
    Usuario usuario = new Usuario();
    @EJB
    ProductoFacade productoFacade;
    Producto producto = new Producto();
    List<Producto> listaProductos;
    List<Producto> carrito = new ArrayList();

    

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

    public EstadopedidoFacade getEstadopedidoFacade() {
        return estadopedidoFacade;
    }

    public void setEstadopedidoFacade(EstadopedidoFacade estadopedidoFacade) {
        this.estadopedidoFacade = estadopedidoFacade;
    }

    public Estadopedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(Estadopedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public UsuarioFacade getUsuariofacade() {
        return usuariofacade;
    }

    public void setUsuariofacade(UsuarioFacade usuariofacade) {
        this.usuariofacade = usuariofacade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ProductoFacade getProductoFacade() {
        return productoFacade;
    }

    public void setProductoFacade(ProductoFacade productoFacade) {
        this.productoFacade = productoFacade;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

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

    @PostConstruct
    public void init() {
        this.producto = new Producto();
        this.estadoPedido = new Estadopedido();
        this.pedido = new Pedido();
        this.usuario = new Usuario();
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

    public void crearPedido() {
        //usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario"); //es para verificar la secion
        //pedido.setIdUsuario(usuariofacade.find(usuario.getIdUsuario())); // asocia el pedido con un id de usuario
        double subTotal = 0;
        double total = 0;
        pedido.setIdPedido(1);
        for (Producto producto1 : carrito) {
            producto1.setCantidad(producto1.getCantidad() - 10000000 );
        }   

        for (Producto producto2 : carrito) {
            subTotal = subTotal + producto2.getPrecioBruto();
        }
        for (Producto producto3 : carrito) {
            total = total + producto3.getPrecioNeto();
        }
        pedido.setSubtotal(subTotal);
        pedido.setTotal(total);
        pedido.setIdEstadoPedido(getEstadoPedido()); //Asocia el pedido con un Id de un estado
        pedido.setIdUsuario(getUsuario());
        pedidoFacade.create(pedido);
        pedidoFacade.agregarProductoAlPedido(carrito, pedido);
    }

    public String preEditarPedido(Pedido pedido) {
        this.producto = producto;
        this.estadoPedido = pedido.getIdEstadoPedido();
        this.usuario = pedido.getIdUsuario();
        return "editarProducto";
    }

    public String editarPedido() {
        pedido.setIdEstadoPedido(estadopedidoFacade.find(estadoPedido.getEstadoPedido()));
        pedidoFacade.edit(pedido);
        return "";
    }

    public void eliminarPedido(Pedido pedido) {
        pedidoFacade.remove(pedido);
    }

    
    public List<Pedido> listarPedidos() {
        return pedidoFacade.findAll();
    }

}
