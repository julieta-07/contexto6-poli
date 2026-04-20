package co.edu.poli.contexto6.servicios;

import co.edu.poli.contexto6.modell.Maquina;

/**
 * Define el contrato de operaciones CRUD para la gestión de máquinas espaciales
 * en el sistema del Politécnico Colombiano.
 * <p>
 * Esta interfaz establece las operaciones básicas de persistencia en memoria
 * (Crear, Leer, Modificar y Eliminar) que deben implementar todas las clases
 * que administren colecciones de objetos {@link Maquina}. Garantiza un acceso
 * uniforme a los datos independientemente de la implementación concreta utilizada.
 * </p>
 *
 * @author Julieta Villarraga Corredor
 * @since 2025-I
 * @version 1.0
 * @see Maquina
 * @see ImplementacionOperacionCRUD
 */
public interface OperacionCRUD {

    /**
     * Agrega un nuevo objeto {@link Maquina} a la colección gestionada.
     *
     * @param objeto objeto {@link Maquina} a agregar; no debe ser {@code null}
     * @return {@code String} con un mensaje que indica el resultado de la operación:
     *         éxito con la posición de inserción, o error si el objeto es inválido
     */
    String crear(Maquina objeto)throws IllegalArgumentException;

    /**
     * Busca y retorna el objeto {@link Maquina} que coincida con el ID indicado.
     *
     * @param id identificador único de la máquina a buscar; no debe ser {@code null}
     * @return objeto {@link Maquina} encontrado, o {@code null} si no existe
     *         ningún objeto con ese ID en la colección
     */
    Maquina leerUno(String id)throws IllegalArgumentException;

    /**
     * Retorna todos los objetos {@link Maquina} almacenados en la colección,
     * incluyendo las posiciones vacías ({@code null}).
     *
     * @return arreglo de {@link Maquina} con todos los objetos registrados;
     *         las posiciones sin objeto contienen {@code null}
     */
    Maquina[] leerTodos()throws IllegalArgumentException;

    /**
     * Reemplaza el objeto {@link Maquina} cuyo ID coincida con el valor indicado
     * por el nuevo objeto proporcionado.
     *
     * @param id     identificador único de la máquina a modificar; no debe ser {@code null}
     * @param objeto nuevo objeto {@link Maquina} que reemplazará al existente;
     *               no debe ser {@code null}
     * @return {@code String} con un mensaje que indica el resultado de la operación:
     *         éxito si fue encontrado y modificado, o error si el ID o el objeto
     *         son inválidos, o si no se encontró ningún objeto con ese ID
     */
    String modificar(String id, Maquina objeto)throws IllegalArgumentException;

    /**
     * Elimina de la colección el objeto {@link Maquina} cuyo ID coincida
     * con el valor indicado, liberando su posición.
     *
     * @param id identificador único de la máquina a eliminar; no debe ser {@code null}
     * @return objeto {@link Maquina} eliminado si fue encontrado;
     *         {@code null} si {@code id} es {@code null} o no existe ningún
     *         objeto con ese ID en la colección
     */
    Maquina eliminar(String id)throws IllegalArgumentException;
}
