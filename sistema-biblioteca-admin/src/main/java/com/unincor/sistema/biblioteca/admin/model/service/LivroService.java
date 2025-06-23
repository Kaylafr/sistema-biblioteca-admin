/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.biblioteca.admin.model.service;

/**
 *
 * @author Kayla
 */
import com.unincor.sistema.biblioteca.admin.model.dao.LivroDao;
import com.unincor.sistema.biblioteca.admin.model.domain.Livro;
import java.sql.SQLException;
import java.util.List;

public class LivroService {

    private final LivroDao livroDao = new LivroDao();

    public void salvarLivro(Livro livro) throws CadastroException,
            SQLException {
        if (livro.getTitulo() == null || livro.getTitulo().isBlank()) {
            throw new CadastroException("Título do livro não pode estar vazio");
        }

        if (livro.getIdAutor() == null) {
            throw new CadastroException("Autor deve ser informado");
        }

        livroDao.inserirLivro(livro);
    }

    public Livro buscarPorId(Long id) {
        return livroDao.buscarLivroPorId(id);
    }

    public List<Livro> listarTodos() {
        return livroDao.listarTodosLivros();
    }

    public static void main(String[] args) {
        LivroService livroService = new LivroService();

        Livro livro = new Livro();
        livro.setTitulo("A Hora da Estrela");
        livro.setGenero("Romance");
        livro.setIdAutor(1l); // Altere conforme o ID real do autor no seu banco

        try {
            livroService.salvarLivro(livro);
            System.out.println("Livro salvo com sucesso!");
        } catch (CadastroException | SQLException e) {
            System.out.println("Erro ao salvar livro: " + e.getMessage());
        }

    }
}
