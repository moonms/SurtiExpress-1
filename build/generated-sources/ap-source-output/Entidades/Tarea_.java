package Entidades;

import Entidades.Estadotarea;
import Entidades.Planilla;
import Entidades.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-04T17:45:39")
@StaticMetamodel(Tarea.class)
public class Tarea_ { 

    public static volatile SingularAttribute<Tarea, String> tarea;
    public static volatile SingularAttribute<Tarea, Planilla> idPlanilla;
    public static volatile SingularAttribute<Tarea, Integer> idTarea;
    public static volatile SingularAttribute<Tarea, Usuario> idUsuario;
    public static volatile SingularAttribute<Tarea, Estadotarea> idEstadoTarea;

}