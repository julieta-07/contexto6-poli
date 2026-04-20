
package co.edu.poli.contexto6.servicios;

import co.edu.poli.contexto6.modell.Maquina;

/**
 * Define el contrato de operaciones de persistencia en archivo para colecciones
 * de máquinas espaciales en el sistema del Politécnico Colombiano.
 * <p>
 * Esta interfaz establece las operaciones de serialización y deserialización
 * que deben implementar todas las clases encargadas de guardar y recuperar
 * objetos {@link Maquina} en archivos del sistema. Permite desacoplar la lógica
 * de negocio del mecanismo concreto de almacenamiento utilizado.
 * </p>
 *
 * @author Julieta Villarraga Corredor
 * @since 2026
 * @version 1.0
 * @see Maquina
 * @see OperacionCRUD
 */
public interface OperacionArchivo {

    /**
     * Serializa un arreglo de objetos {@link Maquina} y lo guarda en un archivo
     * en la ruta y con el nombre indicados.
     * <p>
     * La implementación concreta determina el formato de serialización utilizado
     * (binario, texto, XML, JSON, etc.).
     * </p>
     *
     * @param maquinas arreglo de objetos {@link Maquina} a serializar;
     *                 puede contener posiciones {@code null}
     * @param path     ruta del directorio donde se guardará el archivo
     *                 (por ejemplo: {@code "src/datos/"}); no debe ser {@code null}
     * @param name     nombre del archivo de destino sin extensión
     *                 (por ejemplo: {@code "maquinas"}); no debe ser {@code null}
     * @return {@code String} con un mensaje que indica el resultado de la operación:
     *         éxito con la ruta completa del archivo generado, o descripción del error
     *         si la operación no pudo completarse
     */
    public String serializar(Maquina[] maquinas, String path, String name)
            throws IllegalArgumentException;

    /**
     * Deserializa y reconstruye un arreglo de objetos {@link Maquina} a partir
     * de un archivo ubicado en la ruta y con el nombre indicados.
     * <p>
     * La implementación concreta debe ser compatible con el formato utilizado
     * en {@link #serializar(Maquina[], String, String)}.
     * </p>
     *
     * @param path ruta del directorio donde se encuentra el archivo
     *             (por ejemplo: {@code "src/datos/"}); no debe ser {@code null}
     * @param name nombre del archivo a leer sin extensión
     *             (por ejemplo: {@code "maquinas"}); no debe ser {@code null}
     * @return arreglo de {@link Maquina} reconstruido a partir del archivo;
     *         {@code null} si el archivo no existe o si ocurrió un error durante
     *         la deserialización
     */
    public Maquina[] deserializar(String path, String name)
            throws IllegalArgumentException;
}