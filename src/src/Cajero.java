package fet.edu.co.semana08_excepciones_hilos;

/**
 * @author Daniel Polania
 * @author Nicolas Vargas
 */
public class Cajero implements Runnable {
    private CuentaBancaria cuenta;
    private double montoARetirar;

    public Cajero(CuentaBancaria cuenta, double montoARetirar) {
        this.cuenta = cuenta;
        this.montoARetirar = montoARetirar;
    }

    @Override
    public void run() {
        try {
            cuenta.retirar(montoARetirar);
        } catch (SaldoInsuficienteException e) {
            System.err.println("ERROR en " + Thread.currentThread().getName() + ": " + e.getMessage());
        }
    }
}