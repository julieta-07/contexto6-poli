package co.edu.poli.contexto6.vista;

import co.edu.poli.contexto6.modell.Maquina;
import co.edu.poli.contexto6.modell.Nave;
import co.edu.poli.contexto6.modell.Satelite;
import co.edu.poli.contexto6.servicios.Motor;
import co.edu.poli.contexto6.servicios.OperacionCRUD;
import co.edu.poli.contexto6.servicios.OperacionArchivo;
import co.edu.poli.contexto6.servicios.ImplementacionOperacionCRUD;

import java.util.Scanner;

public class Principal {

    public static final String VERSION = "Contexto6-v1.0";


    private static String leerTexto(Scanner sc, String campo) throws IllegalArgumentException {
        String valor = sc.nextLine().trim();
        if (valor.isEmpty()) {
            throw new IllegalArgumentException("El campo '" + campo + "' no puede estar vacio.");
        }
        return valor;
    }

    private static double leerDouble(Scanner sc, String campo) throws NumberFormatException, IllegalArgumentException {
        String raw = sc.nextLine().trim();
        double valor = Double.parseDouble(raw);   // lanza NumberFormatException si no es numero
        if (valor < 0) {
            throw new IllegalArgumentException("El campo '" + campo + "' no puede ser negativo.");
        }
        return valor;
    }

    private static int leerInt(Scanner sc, String campo) throws NumberFormatException, IllegalArgumentException {
        String raw = sc.nextLine().trim();
        int valor = Integer.parseInt(raw);        // lanza NumberFormatException si no es entero
        if (valor < 0) {
            throw new IllegalArgumentException("El campo '" + campo + "' no puede ser negativo.");
        }
        return valor;
    }

    // ─────────────────────────────────────────────
    //  MAIN
    // ─────────────────────────────────────────────

