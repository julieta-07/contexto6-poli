package co.edu.poli.contexto6.modell;

/**
 * Representa un planeta dentro del sistema de exploración espacial del Politécnico Colombiano.
 * <p>
 * Modela las propiedades físicas y astronómicas de un cuerpo planetario, como su masa,
 * radio y nivel de radiación. A partir de estos datos permite calcular indicadores
 * operativos clave para las misiones: gravedad superficial, habitabilidad y nivel de peligro.
 * </p>
 *
 * @author Julieta Villarraga Corredor
 * @since 2026
 * @version 1.0
 * @see Mision
 */
public class Planeta {

    /**
     * Nombre común del planeta (por ejemplo: "Marte", "Europa", "Kepler-452b").
     */
    private String nombre;

    /**
     * Identificador único del planeta dentro del sistema (por ejemplo: "PLN-001").
     */
    private String id;

    /**
     * Masa del planeta expresada en kilogramos (kg).
     * Se utiliza para calcular la gravedad superficial.
     */
    private double masa;

    /**
     * Radio medio del planeta expresado en metros (m).
     * Se utiliza para calcular la gravedad superficial.
     * Debe ser mayor que 0 para obtener un resultado válido.
     */
    private double radio;

    /**
     * Nivel de radiación superficial del planeta, expresado en milisieverts por hora (mSv/h).
     * Valores menores a 50 indican condiciones habitables para la tripulación.
     */
    private double radiacion;

    /**
     * Ubicación del planeta en el sistema solar o galáctico
     * (por ejemplo: "Sistema Solar - cinturón interior", "Galaxia Andrómeda").
     */
    private String ubicacion;

    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------

    /**
     * Constructor por defecto. Crea un planeta con todos sus atributos
     * en sus valores predeterminados.
     */
    public Planeta() {}

    /**
     * Constructor parametrizado. Crea un planeta con su nombre e identificador.
     *
     * @param nombre nombre común del planeta; no debe ser nulo ni vacío
     * @param id     identificador único del planeta; no debe ser nulo ni vacío
     */
    public Planeta(String nombre, String id) {
        this.nombre = nombre;
        this.id     = id;
    }

    // -------------------------------------------------------------------------
    // Getters y Setters
    // -------------------------------------------------------------------------

    /**
     * Retorna el nombre común del planeta.
     *
     * @return {@code String} con el nombre del planeta
     */
    public String getNombre() { return nombre; }

    /**
     * Establece el nombre común del planeta.
     *
     * @param n nombre del planeta; no debe ser nulo ni vacío
     */
    public void setNombre(String n) { this.nombre = n; }

    /**
     * Retorna el identificador único del planeta.
     *
     * @return {@code String} con el ID del planeta
     */
    public String getId() { return id; }

    /**
     * Establece el identificador único del planeta.
     *
     * @param id nuevo identificador; no debe ser nulo ni vacío
     */
    public void setId(String id) { this.id = id; }

    /**
     * Retorna la masa del planeta.
     *
     * @return {@code double} con la masa en kilogramos (kg)
     */
    public double getMasa() { return masa; }

    /**
     * Establece la masa del planeta.
     *
     * @param m masa en kilogramos (kg); debe ser mayor que 0
     */
    public void setMasa(double m) { this.masa = m; }

    /**
     * Retorna el radio medio del planeta.
     *
     * @return {@code double} con el radio en metros (m)
     */
    public double getRadio() { return radio; }

    /**
     * Establece el radio medio del planeta.
     *
     * @param r radio en metros (m); debe ser mayor que 0 para cálculos válidos
     */
    public void setRadio(double r) { this.radio = r; }

    /**
     * Retorna el nivel de radiación superficial del planeta.
     *
     * @return {@code double} con la radiación en milisieverts por hora (mSv/h)
     */
    public double getRadiacion() { return radiacion; }

    /**
     * Establece el nivel de radiación superficial del planeta.
     *
     * @param r nivel de radiación en mSv/h; debe ser mayor o igual a 0
     */
    public void setRadiacion(double r) { this.radiacion = r; }

    /**
     * Retorna la ubicación del planeta en el sistema solar o galáctico.
     *
     * @return {@code String} con la descripción de la ubicación
     */
    public String getUbicacion() { return ubicacion; }

    /**
     * Establece la ubicación del planeta en el sistema solar o galáctico.
     *
     * @param u descripción de la ubicación astronómica del planeta
     */
    public void setUbicacion(String u) { this.ubicacion = u; }

    // -------------------------------------------------------------------------
    // Métodos de comportamiento
    // -------------------------------------------------------------------------

    /**
     * Calcula la gravedad superficial del planeta aplicando la Ley de Gravitación Universal.
     * <p>
     * Fórmula: {@code g = (masa / radio²) × G}, donde G = 6.674×10⁻¹¹ N·m²/kg²
     * </p>
     * Si el radio es 0 o negativo, retorna 0 para evitar división por cero.
     *
     * @return {@code double} con la gravedad superficial en m/s²;
     *         retorna 0 si {@code radio} es menor o igual a 0
     */
    public double calcularGravedad() {
        return radio > 0 ? masa / (radio * radio) * 6.674e-11 : 0;
    }

    /**
     * Determina si el planeta es habitable para la tripulación con base en
     * su nivel de radiación superficial.
     * <p>
     * Criterio: un planeta es habitable si su radiación es menor a 50 mSv/h.
     * </p>
     *
     * @return {@code 1.0} si el planeta es habitable (radiación &lt; 50 mSv/h);
     *         {@code 0.0} si no es habitable
     */
    public double calcularHabitabilidad() {
        return radiacion < 50 ? 1.0 : 0.0;
    }

    /**
     * Calcula el nivel de peligro del planeta para una misión tripulada,
     * proporcional a su nivel de radiación superficial.
     * <p>
     * Fórmula: {@code peligro = radiacion × 0.1}
     * </p>
     *
     * @return {@code double} con el índice de peligro del planeta;
     *         valores más altos indican mayor riesgo para la tripulación
     */
    public double calcularPeligro() {
        return radiacion * 0.1;
    }

    /**
     * Retorna una representación en texto de los atributos principales del planeta,
     * incluyendo nombre, ID y masa.
     *
     * @return {@code String} con el resumen del planeta
     */
    @Override
    public String toString() {
        return "Planeta{nombre='" + nombre + "', id='" + id + "', masa=" + masa + "}";
    }
}