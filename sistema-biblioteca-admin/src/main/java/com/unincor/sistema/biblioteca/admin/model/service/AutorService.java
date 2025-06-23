/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unincor.sistema.biblioteca.admin.model.service;

/**
 *
 * @author Kayla
 */
import com.unincor.sistema.biblioteca.admin.model.dao.AutorDao;
import com.unincor.sistema.biblioteca.admin.model.domain.Autor; 
import java.sql.SQLException; 
import java.time.LocalDate;
import java.util.List; 

public class AutorService {
    
    private final AutorDao autorDao = new AutorDao(); 
     
    public void salvarAutor(Autor autor) throws CadastroException, 
SQLException { 
        if (autor.getNome() == null || autor.getNome().isBlank()) { 
            throw new CadastroException("Nome do autor não pode estar vazio"); 
            //teste
        } 
         
        autorDao.inserirAutor(autor); 
    } 
     
    public Autor buscarPorId(Long id) { 
        return autorDao.buscarAutorPorId(id); 
    } 
     
    public List<Autor> listarTodos() { 
        return autorDao.listarTodosAutores(); 
    } 

    public static void main(String[] args) {
        AutorService autorService = new AutorService();

        Autor autor = new Autor();
        autor.setNome("Clarice Lispector");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(1920, 12, 10));

        try {
            autorService.salvarAutor(autor);
            System.out.println("Autor salvo com sucesso!");
        } catch (CadastroException | SQLException e) {
            System.out.println("Erro ao salvar autor: " + e.getMessage());
        }

    }
}
    
