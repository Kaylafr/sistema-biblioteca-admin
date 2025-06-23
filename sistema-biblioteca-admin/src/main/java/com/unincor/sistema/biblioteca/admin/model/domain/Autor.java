/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.biblioteca.admin.model.domain;

import java.time.LocalDate;

/**
 *
 * @author Kayla
 */
public class Autor {

    private Long idAutor;
    private String nome;
    private String nacionalidade;
    private LocalDate dataNascimento;

    public Autor() {
    }

    public Autor(Long idAutor, String nome, String nacionalidade,
            LocalDate dataNascimento) {
        this.idAutor = idAutor;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.dataNascimento = dataNascimento;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Autor{"
                + "idAutor=" + idAutor
                + ", nome='" + nome + '\''
                + ", nacionalidade='" + nacionalidade + '\''
                + ", dataNascimento=" + dataNascimento
                + '}';
    }
}
