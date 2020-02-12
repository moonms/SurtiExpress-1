package Entidades;

import Entidades.Marca;
import Entidades.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-12T08:07:40")
@StaticMetamodel(Submarca.class)
public class Submarca_ { 

    public static volatile ListAttribute<Submarca, Producto> productoList;
    public static volatile SingularAttribute<Submarca, String> subMarca;
    public static volatile SingularAttribute<Submarca, Integer> idSubMarca;
    public static volatile SingularAttribute<Submarca, Marca> idMarca;

}