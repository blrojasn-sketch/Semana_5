# Semana 5 - Sincronizando procesos en sistemas concurrentes

## Descripción

Este proyecto corresponde a la actividad formativa de la semana 5 del módulo de 
Programación Concurrente.

El sistema simula la coordinación de entregas de la empresa **SpeedFast**, donde 
múltiples repartidores trabajan de forma simultánea retirando pedidos desde una zona 
de carga compartida.
Para evitar problemas de concurrencia y garantizar que cada pedido sea retirado por 
un único repartidor, se implementan mecanismos de sincronización utilizando hilos 
(Threads), la interfaz Runnable y una estructura compartida protegida para el acceso 
concurrente.

---

## Objetivo

Desarrollar una solución en Java que permita:

- Simular la llegada de pedidos a una zona de carga.
- Permitir que múltiples repartidores trabajen en paralelo.
- Controlar el acceso concurrente al recurso compartido.
- Evitar condiciones de carrera.
- Garantizar que cada pedido sea entregado una sola vez.

## Estructura del proyecto

semana5/
│
├── EstadoPedido.java
├── Pedido.java
├── ZonaDeCarga.java
├── Repartidor.java
└── Main.java

---

## Clases del proyecto

### EstadoPedido

Enum que representa los posibles estados de un pedido:

```java
PENDIENTE
EN_REPARTO
ENTREGADO
```

### Pedido

Representa una encomienda dentro del sistema.

**Atributos:**

- id
- direccionEntrega
- estado

**Métodos:**

- Constructor
- Getters y Setters
- setEstado()
- toString()

### ZonaDeCarga

Representa el recurso compartido por todos los repartidores.

**Responsabilidades:**

- Almacenar pedidos pendientes.
- Agregar nuevos pedidos.
- Permitir el retiro seguro de pedidos.
- Evitar que dos repartidores retiren el mismo pedido.

### Repartidor

Implementa la interfaz Runnable.

**Responsabilidades:**

- Retirar pedidos de la zona de carga.
- Cambiar el estado a EN_REPARTO.
- Simular la entrega.
- Cambiar el estado a ENTREGADO.

### Main

Clase principal encargada de:

- Crear la zona de carga.
- Registrar pedidos.
- Crear repartidores.
- Iniciar los hilos.
- Esperar la finalización de todos los procesos.


## Conceptos de Programación Concurrente Aplicados

- **Thread:** permite ejecutar múltiples tareas simultáneamente.
- **Runnable:** define la lógica que ejecuta cada repartidor.
- **Sincronización:** controla el acceso seguro a la zona de carga.
- **Recurso compartido:** la clase ZonaDeCarga es utilizada por todos los repartidores.
- **Exclusión mutua:** garantiza que un pedido sea atendido por un único repartidor.

---