    public static void main(String[] args) {

        OperacionCRUD crud = new ImplementacionOperacionCRUD();
        OperacionArchivo archivo = (OperacionArchivo) crud;

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        String path = "src/datos/";
        String nombreArchivo = "maquinas";

        System.out.println("=================================================");
        System.out.println(" SISTEMA DE EXPLORACION ESPACIAL");
        System.out.println(" VERSION: " + VERSION);
        System.out.println("=================================================");

        while (!salir) {

            System.out.println("\n--------------- MENU ---------------");
            System.out.println("1. Crear Nave");
            System.out.println("2. Crear Satelite");
            System.out.println("3. Crear Motor");
            System.out.println("4. Listar todos los objetos");
            System.out.println("5. Listar un objeto");
            System.out.println("6. Modificar un objeto");
            System.out.println("7. Eliminar un objeto");
            System.out.println("8. Guardar en archivo");
            System.out.println("9. Leer archivo");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opcion: ");

            String opcion = scanner.nextLine().trim();

            // ── 1  CREAR NAVE ──────────────────────────────
            if (opcion.equals("1")) {
                try {
                    System.out.print("ID: ");
                    String id = leerTexto(scanner, "ID");                    // throws IllegalArgumentException

                    System.out.print("Tipo: ");
                    String tipo = leerTexto(scanner, "Tipo");                // throws IllegalArgumentException

                    System.out.print("Velocidad: ");
                    double velocidad = leerDouble(scanner, "Velocidad");     // throws NumberFormatException / IllegalArgumentException

                    System.out.print("Capacidad: ");
                    int capacidad = leerInt(scanner, "Capacidad");           // throws NumberFormatException / IllegalArgumentException

                    Nave nave = new Nave(velocidad, id, tipo, capacidad);

                    System.out.print("Ubicacion: ");
                    nave.setUbicacion(leerTexto(scanner, "Ubicacion"));      // throws IllegalArgumentException

                    System.out.print("Energia: ");
                    nave.setEnergia(leerDouble(scanner, "Energia"));         // throws NumberFormatException / IllegalArgumentException

                    System.out.println(crud.crear(nave));                    // throws IllegalArgumentException desde servicios

                } catch (NumberFormatException e) {
                    System.out.println("[ERROR - Crear Nave] Valor numerico invalido: " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.out.println("[ERROR - Crear Nave] " + e.getMessage());
                }
            }

            // ── 2  CREAR SATELITE ──────────────────────────
            else if (opcion.equals("2")) {
                try {
                    System.out.print("ID: ");
                    String id = leerTexto(scanner, "ID");                    // throws IllegalArgumentException

                    Satelite satelite = new Satelite(id);

                    System.out.print("Ubicacion: ");
                    satelite.setUbicacion(leerTexto(scanner, "Ubicacion"));  // throws IllegalArgumentException

                    System.out.print("Energia: ");
                    satelite.setEnergia(leerDouble(scanner, "Energia"));     // throws NumberFormatException / IllegalArgumentException

                    System.out.println(crud.crear(satelite));                // throws IllegalArgumentException desde servicios

                } catch (NumberFormatException e) {
                    System.out.println("[ERROR - Crear Satelite] Valor numerico invalido: " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.out.println("[ERROR - Crear Satelite] " + e.getMessage());
                }
            }

            // ── 3  CREAR MOTOR ─────────────────────────────
            else if (opcion.equals("3")) {
                try {
                    System.out.print("ID: ");
                    String id = leerTexto(scanner, "ID");                    // throws IllegalArgumentException

                    System.out.print("Color: ");
                    String color = leerTexto(scanner, "Color");              // throws IllegalArgumentException

                    System.out.print("Material: ");
                    String material = leerTexto(scanner, "Material");        // throws IllegalArgumentException

                    System.out.print("Potencia: ");
                    String potencia = leerTexto(scanner, "Potencia");        // throws IllegalArgumentException

                    Motor motor = new Motor(color, material, potencia);
                    motor.setId(id);

                    System.out.print("Ubicacion: ");
                    motor.setUbicacion(leerTexto(scanner, "Ubicacion"));     // throws IllegalArgumentException

                    System.out.print("Energia: ");
                    motor.setEnergia(leerDouble(scanner, "Energia"));        // throws NumberFormatException / IllegalArgumentException

                    System.out.println(crud.crear(motor));                   // throws IllegalArgumentException desde servicios

                } catch (NumberFormatException e) {
                    System.out.println("[ERROR - Crear Motor] Valor numerico invalido: " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.out.println("[ERROR - Crear Motor] " + e.getMessage());
                }
            }

            // ── 4  LISTAR TODOS ────────────────────────────
            else if (opcion.equals("4")) {
                Maquina[] lista = crud.leerTodos();

                System.out.println("\n------ LISTA DE OBJETOS ------");
                boolean hayDatos = false;

                for (Maquina m : lista) {
                    if (m != null) {
                        System.out.println(m);
                        hayDatos = true;
                    }
                }

                if (!hayDatos) {
                    System.out.println("No hay objetos registrados.");
                }
            }

            // ── 5  LISTAR UNO ──────────────────────────────
            else if (opcion.equals("5")) {
                try {
                    System.out.print("Ingrese ID: ");
                    String id = leerTexto(scanner, "ID");       // throws IllegalArgumentException

                    Maquina objeto = crud.leerUno(id);          // throws IllegalArgumentException desde servicios

                    if (objeto != null) {
                        System.out.println(objeto);
                    } else {
                        System.out.println("Objeto con ID '" + id + "' no encontrado.");
                    }

                } catch (IllegalArgumentException e) {
                    System.out.println("[ERROR - Listar Uno] " + e.getMessage());
                }
            }

            // ── 6  MODIFICAR ───────────────────────────────
            else if (opcion.equals("6")) {
                try {
                    System.out.print("ID actual: ");
                    String idViejo = leerTexto(scanner, "ID actual");   // throws IllegalArgumentException

                    System.out.print("Nuevo ID: ");
                    String nuevoId = leerTexto(scanner, "Nuevo ID");    // throws IllegalArgumentException

                    Satelite nuevo = new Satelite(nuevoId);

                    System.out.println(crud.modificar(idViejo, nuevo)); // throws IllegalArgumentException desde servicios

                } catch (IllegalArgumentException e) {
                    System.out.println("[ERROR - Modificar] " + e.getMessage());
                }
            }

            // ── 7  ELIMINAR ────────────────────────────────
            else if (opcion.equals("7")) {
                try {
                    System.out.print("ID a eliminar: ");
                    String id = leerTexto(scanner, "ID");       // throws IllegalArgumentException

                    Maquina eliminado = crud.eliminar(id);      // throws IllegalArgumentException desde servicios

                    if (eliminado != null) {
                        System.out.println("Eliminado: " + eliminado);
                    } else {
                        System.out.println("No encontrado objeto con ID: " + id);
                    }

                } catch (IllegalArgumentException e) {
                    System.out.println("[ERROR - Eliminar] " + e.getMessage());
                }
            }

            // ── 8  GUARDAR ARCHIVO ─────────────────────────
            else if (opcion.equals("8")) {
                try {
                    String resultado = archivo.serializar(       // throws IllegalArgumentException desde servicios
                            crud.leerTodos(),
                            path,
                            nombreArchivo
                    );
                    System.out.println(resultado);

                } catch (IllegalArgumentException e) {
                    System.out.println("[ERROR - Guardar Archivo] " + e.getMessage());
                }
            }

            // ── 9  LEER ARCHIVO ────────────────────────────
            else if (opcion.equals("9")) {
                try {
                    Maquina[] cargados = archivo.deserializar(path, nombreArchivo); // throws IllegalArgumentException desde servicios

                    System.out.println("\n------ DATOS DEL ARCHIVO ------");

                    if (cargados != null) {
                        boolean hayDatos = false;
                        for (Maquina m : cargados) {
                            if (m != null) {
                                System.out.println(m);
                                hayDatos = true;
                            }
                        }
                        if (!hayDatos) System.out.println("El archivo esta vacio.");
                    } else {
                        System.out.println("No se pudo cargar el archivo.");
                    }

                } catch (IllegalArgumentException e) {
                    System.out.println("[ERROR - Leer Archivo] " + e.getMessage());
                }
            }

            // ── 10 SALIR ───────────────────────────────────
            else if (opcion.equals("10")) {
                salir = true;
                System.out.println("Saliendo...");
            }

            else {
                System.out.println("Opcion invalida. Elija entre 1 y 10.");
            }
        }

        scanner.close();
    }
}

      
