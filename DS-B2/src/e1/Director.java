package e1;

public class Director extends Tecnicos {
    private int ano;//numero de anos de experiencia
    private int salarioA;//salario extra por anos de experiencia
    public Director(String nome, String apellidos, String dni, int telefono, String nacionalidad, int horas, int ano, float recaudacion) {
        super(nome, apellidos, dni, telefono, nacionalidad, horas, recaudacion);
        this.setJob(6);
        this.setRecaudacion(1);
        this.setSalarioA(ano);
        this.setAno(ano);
        if(ano>=0){
            this.setSalario(9);
        }else{
            throw new IllegalArgumentException ("Os anos non poden ser negativos");
        }
    }

    public int getAno() {
        return ano;
    }

    @Override
    public int getSalarioA(){
        return salarioA;
    }

    public void setAno(int ano){
        this.ano = ano;
    }

    public void setSalarioA(int ano){
        this.salarioA=ano*1000;
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
        datos.append(this.getNome() + " " + this.getApellidos() + " (" + this.getJob() + ", " + this.getAno() + " years of experience): "
                + (this.getSalario()+this.getSalarioA()) + " euro");
        String data = datos.toString();
        return data;
    }
}
