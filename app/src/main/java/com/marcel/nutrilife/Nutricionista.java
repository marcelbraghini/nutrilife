package com.marcel.nutrilife;

/**
 * Created by Marcel on 07/06/2016.
 */
public class Nutricionista {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private String cidade;

    public Nutricionista () {
        super();
    }

    public Nutricionista (String nome, String telefone, String email, String endereco, String cidade){
        super();
        this.setNome(nome);
        this.setTelefone(telefone);
        this.setEmail(email);
        this.setEndereco(endereco);
        this.setCidade(cidade);
        this.setEndereco(endereco);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
