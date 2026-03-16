
package co.edu.poli.contexto6.modell;


public class Nave extends Maquina {

    private double velocidad;
    private String id;
    private String tipo;
    private int    capacidad;

    private Mision mision;

    
    public Nave() {
        super();
    }

    
    public Nave(double velocidad, String id, String tipo, int capacidad) {
        super();
        this.velocidad = velocidad;
        this.id        = id;
        this.tipo      = tipo;
        this.capacidad = capacidad;
    }

    
    public double getVelocidad()           { return velocidad; }
    public void   setVelocidad(double v)   { this.velocidad = v; }

    public String getId()                  { return id; }
    public void   setId(String id)         { this.id = id; }

    public String getTipo()                { return tipo; }
    public void   setTipo(String t)        { this.tipo = t; }

    public int    getCapacidad()           { return capacidad; }
    public void   setCapacidad(int c)      { this.capacidad = c; }

    public Mision getMision()              { return mision; }
    public void   setMision(Mision m)      { this.mision = m; }

    
    public int    calcularCapacidadTripulantes() { return capacidad * 2; }
    public double calcularVelocidad(double distancia) { return distancia / velocidad; }

    
    @Override
    public double calculartiempoactivo() {
        return getEnergia() / velocidad * 100;
    }

    
    @Override
    public String encender() {
        return "Nave [" + id + "] tipo '" + tipo + "' encendida | velocidad: " + velocidad + " km/s";
    }

    
    @Override
    public String toString() {
        return "Nave{id='" + id + "', tipo='" + tipo + "', velocidad=" + velocidad
                + ", capacidad=" + capacidad + ", ubicacion='" + getUbicacion() + "'}";
    }
}