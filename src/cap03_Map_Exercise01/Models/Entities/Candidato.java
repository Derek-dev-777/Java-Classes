package cap03_Map_Exercise01.Models.Entities;

public class Candidato {

    private String nome;
    private Integer votos;

    public Candidato(){}

    public Candidato(String nome, Integer votos) {
        this.nome = nome;
        this.votos = votos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVotos() {
        return votos;
    }

    public void setVotos(Integer votos) {
        this.votos = votos;
    }
}
