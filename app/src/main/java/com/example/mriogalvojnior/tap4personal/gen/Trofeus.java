package com.example.mriogalvojnior.tap4personal.gen;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table "TROFEUS".
 */
public class Trofeus {

    private Long id;
    private String colocacao;
    private String campeonato;
    private String ano;
    private long atletaID;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public Trofeus() {
    }

    public Trofeus(Long id) {
        this.id = id;
    }

    public Trofeus(Long id, String colocacao, String campeonato, String ano, long atletaID) {
        this.id = id;
        this.colocacao = colocacao;
        this.campeonato = campeonato;
        this.ano = ano;
        this.atletaID = atletaID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColocacao() {
        return colocacao;
    }

    public void setColocacao(String colocacao) {
        this.colocacao = colocacao;
    }

    public String getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(String campeonato) {
        this.campeonato = campeonato;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public long getAtletaID() {
        return atletaID;
    }

    public void setAtletaID(long atletaID) {
        this.atletaID = atletaID;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
