
package co.edu.poli.contexto6.modell;
public class Maquina {

    
    private String ubicacion;
    private double tamano;
    private String fecha;
    private double energia;
    private String material;
    private double resistencia;
    private String trayectoria;
    private String color;
    private double combustible;
    private String motor;

    private static int totalMaquinas = 0;

    
    public Maquina() {
        totalMaquinas++;
    }

    public Maquina(String ubicacion, double energia, String material) {
        this.ubicacion = ubicacion;
        this.energia   = energia;
        this.material  = material;
        totalMaquinas++;
    }

    public String getUbicacion()           { return ubicacion; }
    public void   setUbicacion(String u)   { this.ubicacion = u; }

    public double getTamano()              { return tamano; }
    public void   setTamano(double t)      { this.tamano = t; }

    public String getFecha()               { return fecha; }
    public void   setFecha(String f)       { this.fecha = f; }

    public double getEnergia()             { return energia; }
    public void   setEnergia(double e)     { this.energia = e; }

    public String getMaterial()            { return material; }
    public void   setMaterial(String m)    { this.material = m; }

    public double getResistencia()         { return resistencia; }
    public void   setResistencia(double r) { this.resistencia = r; }

    public String getTrayectoria()         { return trayectoria; }
    public void   setTrayectoria(String t) { this.trayectoria = t; }

    public String getColor()               { return color; }
    public void   setColor(String c)       { this.color = c; }

    public double getCombustible()         { return combustible; }
    public void   setCombustible(double c) { this.combustible = c; }

    public String getMotor()               { return motor; }
    public void   setMotor(String m)       { this.motor = m; }

    public static int getTotalMaquinas()   { return totalMaquinas; }

    public double calculartiempoactivo() {
        return energia * 0.5;
    }

    public String encender() {
        return "Maquina encendida en: " + ubicacion;
    }

    protected String encender(double potencia) {
        return "Encendido con potencia calculada: " + (energia * potencia);
    }

    @Override
    public String toString() {
        return "Maquina{ubicacion='" + ubicacion + "', energia=" + energia
                + ", material='" + material + "', totalMaquinas=" + totalMaquinas + "}";
    }
}