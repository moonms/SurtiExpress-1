package Entidades;

import Entidades.Estadoproducto;
import Entidades.Pedido;
import Entidades.Submarca;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-12T08:07:40")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile SingularAttribute<Producto, Double> precioNeto;
    public static volatile SingularAttribute<Producto, Estadoproducto> idEstadoProducto;
    public static volatile SingularAttribute<Producto, Integer> iva;
    public static volatile SingularAttribute<Producto, String> imagen;
    public static volatile ListAttribute<Producto, Pedido> pedidoList;
    public static volatile SingularAttribute<Producto, Submarca> idSubmarca;
    public static volatile SingularAttribute<Producto, Integer> idProducto;
    public static volatile SingularAttribute<Producto, Integer> cantidad;
    public static volatile SingularAttribute<Producto, Double> precioBruto;
    public static volatile SingularAttribute<Producto, String> nombre;

}