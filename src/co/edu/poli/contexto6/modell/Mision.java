
package co.edu.poli.contexto6.modell;


public class Mision {

    private String  id;
    private boolean prolongadas;
    private boolean criticas;
    private boolean peligrosas;
    private double  fechamicmo;
    private double  fechalimite;

    private Planeta planeta;

    public Mision() {}

    public Mision(String id, Planeta planeta) {
        this.id      = id;
        this.planeta = planeta;
    }

    public String  getId()                   { return id; }
    public void    setId(String id)          { this.id = id; }
    public Planeta getPlaneta()              { return planeta; }
    public void    setPlaneta(Planeta p)     { this.planeta = p; }
    public boolean isCriticas()              { return criticas; }
    public void    setCriticas(boolean b)    { this.criticas = b; }
    public boolean isPeligrosas()            { return peligrosas; }
    public void    setPeligrosas(boolean b)  { this.peligrosas = b; }

    public double calcularDuracion()   { return fechalimite - fechamicmo; }
    public double calcularRiesgo()     { return (criticas ? 1.5 : 1.0) * (peligrosas ? 2.0 : 1.0); }
    public double calcularEficiencia() { return prolongadas ? 0.8 : 1.0; }

    @Override
    public String toString() {
        return "Mision{id='" + id + "', planeta="
                + (planeta != null ? planeta.getNombre() : "N/A") + "}";
    }
}