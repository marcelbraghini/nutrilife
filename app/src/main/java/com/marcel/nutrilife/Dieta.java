package com.marcel.nutrilife;

/**
 * Created by Marcel on 09/06/2016.
 */
public class Dieta {
    private String descricao;
    private String hora;
    private String data;
    private String tipoDieta;
    private String tipoRefeicao;
    private String alimento;
    private String categoria;

    public Dieta(String title, String dieta, String string, String s) {
        super();
    }

    public Dieta (String descricao, String hora, String data, String tipoDieta, String tipoRefeicao, String alimento, String categoria){
        super();
        this.setDescricao(descricao);
        this.setHora(hora);
        this.setData(data);
        this.setTipoDieta(tipoDieta);
        this.setTipoRefeicao(tipoRefeicao);
        this.setAlimento(alimento);
        this.setCategoria(categoria);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTipoDieta() {
        return tipoDieta;
    }

    public void setTipoDieta(String tipoDieta) {
        this.tipoDieta = tipoDieta;
    }

    public String getTipoRefeicao() {
        return tipoRefeicao;
    }

    public void setTipoRefeicao(String tipoRefeicao) {
        this.tipoRefeicao = tipoRefeicao;
    }

    public String getAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
