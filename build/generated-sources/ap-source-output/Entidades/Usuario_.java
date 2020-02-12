package Entidades;

import Entidades.Pedido;
import Entidades.Planilla;
import Entidades.Rol;
import Entidades.Tarea;
import Entidades.Tipodocumento;
import Entidades.Vehiculo;
import Entidades.Zona;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-12T08:07:40")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> barrio;
    public static volatile SingularAttribute<Usuario, Rol> idRol;
    public static volatile SingularAttribute<Usuario, Vehiculo> idVehiculo;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile SingularAttribute<Usuario, String> direccion;
    public static volatile SingularAttribute<Usuario, Integer> documento;
    public static volatile ListAttribute<Usuario, Pedido> pedidoList;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile ListAttribute<Usuario, Planilla> planillaList;
    public static volatile SingularAttribute<Usuario, String> rut;
    public static volatile ListAttribute<Usuario, Tarea> tareaList;
    public static volatile SingularAttribute<Usuario, String> razonSocial;
    public static volatile SingularAttribute<Usuario, String> apellido;
    public static volatile SingularAttribute<Usuario, String> correo;
    public static volatile SingularAttribute<Usuario, Tipodocumento> idTipoDocumento;
    public static volatile SingularAttribute<Usuario, String> contrasena;
    public static volatile SingularAttribute<Usuario, Zona> idZona;
    public static volatile SingularAttribute<Usuario, Integer> telefono;

}