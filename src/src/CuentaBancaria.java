package fet.edu.co.semana08_excepciones_hilos;

/**
 * @author Daniel Polania
 * @author Nicolas Vargas
 */
public class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public synchronized void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println(Thread.currentThread().getName() + " depositó: $" + monto + ". Saldo actual: $" + saldo);
        }
    }

    public synchronized void retirar(double monto) throws SaldoInsuficienteException {
        System.out.println(Thread.currentThread().getName() + " intentando retirar: $" + monto);

        if (monto > saldo) {
            throw new SaldoInsuficienteException("Fondos insuficientes. Saldo actual: $" + saldo + ", Monto solicitado: $" + monto);
        }

        // Simulamos el tiempo de transacción del banco
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        saldo -= monto;
        System.out.println(Thread.currentThread().getName() + " retiro EXITOSO de: $" + monto + ". Saldo restante: $" + saldo);
    }

    public double getSaldo() {
        return saldo;
    }
}
