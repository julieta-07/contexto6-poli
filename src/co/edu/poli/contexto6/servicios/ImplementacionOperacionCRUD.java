package co.edu.poli.contexto6.servicios;

import co.edu.poli.contexto6.modell.Maquina;
import co.edu.poli.contexto6.modell.Nave;
import co.edu.poli.contexto6.modell.Satelite;

public class ImplementacionOperacionCRUD implements OperacionCRUD {

    private Maquina[] arregloObjetos;

    public ImplementacionOperacionCRUD() {
        this.arregloObjetos = new Maquina[2]; // Inicial con tamaño 2
    }

    // Método auxiliar para obtener el ID independientemente de si es Nave o
    // Satélite
    private String obtenerId(Maquina m) {
        if (m == null)
            return null;
        if (m instanceof Nave) {
            return ((Nave) m).getId();
        } else if (m instanceof Satelite) {
            return ((Satelite) m).getId();
        }
        return null;
    }

    @Override
    public String crear(Maquina objeto) {
        if (objeto == null) {
            return "Error: No se puede agregar un objeto nulo.";
        }

        // Buscar el primer null de izquierda a derecha
        for (int i = 0; i < arregloObjetos.length; i++) {
            if (arregloObjetos[i] == null) {
                arregloObjetos[i] = objeto;
                return "Objeto creado exitosamente en la posición " + i + ".";
            }
        }

        // Si no se encontró un null, el arreglo está lleno. Generar crecimiento
        // "infinito".
        Maquina[] nuevoArreglo = new Maquina[arregloObjetos.length * 2];
        System.arraycopy(arregloObjetos, 0, nuevoArreglo, 0, arregloObjetos.length);

        // Agregar el nuevo objeto en la primera posición disponible del nuevo arreglo
        nuevoArreglo[arregloObjetos.length] = objeto;
        arregloObjetos = nuevoArreglo;

        return "Arreglo redimensionado. Objeto creado exitosamente en la posición " + (arregloObjetos.length / 2) + ".";
    }

    @Override
    public Maquina leerUno(String id) {
        if (id == null)
            return null;
        for (Maquina m : arregloObjetos) {
            if (m != null && id.equals(obtenerId(m))) {
                return m;
            }
        }
        return null;
    }

    @Override
    public Maquina[] leerTodos() {
        return arregloObjetos;
    }

    @Override
    public String modificar(String id, Maquina objeto) {
        if (id == null || objeto == null) {
            return "Error: ID a modificar o el nuevo objeto es inválido.";
        }

        for (int i = 0; i < arregloObjetos.length; i++) {
            if (arregloObjetos[i] != null && id.equals(obtenerId(arregloObjetos[i]))) {
                arregloObjetos[i] = objeto;
                return "Objeto con ID " + id + " modificado exitosamente.";
            }
        }
        return "Error: Objeto con ID " + id + " no encontrado.";
    }

    @Override
    public Maquina eliminar(String id) {
        if (id == null)
            return null;

        for (int i = 0; i < arregloObjetos.length; i++) {
            if (arregloObjetos[i] != null && id.equals(obtenerId(arregloObjetos[i]))) {
                Maquina eliminada = arregloObjetos[i];
                arregloObjetos[i] = null; // Liberamos la posición dejándola en null
                return eliminada;
            }
        }
        return null;
    }
}
