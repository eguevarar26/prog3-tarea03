package uam.prog3.tarea03;

public abstract class ItemMenu {
        private String nombre;
        private double precioBase;

        public ItemMenu(String nombre, double precioBase) {
            this.nombre = nombre;
            if (precioBase <= 0) {
                System.out.println("Precio invalidivo para " + nombre + ". Se usa 0");
                this.precioBase = 0;
            } else {
                this.precioBase = precioBase;
            }
        }

        public String getNombre() {
            return nombre;
        }

        public double getprecioBase() {
            return precioBase;
        }

        public abstract double calcularPrecio();

        public String describirItem() {
            return nombre + " - ₡" + calcularPrecio();
        }
        
}
