
package co.edu.poli.contexto6.modell;

public class Planeta {

    private String nombre;
    private String id;
    private double masa;
    private double radio;
    private double radiacion;
    private String ubicacion;

    public Planeta() {}

    public Planeta(String nombre, String id) {
        this.nombre = nombre;
        this.id     = id;
    }

    public String getNombre()            { return nombre; }
    public void   setNombre(String n)    { this.nombre = n; }
    public String getId()                { return id; }
    public void   setId(String id)       { this.id = id; }
    public double getMasa()              { return masa; }
    public void   setMasa(double m)      { this.masa = m; }
    public double getRadio()             { return radio; }
    public void   setRadio(double r)     { this.radio = r; }
    public double getRadiacion()         { return radiacion; }
    public void   setRadiacion(double r) { this.radiacion = r; }
    public String getUbicacion()         { return ubicacion; }
    public void   setUbicacion(String u) { this.ubicacion = u; }

    public double calcularGravedad()     { return radio > 0 ? masa / (radio * radio) * 6.674e-11 : 0; }
    public double calcularHabitabilidad(){ return radiacion < 50 ? 1.0 : 0.0; }
    public double calcularPeligro()      { return radiacion * 0.1; }

    @Override
    public String toString() {
        return "Planeta{nombre='" + nombre + "', id='" + id + "', masa=" + masa + "}";
    }
}