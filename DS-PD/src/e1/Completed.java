package e1;

public class Completed implements Estado{
    private static final Completed instancia = new Completed();
    private Completed(){

    }

    public static Completed getInstancia(){
        return instancia;
    }
    @Override
    //esta operacion no tiene implementacion en este estado
    public void add(Order r, String nombre, int n){
        throw new IllegalArgumentException("Non se pode añadir produtos");
    }

    @Override
    //esta operacion no tiene implementacion en este estado
    public void eliminar(Order r, String nombre){
        throw new IllegalArgumentException("Non se pode eliminar produtos");
    }

    @Override
    //esta operacion no tiene implementacion en este estado
    public void modificar(Order r, String nombre, int n){
        throw new IllegalArgumentException("Non se pode modificar o pedido");
    }

    @Override
    public boolean completado(Order r){
        return true;
    }


    @Override
    public boolean pagado(Order r){
        return true;
    }


    @Override
    //esta operacion no tiene implementacion en este estado
    public void siguiente(Order r){
        throw new IllegalArgumentException("Non hai ningun paso siguiente");
    }

    @Override
    //esta operacion no tiene implementacion en este estado
    public void previous(Order r){
        throw new IllegalArgumentException("Non se pode volver a un paso anterior");
    }

    @Override
    public String screenInfo(Order r){
        int n = r.listCarro.size();
        StringBuilder screen = new StringBuilder();
        screen.append("Order Number : " + r.getTarifa() + "\n");
        screen.append("Completed Order : " + n + " products");
        return screen.toString();
    }
}
