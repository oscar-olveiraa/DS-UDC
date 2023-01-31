package e1;
import java.time.*;
import java.util.*;
public class Order {
    Estado estado = ShoppingCart.getInstancia();
    ArrayList<Producto> listCarro = new ArrayList<>();
    LocalDateTime time = LocalDateTime.now();
    public Almacen a;
    private final int tarifa;
    public List<String> historial = new ArrayList<>();

    public Order(Almacen a, int tarifa, LocalDateTime t){
        this.a = a;
        this.listCarro = new ArrayList<>();
        this.tarifa = tarifa;
        this.time=t;
    }

    public void setEstado (Estado state){
        this.estado = state;
    }

    public  Estado getEstado(){
        return estado;
    }

    public int getTarifa(){
        return tarifa;
    }

    public void add(String nombre, int n){
        estado.add(this, nombre, n);
    }

    public void eliminar(String nombre){
        estado.eliminar(this, nombre);
    }

    public boolean completado(){
        return estado.completado(this);
    }

    public boolean pagado(){
        return estado.pagado(this);
    }

    public void modificar(String nombre, int n){
        estado.modificar(this, nombre,n);
    }

    public void siguiente(){
        estado.siguiente(this);
    }

    public void previous(){
        estado.previous(this);
    }

    public String screenInfo(){
        StringBuilder inicio = new StringBuilder();
        if(listCarro.isEmpty() && getEstado() == ShoppingCart.getInstancia()){
                inicio.append("Shopping -- Welcome to online shop");
                return inicio.toString();
        }else {
            return estado.screenInfo(this);
        }
    }

    public String log(){
        StringBuilder hist = new StringBuilder();

        for(String r : historial){
            hist.append(r);
            hist.append("\n");
        }
        return hist.toString();
    }

}

