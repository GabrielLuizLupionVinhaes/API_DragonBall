package org.example.classes;

public class Personagem {
    private int id;
    private String nome;
    private String ki;
    private String maxKi;
    private String raca;
    private String genero;
    private String descricao;
    private String afiliacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getKi() {
        return ki;
    }

    public void setKi(String ki) {
        this.ki = ki;
    }

    public String getMaxKi() {
        return maxKi;
    }

    public void setMaxKi(String maxKi) {
        this.maxKi = maxKi;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAfiliacao() {
        return afiliacao;
    }

    public void setAfiliacao(String afiliacao) {
        this.afiliacao = afiliacao;
    }

    @Override
        public String toString() {
            return "Personagem{" + '\n' + 
                    "  id = " + id + '\n' +
                    "  nome = " + nome + '\n' +
                    "  ki = " + ki + '\n' +
                    "  raça = " + raca + '\n' +
                    "  Afiliação = " + afiliacao + '\n' +
                    '}';
        }
}
