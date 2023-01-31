package e1;

public class ShoppingCart implements Estado{
    private static final ShoppingCart instancia = new ShoppingCart();

    private ShoppingCart(){
    }

    public static ShoppingCart getInstancia(){
        return instancia;
    }

    public void add(Order r, String nombre, int n){
                    //Si no se puede decrementar el almacen lanzamos la excepción
                    if(!r.a.decrementarAlmacen(nombre,n)){
                        throw new IllegalArgumentException("Non se pode añadir este producto a lista do carro");
                    }else {
                        //Añadimos un nuevo producto a la lista y guardamos la operacion en el historial
                        r.listCarro.add(new Producto(nombre, n));
                        r.historial.add("-Add : Item : " + nombre + " - Quantity: " + n + " -> Shopping Cart -- Products: " + r.listCarro.size());
                    }
    }

    public void eliminar(Order r, String nombre){
        int n;
        boolean a = false;
        //Recorremos la lista del carrito
            for(Producto prod : r.listCarro){
                //Cuando encontremos el producto deseado obtenemos su stock, añadimos esa cantidad al almacen y eliminamos el producto
                if(prod.nombre.equals(nombre)){
                    n = prod.getStock();
                    r.a.anadirAlmacen(nombre,n);
                    r.listCarro.remove(prod);
                    //Guardamos la operación en el historial
                    r.historial.add("-Remove : Item : " + nombre + " -> Shopping Cart -- Products: " + r.listCarro.size());
                    a = true;
                    break;
                }
            }
            //si no se encuentra el producto lanzamos la excepcion
            if(!a){
                throw new IllegalArgumentException("Non se pode eliminar o producto");
            }

      }

    //Esta operación no tiene implementación en este estado
    @Override
    public void modificar(Order r, String nombre, int n){
        throw new IllegalArgumentException("Non se pode modificar o pedido neste estado");
    }

    //Esta operación no tiene implementación en este estado
    @Override
    public boolean completado(Order r){
            return false;
    }

    //Esta operación no tiene implementación en este estado
    @Override
    public boolean pagado(Order r){
        throw new IllegalArgumentException("Non se pode pagar neste paso");
    }

    @Override
    public void siguiente(Order r){
        r.setEstado(CheckOut.getInstancia());
    }

    @Override
    public void previous(Order r){
        throw new IllegalArgumentException("Non se pode volver a un paso anterior");
    }

    @Override
    //Metodo para imprimir por pantalla los productos que hay en el carrito
    public String screenInfo(Order r){
        int n = r.listCarro.size();
        StringBuilder screen = new StringBuilder();
        screen.append("Order Number : " + r.getTarifa() + "\n");
        screen.append("Shopping -- " + n + " products");
        return screen.toString();
    }

}
