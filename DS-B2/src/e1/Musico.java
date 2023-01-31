package e1;

public class Musico extends Tecnicos {

    public Musico(String nome, String apellidos, String dni, int telefono, String nacionalidad, int horas, float recaudacion) {
        super(nome, apellidos, dni, telefono, nacionalidad, horas, recaudacion);
        this.setSalario(6);
        this.setJob(3);
        this.setRecaudacion(2);
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
