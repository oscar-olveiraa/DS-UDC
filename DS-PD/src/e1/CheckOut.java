package e1;

public class CheckOut implements Estado {
    private static final CheckOut instancia = new CheckOut();

    private CheckOut() {

    }

    public static CheckOut getInstancia() {
        return instancia;
    }

    @Override
    //En este paso no se pueden añadir productos nuevos, habría que volver al paso inicial
    public void add(Order r, String nombre, int n) {
        throw new IllegalArgumentException("Non se pode añadir produtos neste paso");
    }

    @Override
    public void eliminar(Order r, String nombre) {
        int n;
        //Recorremos la lista del carrito
        for (Producto prod : r.listCarro) {
            //Cuando encontremos el producto deseado guardamos su stock, añadimos esa cantidad al almacen y eliminamos el producto de la lista del carro
            if (prod.nombre.equals(nombre)) {
                n = prod.getStock();
                r.a.anadirAlmacen(nombre, n);
                r.listCarro.remove(prod);
                //Guardamos la operación en el historial
                r.historial.add("-Remove : Item: " + nombre + " -> Shopping Cart -- Products: " + n);
                break;
            } else {
                throw new IllegalArgumentException("Non se atopa na lista o elemento a modificar");
            }

        }

    }

    @Override
    public void modificar(Order r, String nombre, int n) {
        int k;
        //Recorremos la lista del carrito
        for (Producto prod : r.listCarro){
            if(prod.nombre.equals(nombre)){
                k = prod.getStock();//cuando encontremos el producto deseado obtenemos su stock
                if(n == 0){ //Si la cantidad deseada del producto es "0", añadimos el stock al almacen y eliminamos el producto de la lista del carrito
                    r.a.anadirAlmacen(nombre, k);
                    r.listCarro.remove(prod);
                    //guardamos la operacion en el historial
                    r.historial.add("-Modify : Item : " + nombre + " - Quantity: " + n + " -> CheckOut Order -- Products : " + r.listCarro.size());
                    break;
                } else if(n>0) {//Si la cantidad a añadir es positiva
                    r.a.anadirAlmacen(nombre, k); //Añadimos la cantidad actual al almacen y eliminamos el producto
                    r.listCarro.remove(prod);
                    if(r.a.decrementarAlmacen(nombre,n)){//si podemos decrementar el almacen, decrementamos y añadimos el nuevo producto en el carrito
                        r.listCarro.add(new Producto(nombre, n));
                        //guardamos la operacion en el historial
                        r.historial.add("-Modify : Item : " + nombre + " - Quantity: " + n + " -> CheckOut Order -- Products : " + r.listCarro.size());
                        break;
                    }else{
                        throw new IllegalArgumentException("Non existe stock suficiente para ese produto");
                    }
                }else{//Si la cantidad a añadir es negativa
                    throw new IllegalArgumentException("Non se pode añadir esa cantidade");
                }
            } else {
                throw new IllegalArgumentException("Non se atopa na lista o elemento a modificar");
            }

        }
    }

    @Override
    public boolean completado(Order r) {
        return false;
    }

    @Override
    //Esta operacion no tiene implementacion para este estado
    public boolean pagado(Order r) {
        throw new IllegalArgumentException("Non se pode pagar o pedido");
    }

    @Override
    public void siguiente(Order r) {
        r.setEstado(Payment.getInstancia());
    }

    @Override
    public void previous(Order r) {
        r.setEstado(ShoppingCart.getInstancia());
    }

    @Override
    //Metodo para imprimir por pantalla los productos que hay en el carrito
    public String screenInfo(Order r){
       int n = r.listCarro.size();
        StringBuilder screen = new StringBuilder();
        screen.append("Order Number : " + r.getTarifa() + "\n");
        screen.append("Check Out : " + n +" products");
        return screen.toString();
    }
}

