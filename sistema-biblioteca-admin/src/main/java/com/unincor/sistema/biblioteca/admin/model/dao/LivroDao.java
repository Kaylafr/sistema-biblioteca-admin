/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.biblioteca.admin.model.dao;

import com.unincor.sistema.biblioteca.admin.configurations.MySQL;
import com.unincor.sistema.biblioteca.admin.model.domain.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kayla
 */
public class LivroDao {

    public void inserirLivro(Livro livro) {
        String sql = "INSERT INTO livros (titulo, genero, id_autor) VALUES (?, ?, ?)";
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, livro.getTitulo());
            ps.setString(2, livro.getGenero());
            ps.setLong(3, livro.getIdAutor());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(LivroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Livro> listarTodosLivros() {
        String sql = "SELECT * FROM livros";
        List<Livro> livros = new ArrayList<>();
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                livros.add(construirLivroSql(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return livros;
    }

    public Livro buscarLivroPorId(Long id) {
        String sql = "SELECT * FROM livros WHERE id_livro = ?";
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return construirLivroSql(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Livro construirLivroSql(ResultSet rs) throws SQLException {
        Livro livro = new Livro();
        livro.setIdLivro(rs.getLong("id_livro"));
        livro.setTitulo(rs.getString("titulo"));
        livro.setGenero(rs.getString("genero"));
        livro.setIdAutor(rs.getLong("id_autor"));
        return livro;
    }

    public static void main(String[] args) {
        LivroDao livroDao = new LivroDao();

        System.out.println("Teste de inserir livro:");
        Livro livro = new Livro(null, "Dom Casmurro", "Romance", 1L);
        livroDao.inserirLivro(livro);

        System.out.println("\nListar todos os livros:");
        List<Livro> livros = livroDao.listarTodosLivros();
        livros.forEach(lv -> System.out.println("Título: " + lv.getTitulo()));

        System.out.println("\nBuscar livro por ID:");
        Livro livroBuscado = livroDao.buscarLivroPorId(1l);
        if (livroBuscado != null) {
            System.out.println("Livro encontrado: " + livroBuscado.getTitulo());
        } else {
            System.out.println("Livro não encontrado.");
        }
    }
}
