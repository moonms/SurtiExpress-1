package Entidades;

import Entidades.Devolucion;
import Entidades.Estadopedido;
import Entidades.Producto;
import Entidades.Ruta;
import Entidades.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-04T17:45:39")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, Double> total;
    public static volatile ListAttribute<Pedido, Ruta> rutaList;
    public static volatile SingularAttribute<Pedido, Estadopedido> idEstadoPedido;
    public static volatile SingularAttribute<Pedido, Double> subtotal;
    public static volatile ListAttribute<Pedido, Producto> productoList;
    public static volatile ListAttribute<Pedido, Devolucion> devolucionList;
    public static volatile SingularAttribute<Pedido, Usuario> idUsuario;
    public static volatile SingularAttribute<Pedido, Date> fechaEntrega;
    public static volatile SingularAttribute<Pedido, Date> fechaCreacion;
    public static volatile SingularAttribute<Pedido, Integer> idPedido;

}