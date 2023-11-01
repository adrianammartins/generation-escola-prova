package generation.escola.prova.domain.model;

import jakarta.persistence.*;

@Entity(name = "tb_aluno")
public class Aluno {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) //Gera o id automaticamente
        private Long id;
        private String nome;
        private int idade;
        private float primeiraNota;
        private float segundaNota;
        private String nomeProfessor;
        private int numeroSala;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getPrimeiraNota() {
        return primeiraNota;
    }

    public void setPrimeiraNota(float primeiraNota) {
        this.primeiraNota = primeiraNota;
    }

    public float getSegundaNota() {
        return segundaNota;
    }

    public void setSegundaNota(float segundaNota) {
        this.segundaNota = segundaNota;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }
}
