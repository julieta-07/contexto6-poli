
package co.edu.poli.contexto6.servicios;

import co.edu.poli.contexto6.modell.Satelite;

public class Motor extends Satelite {

    private String color;
    private String material;
    private String potencia;

    private static int contadorMotores = 0;

    public Motor() {
        super();
        contadorMotores++;
    }

    public Motor(String color, String material, String potencia) {
        super();
        this.color    = color;
        this.material = material;
        this.potencia = potencia;
        contadorMotores++;
    }

    @Override
    public String getColor(){ return color; }
    @Override
    public void   setColor(String c)      { this.color = c; }
    @Override
    public String getMaterial()           { return material; }
    @Override
    public void   setMaterial(String m)   { this.material = m; }

    public String getPotencia()           { return potencia; }
    public void   setPotencia(String p)   { this.potencia = p; }

    public static int  getContador()      { return contadorMotores; }
    public static void setContador(int v) { contadorMotores = v; }

    public double calcularempuje() {
        double nivel = potencia.equalsIgnoreCase("Alta") ? 3.0
                     : potencia.equalsIgnoreCase("Media") ? 2.0 : 1.0;
        return getEnergia() * nivel;
    }

    @Override
    public String encender() {
        return "Motor [" + color + "/" + material + "] potencia: "
                + potencia + " | empuje: " + calcularempuje() + " N";
    }

    public String encender(String modo) {
        return "Motor encendido en modo: " + modo + " | potencia base: " + potencia;
    }

    @Override
    public String toString() {
        return "Motor{color='" + color + "', material='" + material
                + "', potencia='" + potencia + "', contadorMotores=" + contadorMotores + "}";
    }
}