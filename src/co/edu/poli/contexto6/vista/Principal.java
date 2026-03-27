
package co.edu.poli.contexto6.vista;

import co.edu.poli.contexto6.modell.Maquina;
import co.edu.poli.contexto6.modell.Nave;
import co.edu.poli.contexto6.modell.Satelite;
import co.edu.poli.contexto6.servicios.Motor;

import java.util.Scanner;

public class Principal {

    public static final String VERSION = "Contexto6-v1.0";

    public static void main(String[] args) {

        Maquina[] maquinas = new Maquina[5];

        Nave nave1 = new Nave(12000.0, "N-001", "Exploradora", 6);
        nave1.setUbicacion("Orbita baja terrestre");
        nave1.setEnergia(850.0);
        maquinas[0] = nave1;

        Satelite satelite1 = new Satelite("SAT-Alpha");
        satelite1.setUbicacion("Orbita geoestacionaria");
        satelite1.setEnergia(200.0);
        maquinas[1] = satelite1;

        Motor motor1 = new Motor("Rojo", "Acero", "Alta");
        motor1.setUbicacion("Modulo de propulsion");
        motor1.setEnergia(500.0);
        maquinas[2] = motor1;

        System.out.println("============================================================");
        System.out.println("  PUNTO 1 - Arreglo supersuperclase + sobrescritura metodos");
        System.out.println("============================================================");
        System.out.println("Tipo del arreglo: Maquina[]   |   Tamano: " + maquinas.length);
        System.out.println();

        for (int i = 0; i < maquinas.length; i++) {
            if (maquinas[i] != null) {
                System.out.println("maquinas[" + i + "] - clase real: "
                        + maquinas[i].getClass().getSimpleName());
                System.out.println("   encender()           : " + maquinas[i].encender());
                System.out.println("   calculartiempoactivo : " + maquinas[i].calculartiempoactivo());
                System.out.println("   toString             : " + maquinas[i]);
            } else {
                System.out.println("maquinas[" + i + "] - null (posicion vacia)");
            }
            System.out.println();
        }

        System.out.println("============================================================");
        System.out.println("  PUNTO 2 - Polimorfismo");
        System.out.println("============================================================");
        System.out.println();

        System.out.println(">> Metodo que RECIBE parametro de tipo Maquina:");
        procesarMaquina(nave1);
        procesarMaquina(satelite1);
        procesarMaquina(motor1);
        System.out.println();

        System.out.println(">> Metodo que RETORNA tipo Maquina:");
        Maquina nueva = crearMaquinaDefecto();
        System.out.println("   clase real           : " + nueva.getClass().getSimpleName());
        System.out.println("   toString             : " + nueva);
        System.out.println("   encender()           : " + nueva.encender());
        System.out.println("   calculartiempoactivo : " + nueva.calculartiempoactivo());
        System.out.println();

        System.out.println("============================================================");
        System.out.println("  PUNTO 3 - Modificador final");
        System.out.println("============================================================");
        System.out.println();
        System.out.println("Atributo final VERSION = " + VERSION);

        // sc.iniciar();

        System.out.println("\n============================================================");
        System.out.println("  PUNTO 4 - Prueba de Operaciones CRUD");
        System.out.println("============================================================");

        co.edu.poli.contexto6.servicios.OperacionCRUD crud = new co.edu.poli.contexto6.servicios.ImplementacionOperacionCRUD();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MENÚ CRUD ---");
            System.out.println("1. Crear Nave");
            System.out.println("2. Crear Satelite");
            System.out.println("3. Crear Motor");
            System.out.println("4. Leer Todas las maquinas");
            System.out.println("5. Leer Una maquina (por ID)");
            System.out.println("6. Modificar maquina (por ID)");
            System.out.println("7. Eliminar maquina (por ID)");
            System.out.println("8. Salir");
            System.out.print("Elige una opcion: ");

            String opcion = scanner.nextLine();

            if (opcion.equals("1")) {
                System.out.print("Costo construccion (decimal): ");
                double costo = 0;
                if (scanner.hasNextDouble()) {
                    costo = scanner.nextDouble();
                }
                scanner.nextLine(); // limpiar buffer

                System.out.print("ID Nave: ");
                String idNave = scanner.nextLine();
                System.out.print("Tipo: ");
                String tipo = scanner.nextLine();

                System.out.print("Tripulacion (entero): ");
                int tripu = 0;
                if (scanner.hasNextInt()) {
                    tripu = scanner.nextInt();
                }
                scanner.nextLine(); // limpiar buffer

                Nave n = new Nave(costo, idNave, tipo, tripu);
                System.out.print("Ubicacion: ");
                n.setUbicacion(scanner.nextLine());

                System.out.print("Energia (decimal): ");
                if (scanner.hasNextDouble()) {
                    n.setEnergia(scanner.nextDouble());
                }
                scanner.nextLine();

                System.out.println(crud.crear(n));

            } else if (opcion.equals("2")) {
                System.out.print("ID Satelite: ");
                String idSat = scanner.nextLine();
                Satelite s = new Satelite(idSat);

                System.out.print("Ubicacion: ");
                s.setUbicacion(scanner.nextLine());

                System.out.print("Energia (decimal): ");
                if (scanner.hasNextDouble()) {
                    s.setEnergia(scanner.nextDouble());
                }
                scanner.nextLine();

                System.out.println(crud.crear(s));

            } else if (opcion.equals("3")) {
                System.out.print("Color: ");
                String color = scanner.nextLine();
                System.out.print("Material: ");
                String mat = scanner.nextLine();
                System.out.print("Potencia: ");
                String pot = scanner.nextLine();

                Motor m = new Motor(color, mat, pot);
                System.out.print("Ubicacion: ");
                m.setUbicacion(scanner.nextLine());

                System.out.print("Energia (decimal): ");
                if (scanner.hasNextDouble()) {
                    m.setEnergia(scanner.nextDouble());
                }
                scanner.nextLine();

                System.out.println(crud.crear(m));

            } else if (opcion.equals("4")) {
                Maquina[] maquinasGuardadas = crud.leerTodos();
                System.out.println("\n--- LISTA ---");
                for (int i = 0; i < maquinasGuardadas.length; i++) {
                    if (maquinasGuardadas[i] != null) {
                        System.out.println("Pos[" + i + "]: " + maquinasGuardadas[i]);
                    }
                }

            } else if (opcion.equals("5")) {
                System.out.print("Ingresa el ID a buscar: ");
                String idBusq = scanner.nextLine();
                Maquina encontrada = crud.leerUno(idBusq);
                if (encontrada != null) {
                    System.out.println("Encontrada: " + encontrada);
                } else {
                    System.out.println("No se encontro ninguna maquina con ese ID.");
                }

            } else if (opcion.equals("6")) {
                System.out.print("Ingresa el ID de la maquina a MODIFICAR: ");
                String idMod = scanner.nextLine();

                // Pedimos datos para crear un Satelite basico por defecto como reemplazo
                // para simplificar el menu (se puede adaptar para preguntar que tipo crear)
                System.out.print("Ingrese ID del NUEVO Satelite de reemplazo: ");
                String nuevoId = scanner.nextLine();
                Satelite satReemplazo = new Satelite(nuevoId);

                System.out.println(crud.modificar(idMod, satReemplazo));

            } else if (opcion.equals("7")) {
                System.out.print("Ingresa el ID a ELIMINAR: ");
                String idElim = scanner.nextLine();
                Maquina maquinaEliminada = crud.eliminar(idElim);
                if (maquinaEliminada != null) {
                    System.out.println("Eliminada: " + maquinaEliminada);
                } else {
                    System.out.println("No se pudo eliminar, ID no encontrado.");
                }

            } else if (opcion.equals("8")) {
                salir = true;
                System.out.println("Saliendo del Menu CRUD...");
            } else {
                System.out.println("Opcion no valida. Intenta de nuevo.");
            }
        }

