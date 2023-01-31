package e1;

import java.util.ArrayList;

public class Almacen {
    //lista de productos del almacen
    ArrayList<Producto> almacen = new ArrayList<>();

    public boolean decrementarAlmacen(String nombre, int stock) {
        boolean a = true;
        for (Producto p : almacen) {
            if (p.nombre.equals(nombre)) {//recorremos el almacen y si encontramos el producto deseado miremos que el stock a decrementar sea valido
                if (stock <= p.Stock && stock > 0) {
                    p.setStock(p.getStock() - stock);//decrementamos el stock
                    a = true;
                } else {
                    a = false;
                }
                break;
            } else {
                a = false;
            }
        }
        return a;
    }


    public void anadirAlmacen(String nombre, int stock) {
        for (Producto p : almacen) {
            if (p.nombre.equals(nombre)) {//Recorremos el almacen y cuando tengamos el objeto deseado incrementamos su stock
                p.setStock(p.getStock() + stock);
                break;
            }
        }
    }
}
