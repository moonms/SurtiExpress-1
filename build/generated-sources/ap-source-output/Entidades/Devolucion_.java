package Entidades;

import Entidades.Pedido;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-04T02:52:35")
@StaticMetamodel(Devolucion.class)
public class Devolucion_ { 

    public static volatile SingularAttribute<Devolucion, String> motivo;
    public static volatile SingularAttribute<Devolucion, Date> fechaDevolucion;
    public static volatile SingularAttribute<Devolucion, Pedido> idPedido;
    public static volatile SingularAttribute<Devolucion, Integer> idDevolucion;

}