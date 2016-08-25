package com.example.mriogalvojnior.tap4personal.gen;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table "PATOLOGIA".
 */
public class Patologia {

    private Long id;
    private String nome;
    private long alunoID;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public Patologia() {
    }

    public Patologia(Long id) {
        this.id = id;
    }

    public Patologia(Long id, String nome, long alunoID) {
        this.id = id;
        this.nome = nome;
        this.alunoID = alunoID;
    }

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

    public long getAlunoID() {
        return alunoID;
    }

    public void setAlunoID(long alunoID) {
        this.alunoID = alunoID;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
