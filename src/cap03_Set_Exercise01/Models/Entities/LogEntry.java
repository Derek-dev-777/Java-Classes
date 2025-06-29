package cap03_Set_Exercise01.Models.Entities;

import java.util.Date;
import java.util.Objects;
/*
Essa classe recebe nome e hora de entrada de um usuario,
O hashcode e o equals são validos para o nome do usuario apenas.
*/
public class LogEntry {

    // Atributos
    private String nome;
    private Date moment;

    // Construtor
    public LogEntry(String nome, Date moment) {
        this.nome = nome;
        this.moment = moment;
    }

    // Getters and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    // Hashcode and equals for "nome"
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LogEntry logEntry = (LogEntry) o;
        return Objects.equals(nome, logEntry.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }
}
