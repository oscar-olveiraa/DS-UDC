package e1;

import org.junit.jupiter.api.Test;

import java.time.*;

import static org.junit.jupiter.api.Assertions.*;


class OrderTest {
    Almacen a = new Almacen();
    Order r = new Order(a, 111, LocalDateTime.now());

    Producto pro = new Producto("almendras", 10);
    Producto pro1 = new Producto("naranxas", 14);
    Producto pro2 = new Producto("peras", 8);
    Producto pro3 = new Producto("banana", 22);


    @Test
    void ShoppingCartTest(){
        a.almacen.add(pro);
        a.almacen.add(pro1);
        a.almacen.add(pro2);
        a.almacen.add(pro3);
        assertEquals("Shopping -- Welcome to online shop", r.screenInfo());
        //comprobamos que non se poda añadir produtos que non estean no almacen
        assertThrows(IllegalArgumentException.class, ()->r.add("limons", 4));
        //añadimos produtos ao carrito
        r.add("almendras", 5);
        r.add("naranxas", 5);
        r.add("peras", 3);
        //comprobamos o tamaño do carrito
        assertEquals(3, r.listCarro.size());
        //comprobamos que o stock dos produtos se modificaran alamcen
        assertEquals(5, pro.getStock());
        assertEquals(9, pro1.getStock());
        assertEquals(5,pro2.getStock());
        assertEquals("Order Number : 111" + "\n" +
                "Shopping -- 3 products", r.screenInfo());
        //eliminamos un produto
        r.eliminar("peras");
        //comprobamos o tamaño do carrito
        assertEquals(2, r.listCarro.size());
        assertEquals(5, pro.getStock());
        assertEquals(9, pro1.getStock());
        assertEquals(8,pro2.getStock());
        assertThrows(IllegalArgumentException.class, ()->r.pagado());
        assertFalse(r.completado());
        assertEquals("Order Number : 111" + "\n" +
                "Shopping -- 2 products", r.screenInfo());
    }


    @Test
    void CheckOutTest(){
        ShoppingCartTest();

        r.siguiente();
        //comprobamos que non podamos añadir no estado de CheckOut productos que xa estan no carrito
        assertThrows(IllegalArgumentException.class, ()->r.add("almendras", 4));
        //modificamos a cantidad dos produtos no carrito e comprobamos que se modifique tamen o stock do almacen
        r.modificar("almendras", 2);
        assertEquals(8, pro.getStock());
        r.modificar("naranxas", 0);
        assertEquals(1,r.listCarro.size());
        assertEquals(14, pro1.getStock());
        assertThrows(IllegalArgumentException.class, ()->r.modificar("almendras", -2));
        assertThrows(IllegalArgumentException.class, ()->r.modificar("naranxas", 18));//queremos unha cantidade do produto maior que o dispoñoble no almacen
        assertThrows(IllegalArgumentException.class, ()->r.eliminar("naranxas"));
        //volvemos ao paso anterior(ShoppingCart)
        r.previous();
        r.add("banana", 10);
        assertEquals(2, r.listCarro.size());
        //se queremos eliminar un produto que non está no carrito
        assertThrows(IllegalArgumentException.class, ()->r.eliminar("naranxas"));
        r.siguiente();
        assertThrows(IllegalArgumentException.class, ()->r.pagado());
        assertFalse(r.completado());
        assertEquals("Order Number : 111" + "\n" +
                "Check Out : 2 products", r.screenInfo());
    }

    @Test
    void PaymentTest(){
        CheckOutTest();

        r.siguiente();
        assertThrows(IllegalArgumentException.class, ()->r.eliminar("naranxas"));
        assertThrows(IllegalArgumentException.class, ()->r.modificar("almendras", 3));
        assertThrows(IllegalArgumentException.class, ()->r.modificar("peras", 2));
        assertFalse(r.completado());
        assertEquals("Order Number : 111" + "\n" +
                "Paid Order : 2 products -- date fecha-hora ", r.screenInfo());
    }

    @Test
    void Cancelled_CompletedTest(){
        PaymentTest();

        r.siguiente();
        assertThrows(IllegalArgumentException.class, ()->r.eliminar("naranxas"));
        assertThrows(IllegalArgumentException.class, ()->r.modificar("almendras", 3));
        assertThrows(IllegalArgumentException.class, ()->r.modificar("peras", 2));
        assertThrows(IllegalArgumentException.class, ()->r.pagado());
        //si non pasaron as 24h (comentar si pasaron 24h)
        /*assertFalse(r.completado());
        assertEquals("Order Number : 111" + "\n" +
                "Cancelled Order", r.screenInfo());*/

        //si pasaron as 24h(descomentar para comprobar)
        assertTrue(r.completado());
        assertTrue(r.pagado());
        assertThrows(IllegalArgumentException.class, ()->r.modificar("peras", 2));
        assertThrows(IllegalArgumentException.class, ()->r.previous());

        assertEquals("Order Number : 111" + "\n" +
                "Completed Order : 2 products", r.screenInfo());

    }

    @Test
    void historial(){
        Cancelled_CompletedTest();
        assertEquals("-Add : Item : almendras - Quantity: 5 -> Shopping Cart -- Products: 1" + "\n" +
                "-Add : Item : naranxas - Quantity: 5 -> Shopping Cart -- Products: 2" + "\n" +
                "-Add : Item : peras - Quantity: 3 -> Shopping Cart -- Products: 3" + "\n" +
                "-Remove : Item : peras -> Shopping Cart -- Products: 2" + "\n" +
                "-Modify : Item : almendras - Quantity: 2 -> CheckOut Order -- Products : 2" + "\n" +
                "-Modify : Item : naranxas - Quantity: 0 -> CheckOut Order -- Products : 1" + "\n" +
                "-Add : Item : banana - Quantity: 10 -> Shopping Cart -- Products: 2\n", r.log());
    }
}