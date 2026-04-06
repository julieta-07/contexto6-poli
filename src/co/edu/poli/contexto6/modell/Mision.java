package co.edu.poli.contexto6.modell;

/**
 * Representa una misión espacial dentro del sistema de exploración del Politécnico Colombiano.
 * <p>
 * Una misión agrupa las características operativas de una expedición espacial,
 * incluyendo su clasificación de riesgo, duración estimada y el planeta destino.
 * Permite calcular indicadores clave como duración, nivel de riesgo y eficiencia
 * de ejecución según las condiciones de la misión.
 * </p>
 *
 * @author Julieta Villarraga Corredor
 * @since 2026
 * @version 1.0
 */
public class Mision {

    /**
     * Identificador único de la misión (por ejemplo: "MSN-001", "APOLO-XIII").
     */
    private String id;

    /**
     * Indica si la misión es de larga duración (prolongada).
     * Afecta el cálculo de eficiencia: las misiones prolongadas reducen la eficiencia a 0.8.
     */
    private boolean prolongadas;

    /**
     * Indica si la misión es crítica para los objetivos de la organización.
     * Las misiones críticas incrementan el factor de riesgo en 1.5.
     */
    private boolean criticas;

    /**
     * Indica si la misión implica condiciones peligrosas para la tripulación o el equipo.
     * Las misiones peligrosas duplican el factor de riesgo (×2.0).
     */
    private boolean peligrosas;

    /**
     * Fecha de inicio de la misión, expresada como número de días desde una época de referencia.
     * (Nombre: fecha mínima o de comienzo — "fechamicmo").
     */
    private double fechamicmo;

    /**
     * Fecha límite o de finalización prevista de la misión,
     * expresada como número de días desde la misma época de referencia.
     */
    private double fechalimite;

    /**
     * Planeta destino al que se dirige la misión.
     * Puede ser {@code null} si aún no se ha asignado un destino.
     */
    private Planeta planeta;

    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------

    /**
     * Constructor por defecto. Crea una misión con todos sus atributos
     * en sus valores predeterminados.
     */
    public Mision() {}

    /**
     * Constructor parametrizado. Crea una misión con su identificador
     * y el planeta destino asignado.
     *
     * @param id      identificador único de la misión
     * @param planeta planeta destino de la misión
     */
    public Mision(String id, Planeta planeta) {
        this.id      = id;
        this.planeta = planeta;
    }

    // -------------------------------------------------------------------------
    // Getters y Setters
    // -------------------------------------------------------------------------

    /**
     * Retorna el identificador único de la misión.
     *
     * @return {@code String} con el ID de la misión
     */
    public String getId() { return id; }

    /**
     * Establece el identificador único de la misión.
     *
     * @param id nuevo identificador de la misión; no debe ser nulo ni vacío
     */
    public void setId(String id) { this.id = id; }

    /**
     * Retorna el planeta destino asignado a la misión.
     *
     * @return objeto {@link Planeta} destino, o {@code null} si no se ha asignado
     */
    public Planeta getPlaneta() { return planeta; }

    /**
     * Establece el planeta destino de la misión.
     *
     * @param p objeto {@link Planeta} que representa el destino de la misión
     */
    public void setPlaneta(Planeta p) { this.planeta = p; }

    /**
     * Indica si la misión ha sido clasificada como crítica.
     *
     * @return {@code true} si la misión es crítica; {@code false} en caso contrario
     */
    public boolean isCriticas() { return criticas; }

    /**
     * Establece si la misión es crítica para los objetivos de la organización.
     *
     * @param b {@code true} para marcar la misión como crítica; {@code false} para desmarcarla
     */
    public void setCriticas(boolean b) { this.criticas = b; }

    /**
     * Indica si la misión implica condiciones peligrosas.
     *
     * @return {@code true} si la misión es peligrosa; {@code false} en caso contrario
     */
    public boolean isPeligrosas() { return peligrosas; }

    /**
     * Establece si la misión involucra condiciones peligrosas para la tripulación o el equipo.
     *
     * @param b {@code true} para marcar la misión como peligrosa; {@code false} para desmarcarla
     */
    public void setPeligrosas(boolean b) { this.peligrosas = b; }

    // -------------------------------------------------------------------------
    // Métodos de comportamiento
    // -------------------------------------------------------------------------

    /**
     * Calcula la duración estimada de la misión como la diferencia entre
     * la fecha límite y la fecha de inicio.
     * <p>
     * Fórmula: {@code duracion = fechalimite - fechamicmo}
     * </p>
     *
     * @return {@code double} con la duración en días; valor negativo indica fechas incorrectas
     */
    public double calcularDuracion() {
        return fechalimite - fechamicmo;
    }

    /**
     * Calcula el nivel de riesgo de la misión aplicando factores multiplicadores
     * según su clasificación.
     * <p>
     * Fórmula: {@code riesgo = (criticas ? 1.5 : 1.0) * (peligrosas ? 2.0 : 1.0)}
     * </p>
     * <ul>
     *   <li>Misión normal: factor 1.0</li>
     *   <li>Misión crítica: factor 1.5</li>
     *   <li>Misión peligrosa: factor 2.0</li>
     *   <li>Misión crítica y peligrosa: factor 3.0</li>
     * </ul>
     *
     * @return {@code double} con el factor de riesgo calculado (mínimo 1.0, máximo 3.0)
     */
    public double calcularRiesgo() {
        return (criticas ? 1.5 : 1.0) * (peligrosas ? 2.0 : 1.0);
    }

    /**
     * Calcula la eficiencia de ejecución de la misión según su duración.
     * <p>
     * Las misiones prolongadas operan con menor eficiencia debido al desgaste
     * acumulado de recursos y tripulación.
     * </p>
     * <ul>
     *   <li>Misión prolongada: eficiencia 0.8 (80%)</li>
     *   <li>Misión estándar: eficiencia 1.0 (100%)</li>
     * </ul>
     *
     * @return {@code double} con el índice de eficiencia (0.8 si es prolongada, 1.0 si no)
     */
    public double calcularEficiencia() {
        return prolongadas ? 0.8 : 1.0;
    }

    /**
     * Retorna una representación en texto de los atributos principales de la misión,
     * incluyendo el ID y el nombre del planeta destino.
     * Si el planeta no ha sido asignado, muestra "N/A".
     *
     * @return {@code String} con el resumen de la misión
     */
    @Override
    public String toString() {
        return "Mision{id='" + id + "', planeta="
                + (planeta != null ? planeta.getNombre() : "N/A") + "}";
    }
}