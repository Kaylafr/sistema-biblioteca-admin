/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.biblioteca.admin.model.domain;

/**
 *
 * @author Kayla
 */
public class Livro {

    private Long idLivro;
    private String titulo;
    private String genero;
    private Long idAutor;

    public Livro() {
    }

    public Livro(Long idLivro, String titulo, String genero, Long idAutor) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.genero = genero;
        this.idAutor = idAutor;
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    @Override
    public String toString() {
        return "Livro{"
                + "idLivro=" + idLivro
                + ", titulo='" + titulo + '\''
                + ", genero='" + genero + '\''
                + ", idAutor=" + idAutor
                + '}';
    }
}
