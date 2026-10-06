

package uam.prog3.tarea03;

public class App {
   public static void aplicarDescuento(double subtotal) {
        subtotal = subtotal * 0.9;
    }

    public static void agregarCortesia(Pedido pedido) {
        pedido.agregarItem(new Bebida("Agua", 500, false));
    }

    public static void main(String[] args) {
        ItemMenu casado = new Plato("Casado", 3500, true);
        ItemMenu cafe = new Bebida("Café", 1200, false);
        ItemMenu fresco = new Bebida("Fresco de mora", 1500, true);

        // 1. Menú
        System.out.println("=== Menú ===");
        ItemMenu[] menu1 = {casado, cafe, fresco};
        for (ItemMenu item : menu1) {
            System.out.println(item.describirItem());
        }

        // 2. Pedido
        Pedido pedido = new Pedido();
        pedido.agregarItem(casado);
        pedido.agregarItems(cafe, 2);
        pedido.agregarItem(fresco);
        pedido.agregarItems(cafe, 0); // Prueba de cantidad negativa

        double subtotal = pedido.calcularSubtotal();
        System.out.println("Subtotal: ₡" + subtotal);

        // 3. Pagos
        System.out.println("=== Pagos ===");
        MetodoPago[] pagos = {new Efectivo(), new Tarjeta() };
        for (MetodoPago pago : pagos) {
            pedido.cobrar(pago);
        }

        // 4. Parámetros (Valor vs Referencia y Copia defensiva)
        System.out.println("=== Parámetros ===");
        double subtotalValor = pedido.calcularSubtotal();
        aplicarDescuento(subtotalValor);
        System.out.println("Subtotal tras aplicarDescuento: ₡" + subtotalValor);

        agregarCortesia(pedido);
        System.out.println("Subtotal tras agregarCortesia: ₡" + pedido.calcularSubtotal());

        pedido.getItems().clear(); // Prueba de copia defensiva
        System.out.println("Subtotal tras getItems().clear(): ₡" + pedido.calcularSubtotal());
    }

        // 5. Visibilidad (Comentadas para que compile correctamente)
        // System.out.println(casado.precioBase);
        // pedido.items.clear();
    }

