package co.edu.poli.contexto6.servicios;

import co.edu.poli.contexto6.modell.Satelite;

/**
 * Representa el motor de propulsión asociado a un satélite dentro del sistema
 * de exploración espacial del Politécnico Colombiano.
 * <p>
 * {@code Motor} extiende {@link Satelite} y modela las propiedades físicas y operativas
 * de un motor espacial: su color, material de construcción y nivel de potencia.
 * Incorpora un contador estático propio que registra el número total de motores
 * instanciados, independiente del contador de {@link Satelite}.
 * Sobreescribe {@code encender()} y añade una versión sobrecargada que permite
 * especificar el modo de encendido.
 * </p>
 *
 * @author Julieta Villarraga Corredor
 * @since 2026
 * @version 1.0
 * @see Satelite
 */
public class Motor extends Satelite {

    /**
     * Color exterior del motor, usado para identificación visual
     * (por ejemplo: "rojo", "plateado").
     */
    private String color;

    /**
     * Material principal con el que está fabricado el motor
     * (por ejemplo: "titanio", "acero inoxidable").
     */
    private String material;

    /**
     * Nivel de potencia del motor. Los valores reconocidos son:
     * <ul>
     *   <li>{@code "Alta"} — factor de empuje 3.0</li>
     *   <li>{@code "Media"} — factor de empuje 2.0</li>
     *   <li>cualquier otro valor — factor de empuje 1.0 (potencia baja)</li>
     * </ul>
     */
    private String potencia;

    /**
     * Contador estático que registra el número total de instancias de {@code Motor}
     * creadas durante la ejecución del programa. Se incrementa en cada constructor.
     * Es independiente del {@code contadorMotores} de {@link Satelite}.
     */
    private static int contadorMotores = 0;

    // -------------------------------------------------------------------------
    // Constructores
    // -------------------------------------------------------------------------

    /**
     * Constructor por defecto. Crea un motor invocando el constructor por defecto
     * de {@link Satelite} e incrementa el contador de motores.
     */
    public Motor() {
        super();
        contadorMotores++;
    }

    /**
     * Constructor parametrizado. Crea un motor con sus propiedades físicas principales,
     * invocando el constructor por defecto de {@link Satelite} e incrementando
     * el contador de motores.
     *
     * @param color    color exterior del motor para identificación visual
     * @param material material principal de fabricación del motor
     * @param potencia nivel de potencia del motor: {@code "Alta"}, {@code "Media"}
     *                 o cualquier otro valor para potencia baja
     */
    public Motor(String color, String material, String potencia) {
        super();
        this.color    = color;
        this.material = material;
        this.potencia = potencia;
        contadorMotores++;
    }

    // -------------------------------------------------------------------------
    // Getters y Setters
    // -------------------------------------------------------------------------

    /**
     * Retorna el color exterior del motor.
     * Sobreescribe {@link co.edu.poli.contexto6.modell.Maquina#getColor()}
     * para devolver el color propio del motor en lugar del heredado.
     *
     * @return {@code String} con el color del motor
     */
    @Override
    public String getColor() { return color; }

    /**
     * Establece el color exterior del motor.
     * Sobreescribe {@link co.edu.poli.contexto6.modell.Maquina#setColor(String)}
     * para asignar el color propio del motor.
     *
     * @param c nuevo color del motor
     */
    @Override
    public void setColor(String c) { this.color = c; }

    /**
     * Retorna el material principal de fabricación del motor.
     * Sobreescribe {@link co.edu.poli.contexto6.modell.Maquina#getMaterial()}
     * para devolver el material propio del motor.
     *
     * @return {@code String} con el nombre del material
     */
    @Override
    public String getMaterial() { return material; }

    /**
     * Establece el material principal de fabricación del motor.
     * Sobreescribe {@link co.edu.poli.contexto6.modell.Maquina#setMaterial(String)}
     * para asignar el material propio del motor.
     *
     * @param m nombre del material (por ejemplo: "titanio", "aleación de aluminio")
     */
    @Override
    public void setMaterial(String m) { this.material = m; }

    /**
     * Retorna el nivel de potencia del motor.
     *
     * @return {@code String} con el nivel de potencia ("Alta", "Media" u otro)
     */
    public String getPotencia() { return potencia; }

    /**
     * Establece el nivel de potencia del motor.
     *
     * @param p nivel de potencia: {@code "Alta"}, {@code "Media"} o cualquier
     *          otro valor para indicar potencia baja
     */
    public void setPotencia(String p) { this.potencia = p; }

    /**
     * Retorna el número total de instancias de {@code Motor} creadas
     * desde el inicio de la ejecución del programa.
     *
     * @return {@code int} con el total de motores instanciados
     */
    public static int getContador() { return contadorMotores; }

    /**
     * Establece manualmente el contador de motores instanciados.
     * Al ser estático, el cambio afecta el valor compartido por toda la clase.
     *
     * @param v nuevo valor para el contador; debe ser mayor o igual a 0
     */
    public static void setContador(int v) { contadorMotores = v; }

    // -------------------------------------------------------------------------
    // Métodos de comportamiento
    // -------------------------------------------------------------------------

    /**
     * Calcula la fuerza de empuje del motor con base en su nivel de potencia
     * y la energía disponible heredada de {@link co.edu.poli.contexto6.modell.Maquina}.
     * <p>
     * Fórmula: {@code empuje = energia × factorPotencia}, donde:
     * </p>
     * <ul>
     *   <li>{@code "Alta"}  → factorPotencia = 3.0</li>
     *   <li>{@code "Media"} → factorPotencia = 2.0</li>
     *   <li>otro valor      → factorPotencia = 1.0</li>
     * </ul>
     * La comparación del nivel de potencia es insensible a mayúsculas/minúsculas.
     *
     * @return {@code double} con la fuerza de empuje en Newtons (N)
     */
    public double calcularempuje() {
        double nivel = potencia.equalsIgnoreCase("Alta") ? 3.0
                     : potencia.equalsIgnoreCase("Media") ? 2.0 : 1.0;
        return getEnergia() * nivel;
    }

    /**
     * Enciende el motor con potencia estándar y retorna un mensaje con sus
     * características físicas y el empuje calculado.
     * <p>
     * Sobreescribe {@link Satelite#encender()} para incluir el color, material,
     * nivel de potencia y la fuerza de empuje resultante del motor.
     * </p>
     *
     * @return {@code String} con el mensaje de encendido que incluye color, material,
     *         potencia y empuje en Newtons
     */
    @Override
    public String encender() {
        return "Motor [" + color + "/" + material + "] potencia: "
                + potencia + " | empuje: " + calcularempuje() + " N";
    }

    /**
     * Enciende el motor en un modo de operación específico (método sobrecargado).
     * <p>
     * Permite iniciar el motor bajo distintos modos operativos sin recalcular el empuje,
     * mostrando únicamente el modo seleccionado y la potencia base configurada.
     * </p>
     *
     * @param modo nombre del modo de encendido (por ejemplo: "manual", "automático", "emergencia")
     * @return {@code String} con el mensaje que indica el modo de encendido y la potencia base
     */
    public String encender(String modo) {
        return "Motor encendido en modo: " + modo + " | potencia base: " + potencia;
    }

    /**
     * Retorna una representación en texto de los atributos principales del motor,
     * incluyendo color, material, potencia y el total de motores instanciados.
     *
     * @return {@code String} con el resumen del motor
     */
    @Override
    public String toString() {
        return "Motor{color='" + color + "', material='" + material
                + "', potencia='" + potencia + "', contadorMotores=" + contadorMotores + "}";
    }
}