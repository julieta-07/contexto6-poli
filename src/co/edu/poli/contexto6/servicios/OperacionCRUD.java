package co.edu.poli.contexto6.servicios;

import co.edu.poli.contexto6.modell.Maquina;

public interface OperacionCRUD {
    String crear(Maquina objeto);

    Maquina leerUno(String id);

    Maquina[] leerTodos();

    String modificar(String id, Maquina objeto);

    Maquina eliminar(String id);
}
