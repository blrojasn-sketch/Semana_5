public class Main {

    public static void main(String[] args) {

        System.out.println("[Zona de carga inicializada]\n");

        // Crear zona de carga compartida
        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();

        // Agregar pedidos
        zonaDeCarga.agregarPedido(new Pedido(1, "Santiago Centro"));
        zonaDeCarga.agregarPedido(new Pedido(2, "Providencia"));
        zonaDeCarga.agregarPedido(new Pedido(3, "Ñuñoa"));
        zonaDeCarga.agregarPedido(new Pedido(4, "Recoleta"));
        zonaDeCarga.agregarPedido(new Pedido(5, "Las Condes"));

        System.out.println();

        // Crear repartidores
        Thread repartidor1 = new Thread(
                new Repartidor("Sergio", zonaDeCarga));

        Thread repartidor2 = new Thread(
                new Repartidor("Camila", zonaDeCarga));

        Thread repartidor3 = new Thread(
                new Repartidor("Erik", zonaDeCarga));

        // Iniciar hilos
        repartidor1.start();
        repartidor2.start();
        repartidor3.start();

        // Esperar a que terminen todos los repartidores
        try {
            repartidor1.join();
            repartidor2.join();
            repartidor3.join();
        } catch (InterruptedException e) {
            System.out.println("Error al esperar los hilos.");
        }

        System.out.println("\n[Zona de carga vacía]");
        System.out.println("\nTodos los pedidos han sido entregados correctamente.");
    }
}