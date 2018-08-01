package com.marcel.nutrilife;

/**
 * Created by Marcel on 04/06/2016.
 */
public class Pessoa {
    private String nome;
    private String peso;
    private String altura;
    private String usuario;
    private String senha;
    private String endereco;
    private String cidade;
    private String telefone;
    private String nut_codigo;


    public Pessoa () {
        super();
    }

    public Pessoa (String nome, String peso, String altura, String usuario, String senha, String endereco, String cidade, String telefone, String nut_codigo){
        super();
        this.setNome(nome);
        this.setPeso(peso);
        this.setAltura(altura);
        this.setUsuario(usuario);
        this.setSenha(senha);
        this.setEndereco(endereco);
        this.setCidade(cidade);
        this.setTelefone(telefone);
        this.setNut_codigo(nut_codigo);
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNut_codigo() {
        return nut_codigo;
    }

    public void setNut_codigo(String nut_codigo) {
        this.nut_codigo = nut_codigo;
    }
}
