package e1;

public class Payment implements Estado {
    private static final Payment instancia = new Payment();
    private Payment(){

    }
    public static Payment getInstancia(){
        return instancia;
    }
    @Override
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
        return false;
    }

    @Override
    public boolean pagado(Order r){
        return true;
    }

    @Override
    public void siguiente(Order r){
        r.setEstado(Cancelled.getInstancia());
    }

    @Override
    //esta operacion no tiene implementacion en este estado
    public void previous(Order r){
        throw new IllegalArgumentException("Non se pode volver a un paso anterior");
    }

    @Override
    public String screenInfo(Order r){
        //int fecha = ;
        //int hora = ;
        int n = r.listCarro.size();
        StringBuilder screen = new StringBuilder();
        screen.append("Order Number : " + r.getTarifa() + "\n");
        screen.append("Paid Order : " + n + " products -- date " + "fecha-hora ");
        return screen.toString();
    }
}
