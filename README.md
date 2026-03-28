# Proyecto: Semana08_Excepciones_Hilos

**Integrantes:** Daniel Polania y Nicolas Vargas

---

### 1. Sincronizado vs. Sin Sincronizar (Requisito 7)
* **Sin sincronizar:** Varios hilos (cajeros) pueden leer y restar el saldo exactamente al mismo tiempo. Esto causa una "condición de carrera", aprobando retiros que no deberían pasar y dejando la cuenta en números negativos.
* **Con sincronizar:** Al agregar `synchronized` a los métodos, obligamos a los hilos a hacer fila. Solo un cajero puede interactuar con el saldo a la vez. Hasta que no termine y se actualice el dinero, el siguiente no puede entrar, manteniendo los datos correctos.

### 2. Manejo de Excepciones (Entrega Q10)
Se creó la excepción personalizada `SaldoInsuficienteException`.
Si el retiro supera el saldo disponible, el método `retirar()` lanza esta alerta usando `throw`. Luego, en la clase `Cajero`, usamos un bloque `try-catch` para atrapar ese error. Así, en lugar de que el programa colapse y se cierre, simplemente imprime un mensaje en rojo por consola avisando que no hay fondos.