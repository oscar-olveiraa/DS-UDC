package e1;

//Interfaz de los estados
public interface Estado {

    void add(Order r, String nombre, int n);

    void eliminar(Order r, String nombre);

    boolean pagado(Order r);

    void modificar(Order r, String nombre, int n);

    boolean completado(Order r);

    void siguiente(Order r);

    void previous(Order r);

    String screenInfo(Order r);
}
