package Entidades;

import Entidades.Estadoplanilla;
import Entidades.Ruta;
import Entidades.Tarea;
import Entidades.Usuario;
import Entidades.Zona;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-04T17:45:39")
@StaticMetamodel(Planilla.class)
public class Planilla_ { 

    public static volatile ListAttribute<Planilla, Tarea> tareaList;
    public static volatile ListAttribute<Planilla, Ruta> rutaList;
    public static volatile SingularAttribute<Planilla, Integer> idPlanilla;
    public static volatile SingularAttribute<Planilla, Estadoplanilla> idEstadoPlanilla;
    public static volatile SingularAttribute<Planilla, Usuario> idUsuario;
    public static volatile SingularAttribute<Planilla, Zona> idZona;

}