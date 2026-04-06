package co.edu.poli.contexto6.servicios;

import co.edu.poli.contexto6.modell.Maquina;
import java.io.*;

/**
 * Implementación de operaciones CRUD y persistencia en archivo
 * para objetos de tipo Maquina.
 *
 * Esta clase permite crear, leer, modificar, eliminar,
 * guardar y cargar objetos de tipo Maquina.
 *
 * @author Julieta Villarraga Corredor
 * @since 2026
 * @version 1.0
 * @see implementacionOperacionCRUD
 */
public class ImplementacionOperacionCRUD
        implements OperacionCRUD, OperacionArchivo {

    /**
     * Arreglo que almacena los objetos de tipo Maquina.
     */
    private Maquina[] arregloMaquina = new Maquina[5];

    /**
     * Crea y almacena un objeto Maquina en la primera
     * posición disponible del arreglo.
     *
     * @param objeto objeto de tipo Maquina a almacenar
     * @return mensaje indicando si la creación fue exitosa o si ocurrió un error
     */
    @Override
    public String crear(Maquina objeto) {
        if (objeto == null) {
            return "Error: objeto nulo.";
        }

        for (int i = 0; i < arregloMaquina.length; i++) {
            if (arregloMaquina[i] == null) {
                arregloMaquina[i] = objeto;
                return "Objeto creado en posicion " + i;
            }
        }

        return "Error: arreglo lleno.";
    }

    /**
     * Busca y retorna una máquina según su identificador.
     *
     * @param id identificador de la máquina
     * @return objeto Maquina encontrado o null si no existe
     */
    @Override
    public Maquina leerUno(String id) {
        if (id == null) {
            return null;
        }

        for (Maquina maquina : arregloMaquina) {
            if (maquina != null && maquina.getId().equals(id)) {
                return maquina;
            }
        }

        return null;
    }

    /**
     * Retorna todos los objetos almacenados en el arreglo.
     *
     * @return arreglo de objetos Maquina
     */
    @Override
    public Maquina[] leerTodos() {
        return arregloMaquina;
    }

    /**
     * Modifica un objeto Maquina existente según su id.
     *
     * @param id identificador del objeto a modificar
     * @param objeto nuevo objeto que reemplazará al anterior
     * @return mensaje indicando el resultado de la modificación
     */
    @Override
    public String modificar(String id, Maquina objeto) {
        if (id == null || objeto == null) {
            return "Error: datos invalidos.";
        }

        for (int i = 0; i < arregloMaquina.length; i++) {
            if (arregloMaquina[i] != null &&
                arregloMaquina[i].getId().equals(id)) {

                arregloMaquina[i] = objeto;
                return "Objeto modificado correctamente.";
            }
        }

        return "Objeto no encontrado.";
    }

    /**
     * Elimina una máquina del arreglo según su id.
     *
     * @param id identificador del objeto a eliminar
     * @return objeto eliminado o null si no fue encontrado
     */
    @Override
    public Maquina eliminar(String id) {
        if (id == null) {
            return null;
        }

        for (int i = 0; i < arregloMaquina.length; i++) {
            if (arregloMaquina[i] != null &&
                arregloMaquina[i].getId().equals(id)) {

                Maquina eliminado = arregloMaquina[i];
                arregloMaquina[i] = null;
                return eliminado;
            }
        }

        return null;
    }

    /**
     * Guarda el arreglo de máquinas en un archivo .dat.
     *
     * @param maquinas arreglo de máquinas a guardar
     * @param path ruta donde se guardará el archivo
     * @param name nombre del archivo
     * @return mensaje indicando si el archivo fue guardado correctamente
     */
    @Override
    public String serializar(Maquina[] maquinas, String path, String name) {
        try {
            File directorio = new File(path);
            if (!directorio.exists()) {
                directorio.mkdirs();
            }

            ObjectOutputStream salida = new ObjectOutputStream(
                    new FileOutputStream(path + name + ".dat")
            );

            salida.writeObject(maquinas);
            salida.close();

            return "Archivo guardado correctamente en: "
                    + path + name + ".dat";

        } catch (IOException e) {
            return "Error al guardar archivo: " + e.getMessage();
        }
    }

    /**
     * Carga un arreglo de máquinas desde un archivo .dat.
     *
     * @param path ruta del archivo
     * @param name nombre del archivo
     * @return arreglo de máquinas cargado desde el archivo
     */
    @Override
    public Maquina[] deserializar(String path, String name) {
        try {
            ObjectInputStream entrada = new ObjectInputStream(
                    new FileInputStream(path + name + ".dat")
            );

            arregloMaquina = (Maquina[]) entrada.readObject();
            entrada.close();

            return arregloMaquina;

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
            return null;
        }
    }
}