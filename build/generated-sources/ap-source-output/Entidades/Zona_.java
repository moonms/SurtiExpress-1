package Entidades;

import Entidades.Planilla;
import Entidades.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-12T08:07:40")
@StaticMetamodel(Zona.class)
public class Zona_ { 

    public static volatile SingularAttribute<Zona, String> zona;
    public static volatile ListAttribute<Zona, Usuario> usuarioList;
    public static volatile SingularAttribute<Zona, Integer> idZona;
    public static volatile ListAttribute<Zona, Planilla> planillaList;

}