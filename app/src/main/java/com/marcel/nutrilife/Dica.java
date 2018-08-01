package com.marcel.nutrilife;

/**
 * Created by Marcel on 15/06/2016.
 */
public class Dica {
    private String descricao;
    private String tipo;

    public Dica () {
        super();
    }

    public Dica (String descricao, String tipo){
        this.setDescricao(descricao);
        this.setTipo(tipo);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