        // co.edu.poli.contexto6.servicios.OperacionCRUD crud = new
        // co.edu.poli.contexto6.servicios.ImplementacionOperacionCRUD();

        // System.out.println(crud.crear(nave1));
        // System.out.println(crud.crear(satelite1));
        // System.out.println(crud.crear(motor1));

        // System.out.println("\n---> LEER TODOS:");
        // Maquina[] todas = crud.leerTodos();
        // for (int i = 0; i < todas.length; i++) {
        // System.out.println("Pos[" + i + "]: " + (todas[i] != null ?
        // todas[i].toString() : "null"));
        // }

        // System.out.println("\n---> LEER UNO (ID: SAT-Alpha):");
        // Maquina mExistente = crud.leerUno("SAT-Alpha");
        // System.out.println(mExistente != null ? "Encontrado: " + mExistente : "No
        // encontrado");

        // System.out.println("\n---> MODIFICAR (Reemplazar N-001 por otra Nave en el
        // CRUD):");
        // Nave naveReemplazo = new Nave(9999.0, "N-001R", "Combate", 10);
        // System.out.println(crud.modificar("N-001", naveReemplazo));

        // System.out.println("\n---> ELIMINAR (Eliminando Motor generado sin ID
        // estricto pero como satélite):");
        // System.out.println(
        // "Nota: Como los motores no se le configuró un parametro ID directo en
        // Principal, vamos a eliminar SAT-Alpha");
        // Maquina mEliminada = crud.eliminar("SAT-Alpha");
        // System.out.println("Elemento Eliminado: " + mEliminada);

        // System.out
        // .println("\n---> LEER TODOS (Después de Modificar y Eliminar, validando el
        // primer hueco disponible):");
        // Maquina[] estadoFinal = crud.leerTodos();
        // for (int i = 0; i < estadoFinal.length; i++) {
        // System.out.println("Pos[" + i + "]: " + (estadoFinal[i] != null ?
        // estadoFinal[i].toString() : "null"));
        // }

        // System.out.println("\n---> CREAR (Debería insertarse en la posición nula
        // abandonada por eliminación):");
        // Satelite nuevoSatelite = new Satelite("SAT-Omega");
        // nuevoSatelite.setEnergia(600.0);
        // System.out.println(crud.crear(nuevoSatelite));

        reporteSistema();

        SistemaControl sc = new SistemaControl();
        sc.iniciar();
    }

    public static void procesarMaquina(Maquina m) {
        System.out.println("   [procesarMaquina] tipo real: " + m.getClass().getSimpleName()
                + " | encender: " + m.encender()
                + " | tiempoActivo: " + m.calculartiempoactivo());
    }

    public static Maquina crearMaquinaDefecto() {
        Nave naveDefecto = new Nave(5000.0, "DEF-001", "Carga", 4);
        naveDefecto.setUbicacion("Base de lanzamiento");
        naveDefecto.setEnergia(100.0);
        return naveDefecto;
    }

    public static final void reporteSistema() {
        System.out.println("   [reporteSistema - metodo final] Version: " + VERSION);
    }

    public static final class SistemaControl {
        public void iniciar() {
            System.out.println("   [SistemaControl - clase final] Control iniciado.");
        }
    }
}