package co.edu.poli.contexto6.modell;

/**
 * Representa un satélite artificial dentro del sistema de exploración espacial
 * del Politécnico Colombiano.
 * <p>
 * {@code Satelite} extiende {@link Maquina} especializando su comportamiento para
 * cuerpos orbitales artificiales. Incorpora un contador estático compartido entre
 * todas las instancias que registra el número de motores activos en el sistema,
 * el cual se utiliza para calcular la estabilidad orbital del satélite.
 * Sobreescribe los métodos {@code calculartiempoactivo()} y {@code encender()}
 * con lógica propia de un satélite en órbita.
 * </p>
 *
 * @author Julieta Villarraga Corredor
 * @since 2026
 * @version 1.0
 * @see Maquina
 */
public class Satelite extends Maquina {

    /**
     * Identificador único del satélite (por ejemplo: "SAT-001", "EXPLORER-III").
     */
    private String id;

    /**
     * Contador estático que registra el número total de motores activos
     * en el sistema de satélites. Es compartido por todas las instancias de
     * {@code Satelite} y se utiliza en el cálculo de la órbita.
     * Su valor por defecto es 0.
     */
    private static int contadorMotores = 0;

    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------

    /**
     * Constructor por defecto. Crea un satélite invocando el constructor por defecto
     * de {@link Maquina}, con todos sus atributos en sus valores predeterminados.
     */
    public Satelite() {
        super();
    }

    /**
     * Constructor parametrizado. Crea un satélite con su identificador único,
     * invocando el constructor por defecto de {@link Maquina}.
     *
     * @param id identificador único del satélite; no debe ser nulo ni vacío
     */
    public Satelite(String id) {
        super();
        this.id = id;
    }

    // -------------------------------------------------------------------------
    // Getters y Setters
    // -------------------------------------------------------------------------

    /**
     * Retorna el identificador único del satélite.
     *
     * @return {@code String} con el ID del satélite
     */
    public String getId() { return id; }

    /**
     * Establece el identificador único del satélite.
     *
     * @param id nuevo identificador; no debe ser nulo ni vacío
     */
    public void setId(String id) { this.id = id; }

    /**
     * Retorna el número total de motores activos registrados en el sistema.
     * Al ser un atributo estático, refleja el valor compartido por todas las
     * instancias de {@code Satelite}.
     *
     * @return {@code int} con el número de motores activos
     */
    public static int getContadorMotores() { return contadorMotores; }

    /**
     * Establece manualmente el número total de motores activos en el sistema.
     * Al ser un atributo estático, el cambio afecta a todas las instancias
     * de {@code Satelite}.
     *
     * @param valor nuevo valor para el contador de motores; debe ser mayor o igual a 0
     */
    public static void setContadorMotores(int valor) { contadorMotores = valor; }

    // -------------------------------------------------------------------------
    // Métodos de comportamiento
    // -------------------------------------------------------------------------

    /**
     * Calcula la estabilidad orbital del satélite con base en su energía disponible
     * y el número de motores activos en el sistema.
     * <p>
     * Fórmula: {@code orbita = (energia × 3.5) / contadorMotores}
     * </p>
     * Si {@code contadorMotores} es 0, retorna 0.0 para evitar división por cero.
     *
     * @return {@code double} con el índice de estabilidad orbital;
     *         retorna {@code 0.0} si no hay motores activos registrados
     */
    public double calcularorbita() {
        if (contadorMotores == 0) return 0.0;
        return (getEnergia() * 3.5) / contadorMotores;
    }

    /**
     * Calcula el tiempo activo estimado del satélite con base en su energía disponible.
     * <p>
     * Sobreescribe el método {@link Maquina#calculartiempoactivo()} aplicando
     * un factor mayor (×2.0) respecto a la superclase, ya que los satélites
     * operan en modo pasivo de mayor duración.
     * </p>
     * <p>
     * Fórmula: {@code tiempoActivo = energia × 2.0}
     * </p>
     *
     * @return {@code double} con el tiempo activo estimado en horas
     */
    @Override
    public double calculartiempoactivo() {
        return getEnergia() * 2.0;
    }

    /**
     * Activa el satélite y retorna un mensaje de confirmación con su identificador
     * y la órbita en la que se encuentra.
     * <p>
     * Sobreescribe el método {@link Maquina#encender()} para adaptar el mensaje
     * al contexto de un satélite orbital, usando la ubicación heredada de
     * {@link Maquina} como referencia de órbita.
     * </p>
     *
     * @return {@code String} con el mensaje de activación que incluye ID y órbita actual
     */
    @Override
    public String encender() {
        return "Satelite [" + id + "] activado | orbita: " + getUbicacion();
    }

    /**
     * Retorna una representación en texto de los atributos principales del satélite,
     * incluyendo ID, energía, ubicación (órbita) y el número de motores activos.
     *
     * @return {@code String} con el resumen del satélite
     */
    @Override
    public String toString() {
        return "Satelite{id='" + id + "', energia=" + getEnergia()
                + ", ubicacion='" + getUbicacion() + "', contadorMotores=" + contadorMotores + "}";
    }
}