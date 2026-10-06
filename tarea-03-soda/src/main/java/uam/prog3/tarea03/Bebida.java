package uam.prog3.tarea03;

public class Bebida extends ItemMenu {
    private boolean grande;

    public Bebida(String nombre, double precioBase, boolean grande) {
        super(nombre, precioBase);
        this.grande = grande;
    }


    @Override 
    public double calcularPrecio() {
        if (grande) {
            return getprecioBase() + 500;
        }
        return getprecioBase();
    }

    @Override
    public String describirItem() {
        if (grande) {
            return super.describirItem() + " (grande)";
        }
        return super.describirItem();
    } 
    
}
