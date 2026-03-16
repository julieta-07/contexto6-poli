
package co.edu.poli.contexto6.modell;

public class Satelite extends Maquina {

    private String id;

    private static int contadorMotores = 0;

    public Satelite() {
        super();
    }

    public Satelite(String id) {
        super();
        this.id = id;
    }
    public String getId()                           { return id; }
    public void   setId(String id)                  { this.id = id; }

    public static int  getContadorMotores()         { return contadorMotores; }
    public static void setContadorMotores(int valor){ contadorMotores = valor; }

    public double calcularorbita() {
        if (contadorMotores == 0) return 0.0;
        return (getEnergia() * 3.5) / contadorMotores;
    }

    @Override
    public double calculartiempoactivo() {
        return getEnergia() * 2.0;
    }

    @Override
    public String encender() {
        return "Satelite [" + id + "] activado | orbita: " + getUbicacion();
    }

    @Override
    public String toString() {
        return "Satelite{id='" + id + "', energia=" + getEnergia()
                + ", ubicacion='" + getUbicacion() + "', contadorMotores=" + contadorMotores + "}";
    }
}