package fet.edu.co.semana08_excepciones_hilos;

/**
 * @author Daniel Polania
 * @author Nicolas Vargas
 */
public class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
