package e1;

import java.util.ArrayList;

public class Producto {
    public String nombre;
    public int Stock;

    public Producto(String nombre, int stock) {
        this.nombre = nombre;
        this.Stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        this.Stock = stock;
    }

}

