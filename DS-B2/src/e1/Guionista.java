package e1;

public class Guionista extends Tecnicos{
    //private Boolean guion;//variable para saber si e original ou no
    private String state;

    public Guionista(String nome, String apellidos, String dni, int telefono, String nacionalidad, int horas, String state, float recaudacion) { //añadir si fai falta bool guion
        super(nome, apellidos, dni, telefono, nacionalidad, horas, recaudacion);
        this.setState(state);
        this.setJob(2);
        this.setRecaudacion(0);
        if(state.equals("original")){
            this.setState("original");
            this.setSalario(5);

        }else{
            this.setState("no original");
            this.setSalario(4);
        }
    }

    public String getState() {
        return state;
    }

    public void setState(String state){
        this.state=state;
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
        datos.append(this.getNome() + " " + this.getApellidos() + " " + "(" + this.getJob() + ", "  + this.getState() + " screenplay): "
                + this.getSalario() + " euro");
        String data = datos.toString();
        return data;
    }
}
