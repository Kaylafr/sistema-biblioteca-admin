/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.biblioteca.admin.model.dao;

/**
 *
 * @author Kayla
 */
import com.unincor.sistema.biblioteca.admin.configurations.MySQL;
import com.unincor.sistema.biblioteca.admin.model.domain.Autor;
import java.sql.Connection;
import java.sql.Date;
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
public class AutorDao {

    public void inserirAutor(Autor autor) {
        String sql = "INSERT INTO autores (nome, nacionalidade, data_nascimento) VALUES (?, ?, ?)";
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, autor.getNome());
            ps.setString(2, autor.getNacionalidade());
            ps.setDate(3, autor.getDataNascimento() != null ? Date.valueOf(autor.getDataNascimento()) : null);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AutorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Autor> listarTodosAutores() {
        String sql = "SELECT * FROM autores";
        List<Autor> autores = new ArrayList<>();
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                autores.add(construirAutorSql(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return autores;
    }

    public Autor buscarAutorPorId(Long id) {
        String sql = "SELECT * FROM autores WHERE id_autor = ?";
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return construirAutorSql(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Autor construirAutorSql(ResultSet rs) throws SQLException {
        Autor autor = new Autor();
        autor.setIdAutor(rs.getLong("id_autor"));
        autor.setNome(rs.getString("nome"));
        autor.setNacionalidade(rs.getString("nacionalidade"));

        Date data = rs.getDate("data_nascimento");
        if (data != null) {
            autor.setDataNascimento(data.toLocalDate());
        }

        return autor;
    }

    public static void main(String[] args) {
        AutorDao autorDao = new AutorDao();

        System.out.println("Inserindo autor:");
        Autor autor = new Autor(null, "Machado de Assis", "Brasileiro", java.time.LocalDate.of(1839, 6, 21));
        autorDao.inserirAutor(autor);

        System.out.println("\nListando todos os autores:");
        List<Autor> autores = autorDao.listarTodosAutores();
        autores.forEach(a -> System.out.println("Nome: " + a.getNome()));

        System.out.println("\nBuscando autor pelo ID:");
        Autor autorBuscado = autorDao.buscarAutorPorId(1L);
        if (autorBuscado != null) {
            System.out.println("Teste Nome encontrado: " + autorBuscado.getNome());
        } else {
            System.out.println("Teste Autor não encontrado.");
        }
    }
}
