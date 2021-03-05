package Apoyo;

import Modelo.Cliente;
import Modelo.Hospedaje;
import Modelo.Login.Usuario;
import Modelo.Servicios.Habitacion;
import Modelo.Servicios.TipoHabitacion;
import Modelo.TiposCliente;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/* @author MeloDev */
public class Formateo {
    
    public Date LocalDateTime_to_Date(LocalDateTime d){
        DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtfFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        String fechaEnTexto = d.format(dtfFecha);
        
        Date fecha = null;
        
        try {
            fecha = formato.parse(fechaEnTexto);
        } catch (ParseException ex) {
            Logger.getLogger(Formateo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return fecha;
    }
    
    public int LocalDateTime_to_Horas(LocalDateTime d){
        DateTimeFormatter dtfHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        return Integer.valueOf(d.format(dtfHora).split(":")[0]);
    }
    public int LocalDateTime_to_Minutos(LocalDateTime d){
        DateTimeFormatter dtfHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        return Integer.valueOf(d.format(dtfHora).split(":")[1]);
    }
    
    
    public String Date_to_String(Date d){
        DateFormat fechaEnString = new SimpleDateFormat("yyyy-MM-dd");
           
        return fechaEnString.format(d);
    }
    
    public String DateTime_to_timeStamp(LocalDateTime fecha){
        //formato del timeStamp 2021-03-01 19:58:40
        
        DateTimeFormatter dtfFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dtfHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        return fecha.format(dtfFecha)+" "+fecha.format(dtfHora);
    }
    
    public LocalDateTime timeStamp_to_DateTime(String fechaBD){
        //formato del timeStamp 2021-03-01 19:58:40
        
        LocalDate fecha = LocalDate.parse(fechaBD.split(" ")[0]);
        LocalTime hora  = LocalTime.parse(fechaBD.split(" ")[1]);
        
        return LocalDateTime.of(fecha, hora);
    }
    
    public LocalDateTime formatoUTC_0(LocalDateTime fecha){
        ZoneId oldZone = ZoneId.systemDefault();
        ZoneId newZone = ZoneId.of("GMT+0");
                
        LocalDateTime nowUTC0 = fecha.atZone(oldZone)
                                    .withZoneSameInstant(newZone)
                                    .toLocalDateTime();
        
        return nowUTC0;
    }
    
    public LocalDateTime formatoUTC0_to_Actual(LocalDateTime fecha){
        ZoneId zonaSistema = ZoneId.systemDefault();
        ZoneId oldZone = ZoneId.of("GMT+0");//ZoneId de la bd
                
        LocalDateTime nowUTCsys = fecha.atZone(oldZone)
                                    .withZoneSameInstant(zonaSistema)
                                    .toLocalDateTime();
        
        return nowUTCsys;
    }
    
    public Object[][] formatoJtableHospedajes(ArrayList<Hospedaje> hospedajes){
        Object[][] H = new Object[hospedajes.size()][7];
        
        int i=0;
        for (Hospedaje hos : hospedajes) {
            H[i][0]=hos.getIdHospedaje();
            H[i][1]=hos.getTipo().name();
            String nombre =hos.getCliente().getApellidos();
            if (hos.getCliente().getNombres()!=null) {
                nombre = nombre+" "+hos.getCliente().getNombres();
            }
            H[i][2]=nombre;
            H[i][3]=DateTime_to_timeStamp(hos.getfHEntrada());
            H[i][4]= DateTime_to_timeStamp(hos.getfHSalida());           
            H[i][5]=hos.getHabitacion().getIdHabitacion();
            H[i][6]=hos.getUser().getIdUsuario();
            i++;
        }
       
        return H;
    }

    
    public String[] formatoJtableTiposHab(ArrayList<TipoHabitacion> tipos){
        String[] lista = new String[tipos.size()];
        int i=0;
        for (TipoHabitacion t : tipos) {
            lista[i]=t.getIdTipo()+"-"+t.getNombreTipo();
            i++;
        }
        return lista;
    }

    public Object[][] formatoJtableHabitaciones(ArrayList<Habitacion> habitaciones){
        Object[][] H = new Object[habitaciones.size()][5];
        
        int i=0;
        for (Habitacion hab : habitaciones) {
            H[i][0]=hab.getIdHabitacion();
            H[i][1]=hab.getNombreTipo();
            H[i][2]=hab.getDescripcion();
            H[i][3]=hab.getPrecio();
            H[i][4]=hab.getNombreEstado();
            i++;
        }
       
        return H;
    }
    
    public Object[][] formatoJtableUsuarios(ArrayList<Usuario> usuarios){
        Object[][] U = new Object[usuarios.size()][5];
        
        int i=0;
        for (Usuario u : usuarios) {
            U[i][0]=u.getIdUsuario();
            U[i][1]=u.getNombreUsuario();
            U[i][2]=u.getNombreCuenta();
            U[i][3]=u.getTipoUsuario().name();
            U[i][4]=u.isActivo();
            i++;
        }
       
        return U;
    }

    public Object[][] formatoJtableClientes(ArrayList<Cliente> clientes) {
        Object[][] C = new Object[clientes.size()][5];
        
        int i=0;
        for (Cliente c : clientes) {
            C[i][0]=c.getIdCliente();
            C[i][1]=c.getApellidos()+" "+c.getNombres();
            C[i][2]=c.getTipo().name();
            C[i][3]=c.getTipoDocumento();
            C[i][4]=c.getNumDocumento();
            i++;
        }
       
        return C;
    }

    public String[] formatoJtableTiposCli(TiposCliente[] values) {
        String[] tipos = new String[TiposCliente.values().length];
        int i =0;
        for (TiposCliente tipo : TiposCliente.values()) {
            tipos[i]=tipo.name();
            i++;
        }
        return tipos;
    }
    
}
