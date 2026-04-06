package co.edu.poli.contexto6.modell;

import java.io.Serializable;

/**
 * Representa una máquina dentro del sistema de exploración espacial del Politécnico Colombiano.
 * <p>
 * Esta clase modela las propiedades y comportamientos fundamentales de cualquier
 * máquina utilizada en misiones espaciales, incluyendo su ubicación, energía,
 * material de construcción y capacidad de encendido. Sirve como superclase base
 * para tipos específicos de máquinas espaciales como naves y satélites.
 * </p>
 *
 * @author Julieta Villarraga Corredor
 * @since 2026
 * @version 1.0
 */
public class Maquina implements Serializable {

    /**
     * Identificador único de la máquina.
     */
    private String id;

    /**
     * Ubicación actual de la máquina (por ejemplo: "Órbita baja terrestre", "Marte").
     */
    private String ubicacion;

    /**
     * Tamaño físico de la máquina, expresado en metros cúbicos.
     */
    private double tamano;

    /**
     * Fecha de fabricación o puesta en servicio de la máquina (formato: "dd/MM/yyyy").
     */
    private String fecha;

    /**
     * Nivel de energía disponible en la máquina, expresado en kilovatios (kW).
     */
    private double energia;

    /**
     * Material principal con el que está fabricada la máquina.
     */
    private String material;

    /**
     * Resistencia estructural de la máquina, expresada en megapascales (MPa).
     */
    private double resistencia;

    /**
     * Trayectoria programada o actual de la máquina en el espacio.
     */
    private String trayectoria;

    /**
     * Color exterior de la máquina.
     */
    private String color;

    /**
     * Nivel de combustible disponible en la máquina, expresado en litros.
     */
    private double combustible;

    /**
     * Tipo o referencia del motor que impulsa la máquina.
     */
    private String motor;

    /**
     * Contador estático del total de máquinas creadas.
     */
    private static int totalMaquinas = 0;

    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------

    /**
     * Constructor por defecto.
     */
    public Maquina() {
        totalMaquinas++;
    }

    /**
     * Constructor parametrizado.
     *
     * @param ubicacion ubicación inicial
     * @param energia energía inicial
     * @param material material principal
     */
    public Maquina(String ubicacion, double energia, String material) {
        this.ubicacion = ubicacion;
        this.energia = energia;
        this.material = material;
        totalMaquinas++;
    }

    // -------------------------------------------------------------------------
    // Getters y Setters
    // -------------------------------------------------------------------------

    /**
     * Retorna el ID de la máquina.
     *
     * @return ID de la máquina
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el ID de la máquina.
     *
     * @param id nuevo identificador
     */
    public void setId(String id) {
        this.id = id;
    }

    public String getUbicacion() { return ubicacion; }

    public void setUbicacion(String u) { this.ubicacion = u; }

    public double getTamano() { return tamano; }

    public void setTamano(double t) { this.tamano = t; }

    public String getFecha() { return fecha; }

    public void setFecha(String f) { this.fecha = f; }

    public double getEnergia() { return energia; }

    public void setEnergia(double e) { this.energia = e; }

    public String getMaterial() { return material; }

    public void setMaterial(String m) { this.material = m; }

    public double getResistencia() { return resistencia; }

    public void setResistencia(double r) { this.resistencia = r; }

    public String getTrayectoria() { return trayectoria; }

    public void setTrayectoria(String t) { this.trayectoria = t; }

    public String getColor() { return color; }

    public void setColor(String c) { this.color = c; }

    public double getCombustible() { return combustible; }

    public void setCombustible(double c) { this.combustible = c; }

    public String getMotor() { return motor; }

    public void setMotor(String m) { this.motor = m; }

    public static int getTotalMaquinas() { return totalMaquinas; }

    // -------------------------------------------------------------------------
    // Métodos de comportamiento
    // -------------------------------------------------------------------------

    /**
     * Calcula el tiempo activo.
     *
     * @return tiempo activo estimado
     */
    public double calculartiempoactivo() {
        return energia * 0.5;
    }

    /**
     * Enciende la máquina.
     *
     * @return mensaje de encendido
     */
    public String encender() {
        return "Maquina encendida en: " + ubicacion;
    }

    /**
     * Sobrecarga de encendido con potencia.
     *
     * @param potencia factor de potencia
     * @return mensaje con potencia calculada
     */
    protected String encender(double potencia) {
        return "Encendido con potencia calculada: " + (energia * potencia);
    }

    /**
     * Representación en texto.
     *
     * @return datos principales
     */
    @Override
    public String toString() {
        return "Maquina{id='" + id + "', ubicacion='" + ubicacion
                + "', energia=" + energia
                + ", material='" + material
                + "', totalMaquinas=" + totalMaquinas + "}";
    }
}