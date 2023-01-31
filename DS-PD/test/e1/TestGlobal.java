package e1;

import org.junit.jupiter.api.Test;

import java.time.*;

import static org.junit.jupiter.api.Assertions.*;

class TestGlobal {
    Almacen a = new Almacen();
    Order r = new Order(a, 111, LocalDateTime.now());
    //Creamos productos
    Producto pro = new Producto("almendras", 5);
    Producto pro1 = new Producto("naranxas", 9);
    Producto pro2 = new Producto("peras", 3);

    @Test
    void ComprobarAlmacen(){
        Producto pro = new Producto("almendras", 5);
        Producto pro1 = new Producto("naranxas", 9);
        Producto pro2 = new Producto("peras", 3);
        a.almacen.add(pro);
        a.almacen.add(pro1);
        a.almacen.add(pro2);
        //Comprobamos que los productos se guardaran correctamente en el almacen
        for(Producto p : a.almacen){
            if(p.equals(pro)){
                assertEquals(5,p.getStock());
            }
            if(p.equals(pro1)){
                assertEquals(9,p.getStock());
            }
            if(p.equals(pro2)){
                assertNotEquals(5,p.getStock());
            }
        }
    }

    @Test
    void ComprobacionGlobal(){
        a.almacen.add(pro);
        a.almacen.add(pro1);
        a.almacen.add(pro2);

        assertEquals("Shopping -- Welcome to online shop", r.screenInfo());
        //añadimos dos productos a la lista del carrito
        r.add("almendras",2);
        r.add("peras", 1);

        assertEquals(2, r.listCarro.size());
        assertEquals("Order Number : 111" + "\n" +
                "Shopping -- 2 products", r.screenInfo());

        r.eliminar("peras");
        assertEquals(1, r.listCarro.size());

        //Pasamos al siguiente estado
        r.siguiente();
        //modificamos la cantidad de almendras
        r.modificar("almendras", 1);
        assertEquals(1, r.listCarro.size());
        assertEquals("Order Number : 111" + "\n" +
                "Check Out : 1 products", r.screenInfo());
        //Volvemos al estado anterior
        r.previous();
        //añadimos un nuevo producto
        r.add("naranxas", 4);
        assertEquals(2, r.listCarro.size());
        assertEquals("Order Number : 111" + "\n" +
                "Shopping -- 2 products", r.screenInfo());
        //Pasamos al siguiente estado
        r.siguiente();
        assertEquals("Order Number : 111" + "\n" +
                "Check Out : 2 products", r.screenInfo());
        //Pasamos al siguiente estado
        r.siguiente();
        assertEquals("Order Number : 111" + "\n" +
                "Paid Order : 2 products -- date fecha-hora ", r.screenInfo());
        //Pasamos al siguiente estado
        r.siguiente();
        assertEquals("Order Number : 111" + "\n" +
                "Cancelled Order", r.screenInfo());
        //Pasamos al siguiente estado
        r.siguiente();
        assertEquals("Order Number : 111" + "\n" +
                "Completed Order : 2 products", r.screenInfo());

        assertEquals("-Add : Item : almendras - Quantity: 2 -> Shopping Cart -- Products: 1" + "\n" +
                "-Add : Item : peras - Quantity: 1 -> Shopping Cart -- Products: 2" + "\n" +
                "-Remove : Item : peras -> Shopping Cart -- Products: 1" + "\n" +
                "-Modify : Item : almendras - Quantity: 1 -> CheckOut Order -- Products : 1" + "\n" +
                "-Add : Item : naranxas - Quantity: 4 -> Shopping Cart -- Products: 2\n", r.log());

    }

}