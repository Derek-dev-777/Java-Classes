package cap04_StreamLambda_Exercise02.Model.Entities;

public class Employee {

    private String nome;
    private String email;
    private Double salary;

    public Employee(){}

    public Employee(String nome, Double salary, String email) {
        this.nome = nome;
        this.salary = salary;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
