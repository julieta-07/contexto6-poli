
package co.edu.poli.contexto6.vista;

import co.edu.poli.contexto6.modell.Maquina;
import co.edu.poli.contexto6.modell.Nave;
import co.edu.poli.contexto6.modell.Satelite;
import co.edu.poli.contexto6.servicios.Motor;


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