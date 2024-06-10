import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class Producto implements Comparable<Producto> {
    protected String nombre;
    protected double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public int compareTo(Producto otroProducto) {
        return Double.compare(this.precio, otroProducto.precio);
    }

    @Override
    public abstract String toString();
}

class Bebida extends Producto {
    private double litros;

    public Bebida(String nombre, double litros, double precio) {
        super(nombre, precio);
        this.litros = litros;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " /// Litros: " + litros + " /// Precio: $" + precio;
    }
}

class Shampoo extends Producto {
    private double contenido;

    public Shampoo(String nombre, double contenido, double precio) {
        super(nombre, precio);
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " /// Contenido: " + contenido + "ml /// Precio: $" + precio;
    }
}

class Fruta extends Producto {
    private String unidadVenta;

    public Fruta(String nombre, double precio, String unidadVenta) {
        super(nombre, precio);
        this.unidadVenta = unidadVenta;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " /// Precio: $" + precio + " /// Unidad de venta: " + unidadVenta;
    }
}

public class Supermercado {
    public static void main(String[] args) {
        List<Producto> productos = cargarProductos();

        for (Producto producto : productos) {
            System.out.println(producto);
        }

        System.out.println("=============================");

        Producto productoMasCaro = Collections.max(productos);
        Producto productoMasBarato = Collections.min(productos);

        System.out.println("Producto más caro: " + productoMasCaro.nombre);
        System.out.println("Producto más barato: " + productoMasBarato.nombre);
    }

    public static List<Producto> cargarProductos() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Bebida("Coca-Cola Zero", 1.5, 20));
        productos.add(new Bebida("Coca-Cola", 1.5, 18));
        productos.add(new Shampoo("Shampoo Sedal", 500, 19));
        productos.add(new Fruta("Frutillas", 64, "kilo"));
        return productos;
    }
}
