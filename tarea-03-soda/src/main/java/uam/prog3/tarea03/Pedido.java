package uam.prog3.tarea03;


import java.util.ArrayList;
import java.util.List;
public class Pedido {

    private List<ItemMenu> items;
    
    public Pedido() {
        this.items = new ArrayList<>();
    }

    public void agregarItem(ItemMenu item) {
        items.add(item);
    }

    public void agregarItems(ItemMenu item, int cantidad) {
        if (cantidad <= 0) {
            System.out.println("Cantidad debe ser positiva.");
            return;
        }
        for (int i = 0; i < cantidad; i++) {
            items.add(item);
        }
    }
    

public double calcularSubtotal() {
        double subtotal = 0;
        for (ItemMenu item : items) {
            subtotal += item.calcularPrecio();
        }
        return subtotal;
    }

    public List<ItemMenu> getItems() {
        return new ArrayList<>(items);
    }

    public void cobrar(MetodoPago metodoPago) {
        double total = metodoPago.calcularTotal(calcularSubtotal());
        System.out.println("Total a pagar con " + metodoPago.getNombre() + ": ₡" + total);
    }
}

