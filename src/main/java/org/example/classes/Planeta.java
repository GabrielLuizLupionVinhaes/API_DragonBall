package org.example.classes;

public class Planeta {
    private int id;
    private String nome;
    private Boolean destruido;
    private String descricao;

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

    public Boolean isDestruido() {
        return destruido;
    }

    public void setDestruido(Boolean destruido) {
        this.destruido = destruido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString(){
        return "Planeta{" + '\n' +
                "  id = " + id + '\n' +
                "  nome = " + nome + '\n' +
                "  Está destruido?: " + destruido + '\n' +
                "}";
    }
}
