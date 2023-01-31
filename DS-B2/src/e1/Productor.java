package e1;

public class Productor extends Tecnicos {
    public Productor(String nome, String apellidos, String dni, int telefono, String nacionalidad, int horas, float recaudacion) {
        super(nome, apellidos, dni, telefono, nacionalidad, horas, recaudacion);
        this.setSalario(8);
        this.setJob(5);
        this.setRecaudacion(3);
    }

    @Override
    public String getRoyalties(){
        StringBuilder datos = new StringBuilder();
        datos.append(this.getNome() + " " + this.getApellidos() + " (" + this.getJob() + "): "
                + this.getRecaudacion() + " euro");
        String data = datos.toString();
        return data;
    }

    @Override
    public String getSalarios(){
        StringBuilder datos = new StringBuilder();
        datos.append(this.getNome() + " " + this.getApellidos() + " (" + this.getJob() + "): "
                + this.getSalario() + " euro");
        String data = datos.toString();
        return data;
    }
}
