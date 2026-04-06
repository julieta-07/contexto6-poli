package co.edu.poli.contexto6.modell;

/**
 * Representa una nave espacial dentro del sistema de exploración del Politécnico Colombiano.
 * <p>
 * {@code Nave} extiende {@link Maquina} añadiendo atributos propios de una aeronave espacial
 * como velocidad, tipo, capacidad de tripulación y la misión asignada. Sobreescribe los métodos
 * {@code calculartiempoactivo()} y {@code encender()} para adaptar su comportamiento
 * a las características específicas de una nave.
 * </p>
 *
 * @author Julieta Villarraga Corredor
 * @since 2026
 * @version 1.0
 * @see Maquina
 * @see Mision
 */
public class Nave extends Maquina {

    /**
     * Velocidad de desplazamiento de la nave, expresada en kilómetros por segundo (km/s).
     */
    private double velocidad;

    /**
     * Identificador único de la nave (por ejemplo: "NV-001", "COLUMBIA").
     */
    private String id;

    /**
     * Tipo o categoría de la nave (por ejemplo: "exploración", "carga", "transporte").
     */
    private String tipo;

    /**
     * Capacidad base de la nave en número de módulos o unidades de alojamiento.
     * La capacidad real de tripulantes se obtiene multiplicando este valor por 2.
     */
    private int capacidad;

    /**
     * Misión espacial actualmente asignada a la nave.
     * Puede ser {@code null} si la nave no tiene misión activa.
     */
    private Mision mision;

    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------

    /**
     * Constructor por defecto. Crea una nave invocando el constructor por defecto
     * de {@link Maquina}, con todos los atributos en sus valores predeterminados.
     */
    public Nave() {
        super();
    }

    /**
     * Constructor parametrizado. Crea una nave con sus atributos operativos principales,
     * invocando el constructor por defecto de {@link Maquina}.
     *
     * @param velocidad velocidad de la nave en km/s; debe ser mayor que 0
     * @param id        identificador único de la nave
     * @param tipo      tipo o categoría de la nave
     * @param capacidad capacidad base en módulos de alojamiento; debe ser mayor que 0
     */
    public Nave(double velocidad, String id, String tipo, int capacidad) {
        super();
        this.velocidad = velocidad;
        this.id        = id;
        this.tipo      = tipo;
        this.capacidad = capacidad;
    }

    // -------------------------------------------------------------------------
    // Getters y Setters
    // -------------------------------------------------------------------------

    /**
     * Retorna la velocidad de desplazamiento de la nave.
     *
     * @return {@code double} con la velocidad en km/s
     */
    public double getVelocidad() { return velocidad; }

    /**
     * Establece la velocidad de desplazamiento de la nave.
     *
     * @param v velocidad en km/s; debe ser mayor que 0
     */
    public void setVelocidad(double v) { this.velocidad = v; }

    /**
     * Retorna el identificador único de la nave.
     *
     * @return {@code String} con el ID de la nave
     */
    public String getId() { return id; }

    /**
     * Establece el identificador único de la nave.
     *
     * @param id nuevo identificador; no debe ser nulo ni vacío
     */
    public void setId(String id) { this.id = id; }

    /**
     * Retorna el tipo o categoría de la nave.
     *
     * @return {@code String} con el tipo de nave
     */
    public String getTipo() { return tipo; }

    /**
     * Establece el tipo o categoría de la nave.
     *
     * @param t tipo de nave (por ejemplo: "exploración", "carga", "transporte")
     */
    public void setTipo(String t) { this.tipo = t; }

    /**
     * Retorna la capacidad base de la nave en módulos de alojamiento.
     *
     * @return {@code int} con la capacidad base
     */
    public int getCapacidad() { return capacidad; }

    /**
     * Establece la capacidad base de la nave en módulos de alojamiento.
     *
     * @param c capacidad base; debe ser un valor entero mayor que 0
     */
    public void setCapacidad(int c) { this.capacidad = c; }

    /**
     * Retorna la misión espacial actualmente asignada a la nave.
     *
     * @return objeto {@link Mision} asignado, o {@code null} si no hay misión activa
     */
    public Mision getMision() { return mision; }

    /**
     * Asigna una misión espacial a la nave.
     *
     * @param m objeto {@link Mision} que se desea asignar a la nave
     */
    public void setMision(Mision m) { this.mision = m; }

    // -------------------------------------------------------------------------
    // Métodos de comportamiento
    // -------------------------------------------------------------------------

    /**
     * Calcula la capacidad máxima de tripulantes que puede alojar la nave.
     * <p>
     * Fórmula: {@code tripulantes = capacidad * 2}
     * </p>
     *
     * @return {@code int} con el número máximo de tripulantes
     */
    public int calcularCapacidadTripulantes() {
        return capacidad * 2;
    }

    /**
     * Calcula el tiempo estimado de viaje para recorrer una distancia dada
     * a la velocidad actual de la nave.
     * <p>
     * Fórmula: {@code tiempo = distancia / velocidad}
     * </p>
     *
     * @param distancia distancia a recorrer en kilómetros; debe ser mayor que 0
     * @return {@code double} con el tiempo estimado en segundos;
     *         puede lanzar {@link ArithmeticException} implícita si {@code velocidad} es 0
     */
    public double calcularVelocidad(double distancia) {
        return distancia / velocidad;
    }

    /**
     * Calcula el tiempo activo estimado de la nave considerando su energía disponible
     * y su velocidad de desplazamiento.
     * <p>
     * Sobreescribe el método {@link Maquina#calculartiempoactivo()} para adaptar
     * el cálculo a las características de una nave espacial.
     * </p>
     * <p>
     * Fórmula: {@code tiempoActivo = (energia / velocidad) * 100}
     * </p>
     *
     * @return {@code double} con el tiempo activo estimado en horas
     */
    @Override
    public double calculartiempoactivo() {
        return getEnergia() / velocidad * 100;
    }

    /**
     * Enciende la nave y retorna un mensaje de confirmación con sus datos operativos.
     * <p>
     * Sobreescribe el método {@link Maquina#encender()} para incluir el identificador,
     * el tipo y la velocidad específicos de la nave.
     * </p>
     *
     * @return {@code String} con el mensaje de encendido que incluye ID, tipo y velocidad
     */
    @Override
    public String encender() {
        return "Nave [" + id + "] tipo '" + tipo + "' encendida | velocidad: " + velocidad + " km/s";
    }

    /**
     * Retorna una representación en texto de los atributos principales de la nave,
     * incluyendo ID, tipo, velocidad, capacidad y ubicación heredada de {@link Maquina}.
     *
     * @return {@code String} con el resumen de los atributos de la nave
     */
    @Override
    public String toString() {
        return "Nave{id='" + id + "', tipo='" + tipo + "', velocidad=" + velocidad
                + ", capacidad=" + capacidad + ", ubicacion='" + getUbicacion() + "'}";
    }
}