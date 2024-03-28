public class Cliente {
    private String cedula;
    private String nombre;
    private long ingresos;
    private String fecha;
    
    public Cliente(String cedula, String nombre, long ingresos, String fecha) {
        this.cedula = cedula;
        this.nombre = nombre;
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
    public long getIngresos() {
        return ingresos;
    }
    public void setIngresos(long ingresos) {
        this.ingresos = ingresos;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    



}
