package fet.edu.co.semana08_excepciones_hilos;

/**
 * @author Daniel Polania
 * @author Nicolas Vargas
 */
public class Semana08ExcepcionesHilosApplication {
    public static void main(String[] args) {
        // Encabezado con sus nombres
        System.out.println("=================================================");
        System.out.println("   Proyecto: Semana08_Excepciones_Hilos");
        System.out.println("   Integrantes: Daniel Polania y Nicolas Vargas");
        System.out.println("=================================================\n");

        System.out.println("--- Iniciando Operaciones Bancarias ---");

        // Creamos la cuenta con $1000
        CuentaBancaria miCuenta = new CuentaBancaria(1000.0);
        System.out.println("Saldo inicial: $" + miCuenta.getSaldo() + "\n");

        // Creamos los 3 hilos (cajeros). Sumados piden $1200, por lo que uno fallará.
        Thread hilo1 = new Thread(new Cajero(miCuenta, 500.0), "Cajero-1");
        Thread hilo2 = new Thread(new Cajero(miCuenta, 400.0), "Cajero-2");
        Thread hilo3 = new Thread(new Cajero(miCuenta, 300.0), "Cajero-3");

        // Iniciamos los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();

        // Esperamos a que los 3 terminen para imprimir el saldo final correctamente
        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            System.err.println("El hilo principal fue interrumpido.");
        }

        System.out.println("\n--- Operaciones finalizadas ---");
        System.out.println("Saldo final de la cuenta: $" + miCuenta.getSaldo());
    }
}