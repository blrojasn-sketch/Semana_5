import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ZonaDeCarga {

    private BlockingQueue<Pedido> pedidos = new LinkedBlockingQueue<>();

    public synchronized void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);

        System.out.println(
                "Pedido #" + pedido.getId() +
                        " agregado. Destino: " +
                        pedido.getDireccionEntrega()
        );
    }

    public synchronized Pedido retirarPedido() {
        return pedidos.poll();
    }

    public boolean estaVacia() {
        return pedidos.isEmpty();
    }
}