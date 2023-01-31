package e1;
import java.time.*;

public class Cancelled implements Estado {
    private static final Cancelled instancia = new Cancelled();
    private Cancelled(){

    }

    public static Cancelled getInstancia(){
        return instancia;
    }

    @Override
    //esta operacion no tiene implementacion en este estado
    public void add(Order r, String nombre, int n){
        throw new IllegalArgumentException("Non se pode añadir en este estado");
    }

    @Override
    //esta operacion no tiene implementacion en este estado
    public void eliminar(Order r, String nombre){
        throw new IllegalArgumentException("Non se pode eliminar en este estado");
    }

    @Override
    //esta operacion no tiene implementacion en este estado
    public void modificar(Order r, String nombre, int n){
        throw new IllegalArgumentException("Non se pode modificar o pedido");
    }

    @Override
    public boolean completado(Order r){
        LocalDateTime hoy = LocalDateTime.of(2022, 12, 13,18, 15, 20);

        if(!r.time.isAfter(hoy)){
            r.setEstado(this);
            return false;
        }else{
            r.setEstado(Completed.getInstancia());
            return true;
        }

    }

    @Override
    //esta operacion no tiene implementacion en este estado
    public boolean pagado(Order r){
        throw new IllegalArgumentException("Non se pode pagar en este estado");
    }

    @Override
    public void siguiente(Order r){
        throw new IllegalArgumentException("Non hai paso siguiente");
    }

    @Override
    //esta operacion no tiene implementacion en este estado
    public void previous(Order r){
        throw new IllegalArgumentException("Non se pode volver a un paso anterior");
    }

    @Override
    public String screenInfo(Order r){
        StringBuilder screen = new StringBuilder();
        screen.append("Order Number : " + r.getTarifa() + "\n");
        screen.append("Cancelled Order");
        return screen.toString();
    }
}
