package Entidades;

import Entidades.Submarca;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-04T17:45:39")
@StaticMetamodel(Marca.class)
public class Marca_ { 

    public static volatile SingularAttribute<Marca, String> marca;
    public static volatile SingularAttribute<Marca, Integer> idMarca;
    public static volatile ListAttribute<Marca, Submarca> submarcaList;

}