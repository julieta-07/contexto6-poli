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

            // 1 CREAR NAVE
            if (opcion.equals("1")) {
                System.out.print("ID: ");
                String id = scanner.nextLine();

                System.out.print("Tipo: ");
                String tipo = scanner.nextLine();

                System.out.print("Velocidad: ");
                double velocidad = Double.parseDouble(scanner.nextLine());

                System.out.print("Capacidad: ");
                int capacidad = Integer.parseInt(scanner.nextLine());

                Nave nave = new Nave(velocidad, id, tipo, capacidad);

                System.out.print("Ubicacion: ");
                nave.setUbicacion(scanner.nextLine());

                System.out.print("Energia: ");
                nave.setEnergia(Double.parseDouble(scanner.nextLine()));

                System.out.println(crud.crear(nave));
            }

            // 2 CREAR SATELITE
            else if (opcion.equals("2")) {
                System.out.print("ID: ");
                String id = scanner.nextLine();

                Satelite satelite = new Satelite(id);

                System.out.print("Ubicacion: ");
                satelite.setUbicacion(scanner.nextLine());

                System.out.print("Energia: ");
                satelite.setEnergia(Double.parseDouble(scanner.nextLine()));

                System.out.println(crud.crear(satelite));
            }

            // 3 CREAR MOTOR
            else if (opcion.equals("3")) {
                System.out.print("ID: ");
                String id = scanner.nextLine();

                System.out.print("Color: ");
                String color = scanner.nextLine();

                System.out.print("Material: ");
                String material = scanner.nextLine();

                System.out.print("Potencia: ");
                String potencia = scanner.nextLine();

                Motor motor = new Motor(color, material, potencia);
                motor.setId(id);

                System.out.print("Ubicacion: ");
                motor.setUbicacion(scanner.nextLine());

                System.out.print("Energia: ");
                motor.setEnergia(Double.parseDouble(scanner.nextLine()));

                System.out.println(crud.crear(motor));
            }

            // 4 LISTAR TODOS
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

            // 5 LISTAR UNO
            else if (opcion.equals("5")) {
                System.out.print("Ingrese ID: ");
                String id = scanner.nextLine();

                Maquina objeto = crud.leerUno(id);

                if (objeto != null) {
                    System.out.println(objeto);
                } else {
                    System.out.println("Objeto no encontrado.");
                }
            }

            // 6 MODIFICAR
            else if (opcion.equals("6")) {
                System.out.print("ID actual: ");
                String idViejo = scanner.nextLine();

                System.out.print("Nuevo ID: ");
                String nuevoId = scanner.nextLine();

                Satelite nuevo = new Satelite(nuevoId);

                System.out.println(crud.modificar(idViejo, nuevo));
            }

            // 7 ELIMINAR
            else if (opcion.equals("7")) {
                System.out.print("ID a eliminar: ");
                String id = scanner.nextLine();

                Maquina eliminado = crud.eliminar(id);

                if (eliminado != null) {
                    System.out.println("Eliminado: " + eliminado);
                } else {
                    System.out.println("No encontrado.");
                }
            }

            // 8 GUARDAR ARCHIVO
            else if (opcion.equals("8")) {
                String resultado = archivo.serializar(
                        crud.leerTodos(),
                        path,
                        nombreArchivo
                );

                System.out.println(resultado);
            }

            // 9 LEER ARCHIVO
            else if (opcion.equals("9")) {
                Maquina[] cargados = archivo.deserializar(path, nombreArchivo);

                System.out.println("\n------ DATOS DEL ARCHIVO ------");

                if (cargados != null) {
                    for (Maquina m : cargados) {
                        if (m != null) {
                            System.out.println(m);
                        }
                    }
                } else {
                    System.out.println("No se pudo cargar archivo.");
                }
            }

            // 10 SALIR
            else if (opcion.equals("10")) {
                salir = true;
                System.out.println("Saliendo...");
            }

            else {
                System.out.println("Opcion invalida.");
            }
        }

        scanner.close();
    }
}