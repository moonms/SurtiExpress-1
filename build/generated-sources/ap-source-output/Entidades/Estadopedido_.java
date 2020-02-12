package Entidades;

import Entidades.Pedido;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-04T02:52:35")
@StaticMetamodel(Estadopedido.class)
public class Estadopedido_ { 

    public static volatile SingularAttribute<Estadopedido, Integer> idEstadoPedido;
    public static volatile SingularAttribute<Estadopedido, String> estadoPedido;
    public static volatile ListAttribute<Estadopedido, Pedido> pedidoList;

}