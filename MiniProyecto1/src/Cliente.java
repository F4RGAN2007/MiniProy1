import java.util.Date;
import java.text.SimpleDateFormat;

public class Cliente {
    private String cedula;
    private String nombre;
    private long ahorro;
    private int ingresos;
    private String fecha;
    
    public Cliente(String cedula, String nombre, long ahorro ,int ingresos, String fecha) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.ahorro = ahorro;
        this.ingresos = ingresos;
        this.fecha = fecha;
    }

    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public long getAhorro() {
        return ahorro;
    }
    public void setAhorro(long ahorro) {
        this.ahorro = ahorro;
    }
    public long getIngresos() {
        return ingresos;
    }
    public void setIngresos(int ingresos) {
        this.ingresos = ingresos;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha() {
        /*Usa la libreria Date para obtener la fecha actual */
        Date fechaSistema = new Date();
        /*Usa SimpleDateFormat para determinar el format en String */
        SimpleDateFormat DMY = new SimpleDateFormat("dd-MM-yyyy");
        /*Transforma la variable de tipo DAte a String */
        this.fecha = DMY.format(fechaSistema) ;
    }
}
